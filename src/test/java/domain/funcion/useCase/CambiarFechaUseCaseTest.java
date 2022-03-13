package domain.funcion.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.espctaculo.Espectaculo;

import domain.funcion.command.CambiarFecha;
import domain.funcion.entity.PaginaWeb;
import domain.funcion.entity.Ticket;
import domain.funcion.event.FechaCambiada;
import domain.funcion.event.FuncionCreada;
import domain.funcion.value.DatosFuncion;
import domain.funcion.value.Fecha;
import domain.funcion.value.PaginaWebID;
import domain.funcion.value.TicketID;
import domain.generic.Duracion;

import domain.generic.FuncionID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class CambiarFechaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarFecha(){
        FuncionID funcionID = FuncionID.of("xxxx");
        Date date = new Date(2022,03,29);
        Fecha fecha = new Fecha(date);


        var command = new CambiarFecha(funcionID, fecha);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new CambiarFechaUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (FechaCambiada)events.get(0);
        Assertions.assertEquals("domain.funcion.fechacambiada", event.type);
        Assertions.assertEquals(date, event.getFecha().value());
        Assertions.assertEquals(funcionID.value(), event.aggregateRootId());
    }

    private List<DomainEvent> events() {
        DatosFuncion datosFuncion = new DatosFuncion("Function");
        Set<Espectaculo> espectaculos = new HashSet<>();
        Ticket ticket = new Ticket(TicketID.of("ticket"));
        PaginaWeb paginaWeb = new PaginaWeb(PaginaWebID.of("pagina"));
        Date date = new Date(2022,3,20);
        Fecha fecha = new Fecha(date);
        Duracion duracion = new Duracion(18);


        return List.of(new FuncionCreada(datosFuncion,espectaculos,ticket,paginaWeb,fecha,duracion));
    }

}
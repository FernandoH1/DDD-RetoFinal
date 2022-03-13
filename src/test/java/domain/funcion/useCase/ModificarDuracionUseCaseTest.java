package domain.funcion.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import domain.espctaculo.Espectaculo;

import domain.funcion.command.ModificarDuracion;
import domain.funcion.entity.PaginaWeb;
import domain.funcion.entity.Ticket;
import domain.funcion.event.DuracionModificada;
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
class ModificarDuracionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void modificarDuracion(){
        FuncionID funcionID = FuncionID.of("xxxx");
        Duracion duracion = new Duracion(4);


        var command = new ModificarDuracion(funcionID, duracion);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new ModificarDuracionUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DuracionModificada)events.get(0);
        Assertions.assertEquals("domain.funcion.duracionmodificada", event.type);
        Assertions.assertEquals(4, event.getDuracion().value());
        Assertions.assertEquals(funcionID.value(), event.aggregateRootId());
    }

    private List<DomainEvent> events() {
        DatosFuncion datosFuncion = new DatosFuncion("Function1");
        Duracion duracion = new Duracion(20);
        Set<Espectaculo> espectaculos = new HashSet<>();
        Ticket ticket = new Ticket(TicketID.of("ticket"));
        PaginaWeb paginaWeb = new PaginaWeb(PaginaWebID.of("pagina"));
        Date date = new Date(2022,3,23);
        Fecha fecha = new Fecha(date);
        return List.of(new FuncionCreada(datosFuncion,espectaculos,ticket,paginaWeb,fecha,duracion));
    }

}
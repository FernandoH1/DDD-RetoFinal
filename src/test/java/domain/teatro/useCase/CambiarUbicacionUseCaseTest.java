package domain.teatro.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.generic.Direccion;
import domain.generic.TeatroID;
import domain.sala.Sala;
import domain.teatro.command.CambiarUbicacion;
import domain.teatro.event.TeatroCreado;
import domain.teatro.event.UbicacionModificada;
import domain.teatro.value.Departamento;
import domain.teatro.value.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class CambiarUbicacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarUbicacion(){
        TeatroID teatroID = TeatroID.of("xxxx");
        Direccion direccion = new Direccion("oribe","300");
        Departamento departamento = new Departamento("Soraino");
        Ubicacion ubicacion = new Ubicacion(departamento,direccion);

        var command = new CambiarUbicacion(teatroID, ubicacion);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new CambiarUbicacionUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (UbicacionModificada)events.get(0);
        Assertions.assertEquals("domain.teatro.ubicacionmodificada", event.type);
        Assertions.assertEquals("Rocha", event.getUbicacion());
        Assertions.assertEquals(teatroID.value(), event.aggregateRootId());
    }

    private List<DomainEvent> events() {
        Direccion direccion = new Direccion("artigas","301");
        Departamento departamento = new Departamento("Maldonado");
        Ubicacion ubicacion = new Ubicacion(departamento,direccion);
        Set<Sala> sala = new HashSet<>();

        return List.of(new TeatroCreado(ubicacion,sala));
    }

}
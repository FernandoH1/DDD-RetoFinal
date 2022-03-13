package domain.sala.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.funcion.Funcion;

import domain.generic.SalaID;

import domain.sala.command.CambiarCapacidad;
import domain.sala.entity.Asiento;
import domain.sala.entity.Planta;
import domain.sala.event.ModificarCapacidad;
import domain.sala.event.SalaCreada;
import domain.sala.value.Capacidad;

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
class CambiarCapacidadUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarCapacidad(){
        SalaID salaID = SalaID.of("xxxx");
        Capacidad capacidad = new Capacidad(20);


        var command = new CambiarCapacidad(salaID, capacidad);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new CambiarCapacidadUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ModificarCapacidad)events.get(0);
        Assertions.assertEquals("domain.sala.modificarcapacidad", event.type);
        Assertions.assertEquals(20, event.getCapacidad().value());
        Assertions.assertEquals(salaID.value(), event.aggregateRootId());
    }

    private List<DomainEvent> events() {
        Set<Asiento> asientos = new HashSet<>();
        Set<Planta> plantas = new HashSet<>();
        Set<Funcion> funcions = new HashSet<>();
        Capacidad capacidad = new Capacidad(10);


        return List.of(new SalaCreada(asientos,plantas,capacidad,funcions));
    }
}
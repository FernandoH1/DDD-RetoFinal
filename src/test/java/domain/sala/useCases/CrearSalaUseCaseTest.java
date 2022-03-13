package domain.sala.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.funcion.Funcion;
import domain.generic.SalaID;
import domain.sala.command.CrearSala;
import domain.sala.entity.Asiento;
import domain.sala.entity.Planta;
import domain.sala.event.SalaCreada;
import domain.sala.value.Capacidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;


class CrearSalaUseCaseTest {

    @Test
    void crearSala(){
        //arrange
        SalaID salaID = SalaID.of("xxxx");
        Capacidad capacidad = new Capacidad(20);
        Set<Asiento> asientos = new HashSet<>();
        Set<Planta> plantas = new HashSet<>();
        Set<Funcion> funcions = new HashSet<>();

        var command = new CrearSala(salaID,asientos,plantas,capacidad,funcions);
        var useCase = new CrearSalaUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (SalaCreada)events.get(0);
        Assertions.assertEquals("domain.sala.salacreada", event.type);
        Assertions.assertEquals(asientos, event.getAsiento());
        Assertions.assertEquals(plantas, event.getPlanta());
        Assertions.assertEquals(funcions, event.getFunciones());
        Assertions.assertEquals(20, event.getCapacidad().value());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }

}
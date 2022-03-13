package domain.teatro.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.generic.Direccion;
import domain.generic.TeatroID;
import domain.sala.Sala;
import domain.teatro.command.CrearTeatro;
import domain.teatro.event.TeatroCreado;
import domain.teatro.value.Departamento;
import domain.teatro.value.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;


class CrearTeatroUseCaseTest {

    @Test
    void crearTeatro(){
        //arrange
        TeatroID teatroID = TeatroID.of("xxxx");
        Direccion direccion = new Direccion("oribe","300");
        Departamento departamento = new Departamento("Soraino");
        Ubicacion ubicacion = new Ubicacion(departamento,direccion);
        Set<Sala> sala = new HashSet<>();



        var command = new CrearTeatro(teatroID,ubicacion,sala);
        var useCase = new CrearTeatroUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (TeatroCreado)events.get(0);
        Assertions.assertEquals("doamin.teatro.teatrocreado", event.type);
        Assertions.assertEquals("oribe", event.getUbicacion().value().direccion().getCalle());
        Assertions.assertEquals("300", event.getUbicacion().value().direccion().getNumero());
        Assertions.assertEquals(sala, event.getSalas());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }
}
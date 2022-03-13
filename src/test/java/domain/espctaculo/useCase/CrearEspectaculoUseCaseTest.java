package domain.espctaculo.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;

import domain.espctaculo.command.CrearEspectaculo;
import domain.espctaculo.entity.Artista;
import domain.espctaculo.entity.Espectador;
import domain.espctaculo.event.EspectaculoCreado;
import domain.generic.Duracion;
import domain.generic.EspectaculoID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;


class CrearEspectaculoUseCaseTest {

    @Test
    void crearEspectaculo(){
        //arrange
        EspectaculoID espectaculoID = EspectaculoID.of("xxxx");
        Duracion duracion = new Duracion(3);
        Set<Artista> artistas = new HashSet<>();
        Set<Espectador> espectadores = new HashSet<>();


        var command = new CrearEspectaculo(espectaculoID,duracion,artistas,espectadores);
        var useCase = new CrearEspectaculoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EspectaculoCreado)events.get(0);
        Assertions.assertEquals("domain.espectaculo.espectaculocreado", event.type);
        Assertions.assertEquals(artistas, event.getArtistas());
        Assertions.assertEquals(espectadores, event.getEspectadores());
        Assertions.assertEquals(3, event.getDuracion().value());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }

}
package domain.espctaculo.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.espctaculo.command.CambiarDuracion;
import domain.espctaculo.entity.Artista;
import domain.espctaculo.entity.Espectador;
import domain.espctaculo.event.DuracionCambiada;
import domain.espctaculo.event.EspectaculoCreado;

import domain.generic.Duracion;
import domain.generic.EspectaculoID;

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
class CambiarDuracionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarDuracion(){
        EspectaculoID espectaculoID = EspectaculoID.of("xxxx");
        Duracion duracion = new Duracion(7);


        var command = new CambiarDuracion(espectaculoID, duracion);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new CambiarDuracionUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DuracionCambiada)events.get(0);
        Assertions.assertEquals("domain.espectaculo.duracioncambiada", event.type);
        Assertions.assertEquals(7, event.getDuracion().value());
        Assertions.assertEquals(espectaculoID.value(), event.aggregateRootId());
    }

    private List<DomainEvent> events() {
        Duracion duracion = new Duracion(20);
        Set<Artista> artistas = new HashSet<>();
        Set<Espectador> espectadores = new HashSet<>();


        return List.of(new EspectaculoCreado(duracion,artistas,espectadores));
    }

}
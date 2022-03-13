package domain.espctaculo.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NotificarCambioDuracionTest {
    @Mock
    private DomainEventRepository repository;

    @Mock
    private SmsEspectaculoService servicio;

    @Test
    void enviarMensaje() {

        var evento = new DuracionCambiada(new Duracion(20));

        evento.setAggregateRootId("xxxx");

        var useCase = new NotificarCambioDuracion();
        Mockito.when(repository.getEventsBy("espectaculo","xxxx")).thenReturn(historico());
        Mockito.when(servicio.enviarMensaje(Mockito.any(EspectaculoID.class), Mockito.anyString())).thenReturn(true);

        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(servicio));

        var isPresent = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new TriggeredEvent<>(evento)).isPresent();
        Assertions.assertTrue(isPresent);
    }

    @Test
    void errorAlEnviarMensaje() {

        var evento = new DuracionCambiada(new Duracion(20));

        evento.setAggregateRootId("xxxx");

        var useCase = new NotificarCambioDuracion();
        Mockito.when(repository.getEventsBy("espectaculo","xxxx")).thenReturn(historico());
        Mockito.when(servicio.enviarMensaje(Mockito.any(EspectaculoID.class), Mockito.anyString())).thenReturn(false);

        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(servicio));

        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor("xxxx")
                    .syncExecutor(useCase, new TriggeredEvent<>(evento));
        }).getMessage();

        Assertions.assertEquals("El mensaje no pudo ser enviado", mensaje);
    }

    private List<DomainEvent> historico() {
        Duracion duracion = new Duracion(20);
        Set<Artista> artistas = new HashSet<>();
        Set<Espectador> espectadores = new HashSet<>();


        return List.of(new EspectaculoCreado(duracion,artistas,espectadores));
    }


}
package domain.teatro.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.generic.Direccion;
import domain.generic.TeatroID;
import domain.sala.Sala;
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
class NotificarCambioUbicacionTest {

    @Mock
    private DomainEventRepository repository;

    @Mock
    private SmsTeatroService servicio;

    @Test
    void enviarMensaje() {

        var evento = new UbicacionModificada(new Ubicacion(new Departamento("soriano"), new Direccion("Artigas","202")));

        evento.setAggregateRootId("xxxx");

        var useCase = new NotificarCambioUbicacion();
        Mockito.when(repository.getEventsBy("teatro","xxxx")).thenReturn(historico());
        Mockito.when(servicio.enviarMensaje(Mockito.any(TeatroID.class), Mockito.anyString())).thenReturn(true);

        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(servicio));

        var isPresent = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new TriggeredEvent<>(evento)).isPresent();
        Assertions.assertTrue(isPresent);
    }

    @Test
    void errorAlEnviarMensaje() {

        var evento = new UbicacionModificada(new Ubicacion(new Departamento("soriano"), new Direccion("Artigas","202")));

        evento.setAggregateRootId("xxxx");

        var useCase = new NotificarCambioUbicacion();
        Mockito.when(repository.getEventsBy("teatro","xxxx")).thenReturn(historico());
        Mockito.when(servicio.enviarMensaje(Mockito.any(TeatroID.class), Mockito.anyString())).thenReturn(false);

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
        Direccion direccion = new Direccion("artigas","301");
        Departamento departamento = new Departamento("Maldonado");
        Ubicacion ubicacion = new Ubicacion(departamento,direccion);
        Set<Sala> sala = new HashSet<>();

        return List.of(new TeatroCreado(ubicacion,sala));
    }
}
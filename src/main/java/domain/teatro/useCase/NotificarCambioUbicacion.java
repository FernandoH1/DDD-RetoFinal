package domain.teatro.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

import domain.generic.TeatroID;
import domain.teatro.Teatro;
import domain.teatro.event.UbicacionModificada;

import java.util.List;

public class NotificarCambioUbicacion extends UseCase<TriggeredEvent<UbicacionModificada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<UbicacionModificada> input) {
        var event = input.getDomainEvent();
        var service = getService(SmsTeatroService.class).orElseThrow();

        var events = repository().getEventsBy("teatro", event.aggregateRootId());
        var teatro = Teatro.from(TeatroID.of(event.aggregateRootId()), events);

        var esOK = service.enviarMensaje(teatro.identity(), String.format("Se cambio la Ubicacion del Teatro con exito!"));

        if(esOK){
            emit().onResponse(new ResponseEvents(List.of()));
        }
        throw new BusinessException(event.aggregateRootId(), "El mensaje no pudo ser enviado");
    }
}

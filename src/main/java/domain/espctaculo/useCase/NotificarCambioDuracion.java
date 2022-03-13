package domain.espctaculo.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.espctaculo.Espectaculo;
import domain.espctaculo.event.DuracionCambiada;
import domain.generic.EspectaculoID;

import java.util.List;


public class NotificarCambioDuracion extends UseCase<TriggeredEvent<DuracionCambiada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<DuracionCambiada> input) {
        var event = input.getDomainEvent();
        var service = getService(SmsEspectaculoService.class).orElseThrow();

        var events = repository().getEventsBy("espectaculo", event.aggregateRootId());
        var espectaculo = Espectaculo.from(EspectaculoID.of(event.aggregateRootId()), events);

        var esOK = service.enviarMensaje(espectaculo.identity(), String.format("Se cambio la duracion del espectaculo con exito!"));

        if(esOK){
            emit().onResponse(new ResponseEvents(List.of()));
        }
        throw new BusinessException(event.aggregateRootId(), "El mensaje no pudo ser enviado");
    }
}

package domain.espctaculo.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.espctaculo.Espectaculo;
import domain.espctaculo.command.CambiarDuracion;

public class CambiarDuracionUseCase extends UseCase<RequestCommand<CambiarDuracion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarDuracion> input) {
        var command = input.getCommand();
        var espectaculo = Espectaculo.from(command.getEspectaculoID(),retrieveEvents());
        try {
            espectaculo.cambiarDuracion(command.getDuracion());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getEspectaculoID().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(espectaculo.getUncommittedChanges()));
    }
}

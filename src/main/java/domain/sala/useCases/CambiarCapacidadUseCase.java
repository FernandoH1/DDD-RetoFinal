package domain.sala.useCases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.sala.Sala;
import domain.sala.command.CambiarCapacidad;

public class CambiarCapacidadUseCase extends UseCase<RequestCommand<CambiarCapacidad>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarCapacidad> input) {
        var command = input.getCommand();
        var sala = Sala.from(command.getSalaID(), retrieveEvents());
        try{
            sala.cambiarCapacidad(command.getCapacidad());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getSalaID().value(), e.getMessage());

        }
        emit().onResponse(new ResponseEvents(sala.getUncommittedChanges()));
    }
}

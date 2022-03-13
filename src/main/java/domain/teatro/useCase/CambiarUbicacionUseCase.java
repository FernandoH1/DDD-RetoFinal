package domain.teatro.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import domain.teatro.Teatro;
import domain.teatro.command.CambiarUbicacion;


public class CambiarUbicacionUseCase extends UseCase<RequestCommand<CambiarUbicacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarUbicacion> input) {
        var command = input.getCommand();
        var teatro = Teatro.from(command.getTeatroID(), retrieveEvents());
        try{
            teatro.cambiarUbicacion(command.getUbicacion());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getTeatroID().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(teatro.getUncommittedChanges()));
    }
}

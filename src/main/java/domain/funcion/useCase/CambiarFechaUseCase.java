package domain.funcion.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.funcion.Funcion;
import domain.funcion.command.CambiarFecha;

public class CambiarFechaUseCase extends UseCase<RequestCommand<CambiarFecha>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarFecha> input) {
        var command = input.getCommand();
        var funcion = Funcion.from(command.getFuncionID(),retrieveEvents());
        try{
            funcion.cambiarFecha(command.getFecha());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getFuncionID().value(), e.getMessage());

        }
        emit().onResponse(new ResponseEvents(funcion.getUncommittedChanges()));
    }
}

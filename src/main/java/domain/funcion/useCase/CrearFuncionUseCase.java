package domain.funcion.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.funcion.Funcion;
import domain.funcion.command.CrearFuncion;

public class CrearFuncionUseCase extends UseCase<RequestCommand<CrearFuncion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearFuncion> input) {
        var command = input.getCommand();
        var funcion = new Funcion(command.getFuncionID(),command.getDatosFuncion(),command.getEspctaculos(),
                command.getTicket(),command.getPaginaWeb(),command.getFecha(),command.getDuracion());
        emit().onResponse(new ResponseEvents(funcion.getUncommittedChanges()));
    }
}

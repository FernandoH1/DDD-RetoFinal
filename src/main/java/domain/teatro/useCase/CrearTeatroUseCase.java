package domain.teatro.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.teatro.Teatro;
import domain.teatro.command.CrearTeatro;

public class CrearTeatroUseCase extends UseCase<RequestCommand<CrearTeatro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearTeatro> input) {
        var command = input.getCommand();
        var teatro = new Teatro(command.getTeatroID(), command.getUbicacion(), command.getSalas());
        emit().onResponse(new ResponseEvents(teatro.getUncommittedChanges()));
    }
}

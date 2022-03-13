package domain.sala.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.sala.Sala;
import domain.sala.command.CrearSala;

public class CrearSalaUseCase extends UseCase<RequestCommand<CrearSala>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearSala> input) {
        var command = input.getCommand();
        var sala = new Sala(command.getSalaID(),command.getAsiento(), command.getPlanta(),
                command.getCapacidad(),command.getFunciones());
        emit().onResponse(new ResponseEvents(sala.getUncommittedChanges()));

    }
}

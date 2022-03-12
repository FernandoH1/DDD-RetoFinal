package domain.espctaculo.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.espctaculo.Espectaculo;
import domain.espctaculo.command.CrearEspectaculo;

public class CrearEspectaculoUseCase extends UseCase<RequestCommand<CrearEspectaculo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearEspectaculo> input) {
        var command = input.getCommand();
        var espectaculo = new Espectaculo(command.getEspectaculoID(),command.getDuracion(),command.getArtistas(),
                command.getEspectadores());
        emit().onResponse(new ResponseEvents(espectaculo.getUncommittedChanges()));
    }
}

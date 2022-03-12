package domain.teatro.command;

import co.com.sofka.domain.generic.Command;
import domain.generic.TeatroID;
import domain.teatro.value.Ubicacion;

public class CambiarUbicacion extends Command {
    private final TeatroID teatroID;
    private final Ubicacion ubicacion;


    public CambiarUbicacion(TeatroID teatroID, Ubicacion ubicacion) {
        this.teatroID = teatroID;
        this.ubicacion = ubicacion;
    }

    public TeatroID getTeatroID() {
        return teatroID;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}

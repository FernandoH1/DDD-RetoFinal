package domain.espctaculo.command;

import co.com.sofka.domain.generic.Command;
import domain.generic.Duracion;
import domain.generic.EspectaculoID;

public class CambiarDuracion extends Command {
    private final EspectaculoID espectaculoID;
    private final Duracion duracion;

    public CambiarDuracion(EspectaculoID espectaculoID, Duracion duracion) {
        this.espectaculoID = espectaculoID;
        this.duracion = duracion;
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}

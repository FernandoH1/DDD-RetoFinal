package domain.teatro.command;

import co.com.sofka.domain.generic.Command;
import domain.generic.TeatroID;
import domain.sala.Sala;
import domain.teatro.value.Ubicacion;

import java.util.Set;

public class CrearTeatro extends Command {
    private final TeatroID teatroID;
    private final Ubicacion ubicacion;
    private final Set<Sala> salas;

    public CrearTeatro(TeatroID teatroID, Ubicacion ubicacion, Set<Sala> salas) {
        this.teatroID = teatroID;
        this.ubicacion = ubicacion;
        this.salas = salas;
    }

    public TeatroID getTeatroID() {
        return teatroID;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Set<Sala> getSalas() {
        return salas;
    }
}

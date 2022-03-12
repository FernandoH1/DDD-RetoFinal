package domain.sala.command;

import co.com.sofka.domain.generic.Command;
import domain.generic.SalaID;
import domain.sala.value.Capacidad;

public class CambiarCapacidad extends Command {
    private final SalaID salaID;
    private final Capacidad capacidad;


    public CambiarCapacidad(SalaID salaID, Capacidad capacidad) {
        this.salaID = salaID;
        this.capacidad = capacidad;
    }

    public SalaID getSalaID() {
        return salaID;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}

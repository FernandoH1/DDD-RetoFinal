package domain.sala.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.sala.value.Capacidad;

public class ModificarCapacidad extends DomainEvent {
    private final Capacidad capacidad;


    public ModificarCapacidad(Capacidad capacidad) {
        super("domain.sala.modificarcapacidad");
        this.capacidad = capacidad;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}

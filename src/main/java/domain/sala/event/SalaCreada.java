package domain.sala.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.funcion.Funcion;
import domain.sala.entity.Asiento;
import domain.sala.entity.Planta;
import domain.sala.value.Capacidad;

import java.util.Set;

public class SalaCreada extends DomainEvent {
    private final Set<Asiento> asiento;
    private final Set<Planta> planta;
    private final Capacidad capacidad;
    private final Set<Funcion> funciones;

    public SalaCreada(Set<Asiento> asiento, Set<Planta> planta, Capacidad capacidad, Set<Funcion> funciones) {
        super("domain.sala.salacreada");
        this.asiento = asiento;
        this.planta = planta;
        this.capacidad = capacidad;
        this.funciones = funciones;
    }

    public Set<Asiento> asientos() {
        return asiento;
    }

    public Set<Planta> planta() {
        return planta;
    }

    public Capacidad capacidad() {
        return capacidad;
    }

    public Set<Funcion> funciones() {
        return funciones;
    }
}

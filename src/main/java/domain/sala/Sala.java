package domain.sala;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.funcion.Funcion;
import domain.generic.SalaID;
import domain.sala.entity.Asiento;
import domain.sala.entity.Planta;
import domain.sala.event.ModificarCapacidad;
import domain.sala.event.SalaCreada;
import domain.sala.value.Capacidad;

import java.util.List;
import java.util.Set;


public class Sala extends AggregateEvent<SalaID> {
    protected Set<Asiento> asiento;
    protected Set<Planta> planta;
    protected Capacidad capacidad;
    protected Set<Funcion> funciones;

    public Sala(SalaID salaID, Set<Asiento> asiento, Set<Planta> planta, Capacidad capacidad, Set<Funcion> funciones) {
        super(salaID);
        appendChange(new SalaCreada(asiento, planta, capacidad, funciones)).apply();
    }

    private Sala(SalaID salaID){
        super(salaID);
        subscribe(new SalaChange(this));
    }

    public static Sala from(SalaID salaID, List<DomainEvent> events){
        var sala = new Sala(salaID);
        events.forEach(sala::applyEvent);
        return sala;
    }

    public void cambiarCapacidad(Capacidad capacidad){
        appendChange(new ModificarCapacidad(capacidad)).apply();
    }

    public Set<Asiento> asiento() {
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

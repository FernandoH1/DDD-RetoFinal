package domain.sala;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.funcion.Funcion;
import domain.generic.SalaID;
import domain.sala.entity.Asiento;
import domain.sala.entity.Planta;
import domain.sala.value.Capacidad;

import java.util.Set;


public class Sala extends AggregateEvent<SalaID> {
    protected SalaID salaID;
    protected Set<Asiento> asiento;
    protected Set<Planta> planta;
    protected Capacidad capacidad;
    protected Set<Funcion> funciones;


    public Sala(SalaID entityId) {
        super(entityId);
    }
}

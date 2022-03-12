package domain.sala.command;

import co.com.sofka.domain.generic.Command;
import domain.funcion.Funcion;
import domain.generic.SalaID;
import domain.sala.entity.Asiento;
import domain.sala.entity.Planta;
import domain.sala.value.Capacidad;

import java.util.Set;

public class CrearSala extends Command {
    private final SalaID salaID;
    private final Set<Asiento> asiento;
    private final Set<Planta> planta;
    private final Capacidad capacidad;
    private final Set<Funcion> funciones;


    public CrearSala(SalaID salaID, Set<Asiento> asiento, Set<Planta> planta, Capacidad capacidad, Set<Funcion> funciones) {
        this.salaID = salaID;
        this.asiento = asiento;
        this.planta = planta;
        this.capacidad = capacidad;
        this.funciones = funciones;
    }

    public SalaID getSalaID() {
        return salaID;
    }

    public Set<Asiento> getAsiento() {
        return asiento;
    }

    public Set<Planta> getPlanta() {
        return planta;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public Set<Funcion> getFunciones() {
        return funciones;
    }
}

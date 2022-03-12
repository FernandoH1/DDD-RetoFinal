package domain.sala;

import co.com.sofka.domain.generic.EventChange;
import domain.sala.event.ModificarCapacidad;
import domain.sala.event.SalaCreada;

import java.util.HashSet;

public class SalaChange extends EventChange {
    public SalaChange(Sala sala) {
        apply((SalaCreada event) -> {
            sala.asiento = event.getAsiento();
            sala.planta = event.getPlanta();
            sala.capacidad = event.getCapacidad();
            sala.funciones = new HashSet<>();
        });

        apply((ModificarCapacidad event) -> {
            sala.capacidad = event.getCapacidad();
        });
    }
}

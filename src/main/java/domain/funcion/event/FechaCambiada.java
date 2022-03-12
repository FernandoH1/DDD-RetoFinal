package domain.funcion.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.funcion.value.Fecha;

public class FechaCambiada extends DomainEvent {
    private final Fecha fecha;


    public FechaCambiada(Fecha fecha) {
        super("domain.funcion.fechacambiada");
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}

package domain.funcion.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.generic.Duracion;

public class DuracionModificada extends DomainEvent {
    private final Duracion duracion;

    public DuracionModificada(Duracion duracion) {
        super("domain.funcion.duracionmodificada");
        this.duracion = duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}

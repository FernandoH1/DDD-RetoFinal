package domain.espctaculo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.generic.Duracion;

public class DuracionCambiada extends DomainEvent {
    private final Duracion duracion;

    public DuracionCambiada(Duracion duracion) {
        super("domain.espectaculo.duracioncambiada");
        this.duracion = duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}

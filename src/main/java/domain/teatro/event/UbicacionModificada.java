package domain.teatro.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.teatro.value.Ubicacion;

public class UbicacionModificada extends DomainEvent {
    private final Ubicacion ubicacion;

    public UbicacionModificada(Ubicacion ubicacion) {
        super("domain.teatro.ubicacionmodificada");
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}

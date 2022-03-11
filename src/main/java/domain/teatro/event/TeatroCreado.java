package domain.teatro.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.sala.Sala;
import domain.teatro.value.Ubicacion;

import java.util.Set;

public class TeatroCreado extends DomainEvent {
    private final Ubicacion ubicacion;
    private final Set<Sala> salas;

    public TeatroCreado(Ubicacion ubicacion, Set<Sala> salas) {
        super("doamin.teatro.teatrocreado");
        this.ubicacion = ubicacion;
        this.salas = salas;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }

    public Set<Sala> salas() {
        return salas;
    }
}

package domain.espctaculo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.espctaculo.value.*;

public class EspectadorAgregado extends DomainEvent {
    private final EspectadorID espectadorID;
    private final DatosEspectador datosEspectador;

    public EspectadorAgregado(EspectadorID espectadorID, DatosEspectador datosEspectador) {
        super("domain.espectaculo.artistaagregado");
        this.espectadorID = espectadorID;
        this.datosEspectador = datosEspectador;
    }

    public EspectadorID getEspectadorID() {
        return espectadorID;
    }

    public DatosEspectador getDatosEspectador() {
        return datosEspectador;
    }
}

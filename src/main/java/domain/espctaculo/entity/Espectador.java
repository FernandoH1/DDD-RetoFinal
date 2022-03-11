package domain.espctaculo.entity;

import co.com.sofka.domain.generic.Entity;
import domain.espctaculo.value.DatosEspectador;
import domain.espctaculo.value.EspectadorID;

public class Espectador extends Entity<EspectadorID> {
    protected EspectadorID espectadorID;
    protected DatosEspectador datosEspectador;

    public Espectador(EspectadorID entityId) {
        super(entityId);
    }

    public Espectador(EspectadorID entityId, EspectadorID espectadorID, DatosEspectador datosEspectador) {
        super(entityId);
        this.espectadorID = espectadorID;
        this.datosEspectador = datosEspectador;
    }
}

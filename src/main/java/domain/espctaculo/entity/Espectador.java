package domain.espctaculo.entity;

import co.com.sofka.domain.generic.Entity;
import domain.espctaculo.value.DatosEspectador;
import domain.espctaculo.value.EspectadorID;

import java.util.Objects;

public class Espectador extends Entity<EspectadorID> {
    private DatosEspectador datosEspectador;

    public Espectador(EspectadorID espectadorID, DatosEspectador datosEspectador) {
        super(espectadorID);
        this.datosEspectador = datosEspectador;
    }

    public DatosEspectador datosEspectador() {
        return datosEspectador;
    }

    public void modificarDatosEspectador(EspectadorID espectadorID, DatosEspectador datosEspectador){
        this.datosEspectador = Objects.requireNonNull(datosEspectador);
    }
}

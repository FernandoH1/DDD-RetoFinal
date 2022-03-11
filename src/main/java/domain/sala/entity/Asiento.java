package domain.sala.entity;


import co.com.sofka.domain.generic.Entity;
import domain.sala.value.AsientoID;
import domain.sala.value.PlantaID;
import domain.sala.value.TipoAsiento;

public class Asiento extends Entity<AsientoID> {
 private TipoAsiento tipoAsiento;
 private PlantaID plantaID;

    public Asiento(AsientoID asientoID, TipoAsiento tipoAsiento, PlantaID plantaID) {
        super(asientoID);
        this.tipoAsiento = tipoAsiento;
        this.plantaID = plantaID;
    }

    public TipoAsiento tipoAsiento() {
        return tipoAsiento;
    }

    public PlantaID plantaID() {
        return plantaID;
    }
}

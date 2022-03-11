package domain.sala.entity;


import co.com.sofka.domain.generic.Entity;
import domain.sala.value.AsientoID;
import domain.sala.value.PlantaID;
import domain.sala.value.TipoAsiento;

public class Asiento extends Entity<AsientoID> {
 protected AsientoID asientoID;
 protected TipoAsiento tipoAsiento;
 protected PlantaID plantaID;


    public Asiento(AsientoID entityId) {
        super(entityId);
    }
}

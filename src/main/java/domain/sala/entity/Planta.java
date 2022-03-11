package domain.sala.entity;

import co.com.sofka.domain.generic.Entity;
import domain.sala.value.PlantaBaja;
import domain.sala.value.PlantaID;
import domain.sala.value.SegundoPiso;

public class Planta extends Entity<PlantaID> {
    protected PlantaID plantaID;
    protected PlantaBaja plantaBaja;
    protected SegundoPiso segundoPiso;


    public Planta(PlantaID entityId) {
        super(entityId);
    }

    public Planta(PlantaID entityId, PlantaID plantaID, PlantaBaja plantaBaja, SegundoPiso segundoPiso) {
        super(entityId);
        this.plantaID = plantaID;
        this.plantaBaja = plantaBaja;
        this.segundoPiso = segundoPiso;
    }
}

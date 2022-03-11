package domain.sala.entity;

import co.com.sofka.domain.generic.Entity;
import domain.sala.value.PlantaBaja;
import domain.sala.value.PlantaID;
import domain.sala.value.SegundoPiso;

public class Planta extends Entity<PlantaID> {
    private PlantaBaja plantaBaja;
    private SegundoPiso segundoPiso;


    public Planta(PlantaID plantaID, PlantaBaja plantaBaja, SegundoPiso segundoPiso) {
        super(plantaID);
        this.plantaBaja = plantaBaja;
        this.segundoPiso = segundoPiso;
    }

    public PlantaBaja plantaBaja() {
        return plantaBaja;
    }

    public SegundoPiso segundoPiso() {
        return segundoPiso;
    }
}

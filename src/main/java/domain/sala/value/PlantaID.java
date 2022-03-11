package domain.sala.value;

import co.com.sofka.domain.generic.Identity;

public class PlantaID extends Identity {
    private PlantaID(String id){
        super(id);
    }

    public PlantaID(){ }

    public static PlantaID of(String id) {
        return new PlantaID(id);
    }
}
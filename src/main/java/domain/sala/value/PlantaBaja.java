package domain.sala.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PlantaBaja implements ValueObject<String> {
    private final String plantaBaja;

    public PlantaBaja(String plantaBaja) {
        this.plantaBaja = Objects.requireNonNull(plantaBaja);
        if(plantaBaja == null){
            throw new IllegalArgumentException("La PlantaBaja No puede ser vacio");
        }
    }

    @Override
    public String value() {
        return plantaBaja;
    }
}

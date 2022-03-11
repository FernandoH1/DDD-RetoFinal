package domain.sala.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SegundoPiso implements ValueObject<String> {
    private final String segundoPiso;

    public SegundoPiso(String segundoPiso) {
        this.segundoPiso = Objects.requireNonNull(segundoPiso);
        if(segundoPiso == null){
            throw new IllegalArgumentException("La PlantaBaja No puede ser vacio");
        }
    }

    @Override
    public String value() {
        return segundoPiso;
    }
}


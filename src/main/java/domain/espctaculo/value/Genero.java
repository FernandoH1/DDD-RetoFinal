package domain.espctaculo.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Genero implements ValueObject<String> {
    private final String genero;

    public Genero(String genero) {
        this.genero = Objects.requireNonNull(genero);
        if(genero == null){
            throw new IllegalArgumentException("El Genero No puede ser vacio");
        }
    }

    @Override
    public String value() {
        return genero;
    }
}


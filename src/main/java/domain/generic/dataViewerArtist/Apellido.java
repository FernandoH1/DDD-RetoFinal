package domain.generic.dataViewerArtist;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Apellido implements ValueObject<String> {
    private final String apellido;

    public Apellido(String apellido) {
        this.apellido = Objects.requireNonNull(apellido);
        if(apellido == null){
            throw new IllegalArgumentException("El Apellido No puede ser vacio");
        }
    }

    @Override
    public String value() {
        return apellido;
    }
}
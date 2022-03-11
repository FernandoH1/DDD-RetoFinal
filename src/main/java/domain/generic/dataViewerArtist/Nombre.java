package domain.generic.dataViewerArtist;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String nombre;

    public Nombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if(nombre == null){
            throw new IllegalArgumentException("El Nombre No puede ser vacio");
        }
    }

    @Override
    public String value() {
        return nombre;
    }
}

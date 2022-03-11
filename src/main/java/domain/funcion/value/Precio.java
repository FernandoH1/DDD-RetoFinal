package domain.funcion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Integer> {
    private final Integer precio;

    public Precio(Integer precio) {
        this.precio = Objects.requireNonNull(precio);
        if(precio <= 0){
            throw new IllegalArgumentException("El Precio No puede ser vacio");
        }
    }

    @Override
    public Integer value() {
        return precio;
    }
}
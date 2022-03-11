package domain.sala.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capacidad implements ValueObject<Integer> {
    private final Integer capacidad;

    public Capacidad(Integer capacidad) {
        this.capacidad = Objects.requireNonNull(capacidad);
        if(capacidad <= 0){
            throw new IllegalArgumentException("La Capacidad No puede ser vacio");
        }
    }

    @Override
    public Integer value() {
        return capacidad;
    }
}

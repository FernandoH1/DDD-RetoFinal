package domain.generic;

import co.com.sofka.domain.generic.ValueObject;


import java.util.Objects;

public class Duracion implements ValueObject<Integer> {
    private final Integer horas;

    public Duracion(Integer horas) {
        this.horas = Objects.requireNonNull(horas);
        if(horas <= 0){
            throw new IllegalArgumentException("Las horas no pueden ser vacias");
        }
    }

    @Override
    public Integer value() {
        return horas;
    }
}
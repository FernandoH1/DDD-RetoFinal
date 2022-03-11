package domain.funcion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class Plazo implements ValueObject<Date> {
    private final Date fecha;

    public Plazo(Date fecha) {
        this.fecha = Objects.requireNonNull(fecha);
        if(fecha == null){
            throw new IllegalArgumentException("El plazo No puede ser vacio");
        }
    }

    @Override
    public Date value() {
        return fecha;
    }
}

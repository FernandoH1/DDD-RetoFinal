package domain.funcion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InformacionFuncion implements ValueObject<String> {
    private final String nombreFuncion;

    public InformacionFuncion(String nombreFuncion) {
        this.nombreFuncion = Objects.requireNonNull(nombreFuncion);
        if(nombreFuncion == null){
            throw new IllegalArgumentException("El video Promocional No puede ser vacio");
        }
    }

    @Override
    public String value() {
        return nombreFuncion;
    }
}

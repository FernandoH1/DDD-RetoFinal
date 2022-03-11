package domain.funcion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosFuncion implements ValueObject<String> {
    private final String nombreFuncion;

    public DatosFuncion(String nombreFuncion) {
        this.nombreFuncion = Objects.requireNonNull(nombreFuncion);
        if(nombreFuncion == null){
            throw new IllegalArgumentException("El departamento No puede ser vacio");
        }
    }

    @Override
    public String value() {
        return nombreFuncion;
    }
}
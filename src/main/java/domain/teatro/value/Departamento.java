package domain.teatro.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Departamento implements ValueObject<String> {
    private final String departamento;

    public Departamento(String departamento) {
        this.departamento = Objects.requireNonNull(departamento);
        if(departamento == null){
            throw new IllegalArgumentException("El departamento No puede ser vacio");
        }
    }

    @Override
    public String value() {
        return departamento;
    }
}

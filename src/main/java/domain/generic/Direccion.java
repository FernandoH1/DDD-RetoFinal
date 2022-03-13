package domain.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<String> {
    private final String calle;
    private final String numero;

    public Direccion(String calle, String numero) {
        this.calle = Objects.requireNonNull(calle);
        this.numero = Objects.requireNonNull(numero);
        if(calle == null && numero == null){
            throw new IllegalArgumentException("La Calle y el Numero no pueden ser Vacios");
        }
    }

    @Override
    public String value() {
        return calle + numero;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }
}

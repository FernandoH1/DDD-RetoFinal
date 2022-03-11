package domain.espctaculo.value.dataArtist;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {
    private final String email;

    public Email(String email) {
        this.email = Objects.requireNonNull(email);
        if(email == null){
            throw new IllegalArgumentException("El Email No puede ser vacio");
        }
    }

    @Override
    public String value() {
        return email;
    }
}
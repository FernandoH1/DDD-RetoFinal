package domain.funcion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class VideoPromocional implements ValueObject<String> {
    private final String videoPromocional;

    public VideoPromocional(String videoPromocional) {
        this.videoPromocional = Objects.requireNonNull(videoPromocional);
        if(videoPromocional == null){
            throw new IllegalArgumentException("El video Promocional No puede ser vacio");
        }
    }

    @Override
    public String value() {
        return videoPromocional;
    }
}

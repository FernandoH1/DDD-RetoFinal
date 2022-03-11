package domain.sala.value;

import co.com.sofka.domain.generic.ValueObject;

public class TipoAsiento implements ValueObject<TipoAsiento.tipo> {
    private final tipo tipoAsiento;

    public TipoAsiento(tipo tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    @Override
    public tipo value() {
        return tipoAsiento;
    }

    public enum tipo {
        PRIMERACLASE, NORMAL
    }
}
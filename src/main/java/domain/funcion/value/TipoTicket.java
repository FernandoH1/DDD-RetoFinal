package domain.funcion.value;

import co.com.sofka.domain.generic.ValueObject;

public class TipoTicket implements ValueObject<TipoTicket.tipo> {
    private final TipoTicket.tipo tipoTicket;

    public TipoTicket(TipoTicket.tipo tipoTicket) {
        this.tipoTicket = tipoTicket;
    }

    @Override
    public TipoTicket.tipo value() {
        return tipoTicket;
    }

    public enum tipo {
        PRIMERACLASE, NORMAL
    }
}

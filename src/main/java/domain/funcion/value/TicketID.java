package domain.funcion.value;

import co.com.sofka.domain.generic.Identity;
import domain.sala.value.AsientoID;

public class TicketID extends Identity {
    private TicketID(String id){
        super(id);
    }

    public TicketID(){ }

    public static TicketID of(String id) {
        return new TicketID(id);
    }
}

package domain.funcion.value;

import co.com.sofka.domain.generic.Identity;

public class TicketID extends Identity {
    private TicketID(String id){
        super(id);
    }

    public TicketID(){ }

    public static TicketID of(String id) {
        return new TicketID(id);
    }
}

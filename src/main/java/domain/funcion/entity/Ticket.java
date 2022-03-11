package domain.funcion.entity;

import co.com.sofka.domain.generic.Entity;
import domain.funcion.value.Plazo;
import domain.funcion.value.Precio;
import domain.funcion.value.TicketID;
import domain.funcion.value.TipoTicket;


public class Ticket extends Entity<TicketID> {
    private TipoTicket tipoTicket;
    private Precio precio;
    private Plazo plazo;

    public Ticket(TicketID entityId) {
        super(entityId);
    }

    public Ticket(TicketID ticketID, TipoTicket tipoTicket, Precio precio, Plazo plazo) {
        super(ticketID);
        this.tipoTicket = tipoTicket;
        this.precio = precio;
        this.plazo = plazo;
    }

    public TipoTicket tipoTicket() {
        return tipoTicket;
    }

    public Precio precio() {
        return precio;
    }

    public Plazo plazo() {
        return plazo;
    }
}

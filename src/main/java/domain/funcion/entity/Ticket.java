package domain.funcion.entity;

import co.com.sofka.domain.generic.Entity;
import domain.funcion.value.Plazo;
import domain.funcion.value.Precio;
import domain.funcion.value.TicketID;
import domain.funcion.value.TipoTicket;


public class Ticket extends Entity<TicketID> {
    protected TicketID ticketID;
    protected TipoTicket tipoTicket;
    protected Precio precio;
    protected Plazo plazo;

    public Ticket(TicketID entityId) {
        super(entityId);
    }
}

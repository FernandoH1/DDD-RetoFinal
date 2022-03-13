package domain.funcion.command;

import co.com.sofka.domain.generic.Command;
import domain.espctaculo.Espectaculo;
import domain.funcion.entity.PaginaWeb;
import domain.funcion.entity.Ticket;
import domain.funcion.value.DatosFuncion;
import domain.funcion.value.Fecha;
import domain.generic.Duracion;
import domain.generic.FuncionID;

import java.util.Set;

public class CrearFuncion extends Command {
    private final FuncionID funcionID;
    private final DatosFuncion datosFuncion;
    private final Set<Espectaculo> espectaculos;
    private final Ticket ticket;
    private final PaginaWeb paginaWeb;
    private final Fecha fecha;
    private final Duracion duracion;

    public CrearFuncion(FuncionID funcionID, DatosFuncion datosFuncion, Set<Espectaculo> espctaculos, Ticket ticket, PaginaWeb paginaWeb, Fecha fecha, Duracion duracion) {
        this.funcionID = funcionID;
        this.datosFuncion = datosFuncion;
        this.espectaculos = espctaculos;
        this.ticket = ticket;
        this.paginaWeb = paginaWeb;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public FuncionID getFuncionID() {
        return funcionID;
    }

    public DatosFuncion getDatosFuncion() {
        return datosFuncion;
    }

    public Set<Espectaculo> getEspctaculos() {
        return espectaculos;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public PaginaWeb getPaginaWeb() {
        return paginaWeb;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}

package domain.funcion.command;

import co.com.sofka.domain.generic.Command;
import domain.espctaculo.Espctaculo;
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
    private final Set<Espctaculo> espctaculos;
    private final Ticket ticket;
    private final PaginaWeb paginaWeb;
    private final Fecha fecha;
    private final Duracion duracion;

    public CrearFuncion(FuncionID funcionID, DatosFuncion datosFuncion, Set<Espctaculo> espctaculos, Ticket ticket, PaginaWeb paginaWeb, Fecha fecha, Duracion duracion) {
        this.funcionID = funcionID;
        this.datosFuncion = datosFuncion;
        this.espctaculos = espctaculos;
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

    public Set<Espctaculo> getEspctaculos() {
        return espctaculos;
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

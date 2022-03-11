package domain.funcion.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.espctaculo.Espctaculo;
import domain.funcion.entity.PaginaWeb;
import domain.funcion.entity.Ticket;
import domain.funcion.value.DatosFuncion;
import domain.funcion.value.Fecha;
import domain.generic.Duracion;

import java.util.HashSet;
import java.util.Set;

public class FuncionCreada extends DomainEvent {
    private final DatosFuncion datosFuncion;
    private final Set<Espctaculo> espctaculos;
    private final Ticket ticket;
    private final PaginaWeb paginaWeb;
    private final Fecha fecha;
    private final Duracion duracion;

    public FuncionCreada(DatosFuncion datosFuncion, Set<Espctaculo> espctaculos, Ticket ticket, PaginaWeb paginaWeb, Fecha fecha, Duracion duracion) {
        super("domain.funcion.funcioncreada");
        this.datosFuncion = datosFuncion;
        this.espctaculos = new HashSet<>();
        this.ticket = ticket;
        this.paginaWeb = paginaWeb;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public DatosFuncion datosFuncion() {
        return datosFuncion;
    }

    public Set<Espctaculo> espctaculos() {
        return espctaculos;
    }

    public Ticket ticket() {
        return ticket;
    }

    public PaginaWeb paginaWeb() {
        return paginaWeb;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Duracion duracion() {
        return duracion;
    }
}

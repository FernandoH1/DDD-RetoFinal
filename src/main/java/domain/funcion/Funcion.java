package domain.funcion;


import co.com.sofka.domain.generic.AggregateEvent;
import domain.espctaculo.Espctaculo;
import domain.funcion.entity.PaginaWeb;
import domain.funcion.entity.Ticket;
import domain.funcion.event.FuncionCreada;
import domain.funcion.value.DatosFuncion;
import domain.generic.Duracion;
import domain.funcion.value.Fecha;
import domain.generic.FuncionID;

import java.util.Set;

public class Funcion extends AggregateEvent<FuncionID> {
    protected DatosFuncion datosFuncion;
    protected Set<Espctaculo> espctaculos;
    protected Ticket ticket;
    protected PaginaWeb paginaWeb;
    protected Fecha fecha;
    protected Duracion duracion;

    public Funcion(FuncionID funcionID, DatosFuncion datosFuncion, Set<Espctaculo> espctaculos, Ticket ticket, PaginaWeb paginaWeb, Fecha fecha, Duracion duracion) {
        super(funcionID);
        appendChange(new FuncionCreada(datosFuncion,espctaculos,ticket,paginaWeb,fecha,duracion)).apply();
    }


}

package domain.funcion;


import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.espctaculo.Espectaculo;
import domain.funcion.entity.PaginaWeb;
import domain.funcion.entity.Ticket;
import domain.funcion.event.DuracionModificada;
import domain.funcion.event.FechaCambiada;
import domain.funcion.event.FuncionCreada;
import domain.funcion.value.DatosFuncion;
import domain.generic.Duracion;
import domain.funcion.value.Fecha;
import domain.generic.FuncionID;

import java.util.List;
import java.util.Set;

public class Funcion extends AggregateEvent<FuncionID> {
    protected DatosFuncion datosFuncion;
    protected Set<Espectaculo> espectaculos;
    protected Ticket ticket;
    protected PaginaWeb paginaWeb;
    protected Fecha fecha;
    protected Duracion duracion;

    public Funcion(FuncionID funcionID, DatosFuncion datosFuncion, Set<Espectaculo> espectaculos, Ticket ticket, PaginaWeb paginaWeb, Fecha fecha, Duracion duracion) {
        super(funcionID);
        appendChange(new FuncionCreada(datosFuncion, espectaculos,ticket,paginaWeb,fecha,duracion)).apply();
    }

    private Funcion(FuncionID funcionID){
        super(funcionID);
        subscribe(new FuncionChange(this));
    }

    public static Funcion from(FuncionID funcionID, List<DomainEvent> events){
        var funcion = new Funcion(funcionID);
        events.forEach(funcion::applyEvent);
        return funcion;
    }

    public void cambiarFecha(Fecha fecha){
        appendChange(new FechaCambiada(fecha)).apply();
    }

    public void modificarDueracion(Duracion duracion){
        appendChange(new DuracionModificada(duracion)).apply();
    }




}

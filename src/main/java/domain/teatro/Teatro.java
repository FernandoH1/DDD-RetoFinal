package domain.teatro;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.generic.TeatroID;
import domain.sala.Sala;
import domain.teatro.event.TeatroCreado;
import domain.teatro.event.UbicacionModificada;
import domain.teatro.value.Ubicacion;


import java.util.List;
import java.util.Set;

public class Teatro extends AggregateEvent<TeatroID> {
    protected Ubicacion ubicacion;
    protected Set<Sala> salas;


    public Teatro(TeatroID teatroID, Ubicacion ubicacion, Set<Sala> salas) {
        super(teatroID);
        appendChange(new TeatroCreado(ubicacion,salas)).apply();
    }

    private Teatro(TeatroID teatroID){
        super(teatroID);
        subscribe(new TeatroChange(this));
    }

    public static Teatro from(TeatroID teatroID, List<DomainEvent> events){
        var teatro = new Teatro(teatroID);
        events.forEach(teatro::applyEvent);
        return teatro;
    }

    public void cambiarUbicacion(Ubicacion ubicacion){
        appendChange(new UbicacionModificada(ubicacion)).apply();
    }

}

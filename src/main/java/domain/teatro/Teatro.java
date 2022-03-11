package domain.teatro;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.generic.Direccion;
import domain.generic.TeatroID;
import domain.sala.Sala;
import domain.teatro.value.Departamento;
import domain.teatro.value.Ubicacion;


import java.util.Set;

public class Teatro extends AggregateEvent<TeatroID> {
    protected TeatroID teatroID;
    protected Ubicacion ubicacion;
    protected Set<Sala> salas;


    public Teatro(TeatroID entityId) {
        super(entityId);
    }

    public Teatro(TeatroID entityId, TeatroID teatroID, Ubicacion ubicacion, Set<Sala> salas) {
        super(entityId);
        this.teatroID = teatroID;
        this.ubicacion = ubicacion;
        this.salas = salas;
    }
}

package domain.teatro;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.generic.Direccion;
import domain.generic.TeatroID;
import domain.sala.Sala;
import domain.teatro.value.Departamento;
import domain.teatro.value.UbicacionID;

import java.util.Set;

public class Teatro extends AggregateEvent<TeatroID> {
 protected UbicacionID ubicacionID;
 protected Departamento departamento;
 protected Direccion direccion;
 protected Set<Sala> salas;


    public Teatro(TeatroID entityId) {
        super(entityId);
    }
}

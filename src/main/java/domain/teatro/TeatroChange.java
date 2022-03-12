package domain.teatro;

import co.com.sofka.domain.generic.EventChange;
import domain.teatro.event.TeatroCreado;
import domain.teatro.event.UbicacionModificada;


public class TeatroChange extends EventChange {

    public TeatroChange(Teatro teatro) {
        apply((TeatroCreado event) -> {
            teatro.salas = event.getSalas();
            teatro.ubicacion = event.getUbicacion();
        });

        apply((UbicacionModificada event) -> {
            teatro.ubicacion = event.getUbicacion();
        });
    }
}

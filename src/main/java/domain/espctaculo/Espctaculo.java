package domain.espctaculo;


import co.com.sofka.domain.generic.AggregateEvent;
import domain.espctaculo.entity.Artista;
import domain.espctaculo.entity.Espectador;
import domain.generic.Duracion;
import domain.generic.EspctaculoID;

import java.util.Set;

public class Espctaculo extends AggregateEvent<EspctaculoID> {
    protected EspctaculoID espctaculoID;
    protected Duracion duracion;
    protected Set<Artista> artistas;
    protected Set<Espectador> espectadores;

    public Espctaculo(EspctaculoID entityId) {
        super(entityId);
    }
}

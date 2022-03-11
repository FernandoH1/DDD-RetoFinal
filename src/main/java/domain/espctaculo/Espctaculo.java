package domain.espctaculo;


import co.com.sofka.domain.generic.AggregateEvent;
import domain.espctaculo.entity.Artista;
import domain.espctaculo.entity.Espectador;
import domain.espctaculo.event.EspectaculoCreado;
import domain.generic.Duracion;
import domain.generic.EspctaculoID;

import java.util.Set;

public class Espctaculo extends AggregateEvent<EspctaculoID> {
    protected Duracion duracion;
    protected Set<Artista> artistas;
    protected Set<Espectador> espectadores;

    public Espctaculo(EspctaculoID espctaculoID,Duracion duracion, Set<Artista> artistas, Set<Espectador> espectadores) {
        super(espctaculoID);
        appendChange(new EspectaculoCreado(duracion, artistas, espectadores)).apply();
    }
}

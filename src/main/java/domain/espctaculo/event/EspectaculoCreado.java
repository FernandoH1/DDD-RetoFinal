package domain.espctaculo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.espctaculo.entity.Artista;
import domain.espctaculo.entity.Espectador;
import domain.generic.Duracion;

import java.util.Set;

public class EspectaculoCreado extends DomainEvent {
    private final Duracion duracion;
    private final Set<Artista> artistas;
    private final Set<Espectador> espectadores;

    public EspectaculoCreado(Duracion duracion, Set<Artista> artistas, Set<Espectador> espectadores) {
        super("domain.espectaculo.espectaculocreado");
        this.duracion = duracion;
        this.artistas = artistas;
        this.espectadores = espectadores;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public Set<Artista> getArtistas() {
        return artistas;
    }

    public Set<Espectador> getEspectadores() {
        return espectadores;
    }
}

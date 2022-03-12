package domain.espctaculo.command;

import co.com.sofka.domain.generic.Command;
import domain.espctaculo.entity.Artista;
import domain.espctaculo.entity.Espectador;
import domain.generic.Duracion;
import domain.generic.EspectaculoID;

import java.util.Set;

public class CrearEspectaculo extends Command {
    private final EspectaculoID espectaculoID;
    private final Duracion duracion;
    private final Set<Artista> artistas;
    private final Set<Espectador> espectadores;


    public CrearEspectaculo(EspectaculoID espectaculoID, Duracion duracion, Set<Artista> artistas, Set<Espectador> espectadores) {
        this.espectaculoID = espectaculoID;
        this.duracion = duracion;
        this.artistas = artistas;
        this.espectadores = espectadores;
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
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

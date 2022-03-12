package domain.espctaculo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.espctaculo.entity.Artista;
import domain.espctaculo.entity.Espectador;
import domain.espctaculo.event.ArtistaAgregado;
import domain.espctaculo.event.DuracionCambiada;
import domain.espctaculo.event.EspectaculoCreado;
import domain.espctaculo.event.EspectadorAgregado;
import domain.espctaculo.value.*;
import domain.generic.Duracion;
import domain.generic.EspectaculoID;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Espectaculo extends AggregateEvent<EspectaculoID> {
    protected Duracion duracion;
    protected Set<Artista> artistas;
    protected Set<Espectador> espectadores;

    public Espectaculo(EspectaculoID espectaculoID, Duracion duracion, Set<Artista> artistas, Set<Espectador> espectadores) {
        super(espectaculoID);
        appendChange(new EspectaculoCreado(duracion, artistas, espectadores)).apply();
    }

    private Espectaculo(EspectaculoID espectaculoID){
        super(espectaculoID);
        subscribe(new EspectaculoChange(this));
    }

    public static Espectaculo from(EspectaculoID espectaculoID, List<DomainEvent> events){
        var espectaculo = new Espectaculo(espectaculoID);
        events.forEach(espectaculo::applyEvent);
        return espectaculo;
    }

    public Optional<Artista> findArtistForId(ArtistaID artistaID){
        return artistas
                .stream()
                .filter(artista -> artista.identity().equals(artistaID))
                .findFirst();
    }

    public Optional<Espectador> findViewerForId(EspectadorID espectadorID){
        return espectadores
                .stream()
                .filter(espectador -> espectador.identity().equals(espectadorID))
                .findFirst();
    }

    public void cambiarDuracion(Duracion duracion){
        appendChange(new DuracionCambiada(duracion)).apply();
    }

    public void agregarEspectador(ArtistaID artistaID, DatosArtista datosArtista, Genero genero){
        Objects.requireNonNull(artistaID);
        Objects.requireNonNull(datosArtista);
        Objects.requireNonNull(genero);
        appendChange(new ArtistaAgregado(artistaID,datosArtista,genero)).apply();

    }

    public void agregarArtista(EspectadorID espectadorID, DatosEspectador datosEspectador){
        Objects.requireNonNull(espectadorID);
        Objects.requireNonNull(datosEspectador);
        appendChange(new EspectadorAgregado(espectadorID,datosEspectador)).apply();
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

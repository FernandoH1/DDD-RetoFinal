package domain.espctaculo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.espctaculo.value.ArtistaID;
import domain.espctaculo.value.DatosArtista;
import domain.espctaculo.value.Genero;

public class ArtistaAgregado extends DomainEvent {
    private final ArtistaID artistaID;
    private final DatosArtista datosArtista;
    private final Genero genero;

    public ArtistaAgregado(ArtistaID artistaID, DatosArtista datosArtista, Genero genero) {
        super("domain.espectaculo.artistaagregado");
        this.artistaID = artistaID;
        this.datosArtista = datosArtista;
        this.genero = genero;
    }

    public ArtistaID getArtistaID() {
        return artistaID;
    }

    public DatosArtista getDatosArtista() {
        return datosArtista;
    }

    public Genero getGenero() {
        return genero;
    }
}

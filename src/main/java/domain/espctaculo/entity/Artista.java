package domain.espctaculo.entity;

import co.com.sofka.domain.generic.Entity;
import domain.espctaculo.value.ArtistaID;
import domain.espctaculo.value.DatosArtista;
import domain.espctaculo.value.Genero;


public class Artista extends Entity<ArtistaID> {
    protected ArtistaID artistaID;
    protected DatosArtista datosArtista;
    protected Genero genero;

    public Artista(ArtistaID entityId) {
        super(entityId);
    }

    public Artista(ArtistaID entityId, ArtistaID artistaID, DatosArtista datosArtista, Genero genero) {
        super(entityId);
        this.artistaID = artistaID;
        this.datosArtista = datosArtista;
        this.genero = genero;
    }
}

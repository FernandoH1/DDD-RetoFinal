package domain.espctaculo.entity;

import co.com.sofka.domain.generic.Entity;
import domain.espctaculo.value.ArtistaID;
import domain.espctaculo.value.DatosArtista;
import domain.espctaculo.value.Genero;


public class Artista extends Entity<ArtistaID> {
    protected DatosArtista datosArtista;
    protected Genero genero;

    public Artista(ArtistaID artistaID, DatosArtista datosArtista, Genero genero) {
        super(artistaID);
        this.datosArtista = datosArtista;
        this.genero = genero;
    }

    public DatosArtista datosArtista() {
        return datosArtista;
    }

    public Genero genero() {
        return genero;
    }
}

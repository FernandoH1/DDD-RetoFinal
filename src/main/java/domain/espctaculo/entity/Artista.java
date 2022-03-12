package domain.espctaculo.entity;

import co.com.sofka.domain.generic.Entity;
import domain.espctaculo.value.*;

import java.util.Objects;


public class Artista extends Entity<ArtistaID> {
    private DatosArtista datosArtista;
    private Genero genero;

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

    public void modificarDatosArtista(ArtistaID artistaID, DatosArtista datosArtista){
        this.datosArtista = Objects.requireNonNull(datosArtista);
    }

    public void cambiarGenero(ArtistaID artistaID, Genero genero){
        this.genero = Objects.requireNonNull(genero);
    }


}

package domain.funcion.entity;


import co.com.sofka.domain.generic.Entity;
import domain.funcion.value.InformacionFuncion;
import domain.funcion.value.PaginaWebID;
import domain.funcion.value.VideoPromocional;

public class PaginaWeb extends Entity<PaginaWebID> {
    private VideoPromocional videoPromocional;
    private InformacionFuncion informacionFuncion;

    public PaginaWeb(PaginaWebID entityId) {
        super(entityId);
    }

    public PaginaWeb(PaginaWebID paginaWebID, VideoPromocional videoPromocional, InformacionFuncion informacionFuncion) {
        super(paginaWebID);
        this.videoPromocional = videoPromocional;
        this.informacionFuncion = informacionFuncion;
    }

    public VideoPromocional videoPromocional() {
        return videoPromocional;
    }

    public InformacionFuncion informacionFuncion() {
        return informacionFuncion;
    }
}

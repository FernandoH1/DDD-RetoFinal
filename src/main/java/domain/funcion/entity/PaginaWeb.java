package domain.funcion.entity;


import co.com.sofka.domain.generic.Entity;
import domain.funcion.value.InformacionFuncion;
import domain.funcion.value.PaginaWebID;
import domain.funcion.value.VideoPromocional;

public class PaginaWeb extends Entity<PaginaWebID> {
 protected PaginaWebID paginaWebID;
 protected VideoPromocional videoPromocional;
 protected InformacionFuncion informacionFuncion;

    public PaginaWeb(PaginaWebID entityId) {
        super(entityId);
    }
}

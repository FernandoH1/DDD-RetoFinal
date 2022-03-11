package domain.funcion.value;

import co.com.sofka.domain.generic.Identity;

public class PaginaWebID extends Identity {
    private PaginaWebID(String id){
        super(id);
    }

    public PaginaWebID(){ }

    public static PaginaWebID of(String id) {
        return new PaginaWebID(id);
    }
}

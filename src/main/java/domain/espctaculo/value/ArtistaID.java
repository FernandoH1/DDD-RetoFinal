package domain.espctaculo.value;

import co.com.sofka.domain.generic.Identity;

public class ArtistaID extends Identity {
    private ArtistaID(String id){
        super(id);
    }

    public ArtistaID(){ }

    public static ArtistaID of(String id) {
        return new ArtistaID(id);
    }
}

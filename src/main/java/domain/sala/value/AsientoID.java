package domain.sala.value;

import co.com.sofka.domain.generic.Identity;

public class AsientoID extends Identity {
    private AsientoID(String id){
        super(id);
    }

    public AsientoID(){ }

    public static AsientoID of(String id) {
        return new AsientoID(id);
    }
}
package domain.teatro.value;

import co.com.sofka.domain.generic.Identity;

public class UbicacionID extends Identity {
    private UbicacionID(String id){
        super(id);
    }

    public UbicacionID(){ }

    public static UbicacionID of(String id) {
        return new UbicacionID(id);
    }
}
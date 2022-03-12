package domain.generic;

import co.com.sofka.domain.generic.Identity;

public class EspectaculoID extends Identity {
    private EspectaculoID(String id){
        super(id);
    }

    public EspectaculoID(){ }

    public static EspectaculoID of(String id) {
        return new EspectaculoID(id);
    }
}
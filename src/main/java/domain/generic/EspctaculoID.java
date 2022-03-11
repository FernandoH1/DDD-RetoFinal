package domain.generic;

import co.com.sofka.domain.generic.Identity;

public class EspctaculoID extends Identity {
    private EspctaculoID(String id){
        super(id);
    }

    public EspctaculoID(){ }

    public static EspctaculoID of(String id) {
        return new EspctaculoID(id);
    }
}
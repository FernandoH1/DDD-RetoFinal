package domain.generic;

import co.com.sofka.domain.generic.Identity;

public class SalaID extends Identity {
    private SalaID(String id){
        super(id);
    }

    public SalaID(){ }

    public static SalaID of(String id) {
        return new SalaID(id);
    }
}

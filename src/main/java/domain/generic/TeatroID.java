package domain.generic;

import co.com.sofka.domain.generic.Identity;

public class TeatroID extends Identity {
    private TeatroID(String id){
        super(id);
    }

    public TeatroID(){ }

    public static TeatroID of(String id) {
        return new TeatroID(id);
    }
}
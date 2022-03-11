package domain.espctaculo.value;

import co.com.sofka.domain.generic.Identity;

public class EspectadorID extends Identity {
    private EspectadorID(String id){
        super(id);
    }

    public EspectadorID(){ }

    public static EspectadorID of(String id) {
        return new EspectadorID(id);
    }
}

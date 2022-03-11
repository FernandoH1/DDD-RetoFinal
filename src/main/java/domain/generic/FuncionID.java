package domain.generic;

import co.com.sofka.domain.generic.Identity;

public class FuncionID extends Identity {
    private FuncionID(String id){
        super(id);
    }

    public FuncionID(){ }

    public static FuncionID of(String id) {
        return new FuncionID(id);
    }
}
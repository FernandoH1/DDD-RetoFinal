package domain.funcion.command;

import co.com.sofka.domain.generic.Command;
import domain.generic.Duracion;
import domain.generic.FuncionID;

public class ModificarDuracion extends Command {
    private final FuncionID funcionID;
    private final Duracion duracion;

    public ModificarDuracion(FuncionID funcionID, Duracion duracion) {
        this.funcionID = funcionID;
        this.duracion = duracion;
    }

    public FuncionID getFuncionID() {
        return funcionID;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}

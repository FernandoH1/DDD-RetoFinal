package domain.funcion.command;

import co.com.sofka.domain.generic.Command;
import domain.funcion.value.Fecha;
import domain.generic.FuncionID;

public class CambiarFecha extends Command {
    private final FuncionID funcionID;
    private final Fecha fecha;


    public CambiarFecha(FuncionID funcionID, Fecha fecha) {
        this.funcionID = funcionID;
        this.fecha = fecha;
    }

    public FuncionID getFuncionID() {
        return funcionID;
    }

    public Fecha getFecha() {
        return fecha;
    }
}

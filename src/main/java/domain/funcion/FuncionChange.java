package domain.funcion;

import co.com.sofka.domain.generic.EventChange;
import domain.funcion.event.DuracionModificada;
import domain.funcion.event.FechaCambiada;
import domain.funcion.event.FuncionCreada;

public class FuncionChange extends EventChange {
    public FuncionChange(Funcion funcion) {
        apply((FuncionCreada event) -> {
            funcion.datosFuncion = event.getDatosFuncion();
            funcion.espectaculos = event.getEspctaculos();
            funcion.duracion = event.getDuracion();
            funcion.fecha = event.getFecha();
            funcion.paginaWeb = event.getPaginaWeb();
            funcion.ticket = event.getTicket();
        });

        apply((FechaCambiada event) -> {
            funcion.fecha = event.getFecha();
        });

        apply((DuracionModificada event) ->{
            funcion.duracion = event.getDuracion();
        });
    }
}

package domain.espctaculo;

import co.com.sofka.domain.generic.EventChange;
import domain.espctaculo.event.DuracionCambiada;
import domain.espctaculo.event.EspectaculoCreado;


public class EspectaculoChange extends EventChange {
   public EspectaculoChange(Espectaculo espctaculo){
       apply((EspectaculoCreado event) -> {
           espctaculo.duracion = event.getDuracion();
           espctaculo.espectadores = event.getEspectadores();
           espctaculo.artistas = event.getArtistas();
       });

       apply((DuracionCambiada event) -> {
          espctaculo.duracion = event.getDuracion();
       });

   }
}

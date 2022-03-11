package domain.espctaculo.value;

import co.com.sofka.domain.generic.ValueObject;
import domain.generic.Direccion;
import domain.generic.dataViewerArtist.Apellido;
import domain.generic.dataViewerArtist.Nombre;

import java.util.Objects;

public class DatosEspectador implements ValueObject<DatosEspectador.Props> {
    private final Nombre nombre;
    private final Apellido apellido;
    private final Direccion direccion;

    public DatosEspectador(Nombre nombre, Apellido apellido,Direccion direccion) {
        this.nombre = Objects.requireNonNull(nombre);
        this.apellido = Objects.requireNonNull(apellido);
        this.direccion = Objects.requireNonNull(direccion);
    }

    @Override
    public DatosEspectador.Props value() {
        return new DatosEspectador.Props(){

            @Override
            public Nombre nombre(){
                return nombre;
            }

            @Override
            public Apellido apellido(){
                return apellido;
            }

            @Override
            public Direccion direccion(){
                return direccion;
            }
        };
    }

    public interface Props{
        Nombre nombre();
        Apellido apellido();
        Direccion direccion();
    }
}

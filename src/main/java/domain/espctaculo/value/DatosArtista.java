package domain.espctaculo.value;


import co.com.sofka.domain.generic.ValueObject;
import domain.generic.dataViewerArtist.Apellido;
import domain.espctaculo.value.dataArtist.Email;
import domain.generic.dataViewerArtist.Nombre;
import domain.generic.Direccion;


import java.util.Objects;

public class DatosArtista implements ValueObject<DatosArtista.Props> {
    private final Nombre nombre;
    private final Apellido apellido;
    private final Email email;
    private final Direccion direccion;

    public DatosArtista(Nombre nombre, Apellido apellido, Email email,Direccion direccion) {
        this.nombre = Objects.requireNonNull(nombre);
        this.apellido = Objects.requireNonNull(apellido);
        this.email = Objects.requireNonNull(email);
        this.direccion = Objects.requireNonNull(direccion);
    }

    @Override
    public DatosArtista.Props value() {
        return new DatosArtista.Props(){

            @Override
            public Nombre nombre(){
                return nombre;
            }

            @Override
            public Apellido apellido(){
                return apellido;
            }

            @Override
            public Email email(){
                return email;
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
        Email email();
        Direccion direccion();
    }
}

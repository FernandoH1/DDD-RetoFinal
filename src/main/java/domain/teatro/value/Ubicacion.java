package domain.teatro.value;


import co.com.sofka.domain.generic.ValueObject;
import domain.generic.Direccion;

import java.util.Objects;

public class Ubicacion implements ValueObject<Ubicacion.Props> {
    private final Departamento departamento;
    private final Direccion direccion;

    public Ubicacion(Departamento departamento, Direccion direccion) {
        this.departamento = Objects.requireNonNull(departamento);
        this.direccion = Objects.requireNonNull(direccion);
    }

    @Override
    public Props value() {
        return new Props(){

            @Override
            public Departamento departamento(){
                return departamento;
            }

            @Override
            public Direccion direccion(){
                return direccion;
            }
        };
    }

    public interface Props{
        Departamento departamento();
        Direccion direccion();
    }
}

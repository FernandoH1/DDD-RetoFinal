package domain.espctaculo.useCase;

import domain.generic.EspectaculoID;

public interface SmsEspectaculoService {
    boolean enviarMensaje(EspectaculoID espectaculoID, String mensaje);
}

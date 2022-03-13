package domain.teatro.useCase;

import domain.generic.TeatroID;

public interface SmsTeatroService {
    boolean enviarMensaje(TeatroID teatroID, String mensaje);
}

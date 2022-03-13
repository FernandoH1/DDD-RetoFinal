package domain.funcion.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.espctaculo.Espectaculo;

import domain.funcion.command.CrearFuncion;
import domain.funcion.entity.PaginaWeb;
import domain.funcion.entity.Ticket;
import domain.funcion.event.FuncionCreada;
import domain.funcion.value.DatosFuncion;
import domain.funcion.value.Fecha;
import domain.funcion.value.PaginaWebID;
import domain.funcion.value.TicketID;
import domain.generic.Duracion;

import domain.generic.FuncionID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;



class CrearFuncionUseCaseTest {

    @Test
    void crearFuncion(){
        //arrange
        FuncionID funcionID = FuncionID.of("xxxx");
        DatosFuncion datosFuncion = new DatosFuncion("Function");
        Set<Espectaculo> espectaculos = new HashSet<>();
        Ticket ticket = new Ticket(TicketID.of("ticket"));
        PaginaWeb paginaWeb = new PaginaWeb(PaginaWebID.of("pagina"));
        Date date = new Date(2022,3,20);
        Fecha fecha = new Fecha(date);
        Duracion duracion = new Duracion(18);


        var command = new CrearFuncion(funcionID,datosFuncion,espectaculos,ticket,paginaWeb,fecha,duracion);
        var useCase = new CrearFuncionUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (FuncionCreada)events.get(0);
        Assertions.assertEquals("domain.funcion.funcioncreada", event.type);
        Assertions.assertEquals(datosFuncion, event.getDatosFuncion());
        Assertions.assertEquals(espectaculos, event.getEspctaculos());
        Assertions.assertEquals(ticket, event.getTicket());
        Assertions.assertEquals(paginaWeb, event.getPaginaWeb());
        Assertions.assertEquals(fecha, event.getFecha());
        Assertions.assertEquals(18, event.getDuracion().value());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }
}
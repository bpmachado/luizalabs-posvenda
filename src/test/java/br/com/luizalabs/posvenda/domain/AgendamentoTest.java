package br.com.luizalabs.posvenda.domain;

import br.com.luizalabs.posvenda.Application;
import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendamentoTest {

    @Test
    public void testAgendamento() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Agendamento agendamento = new Agendamento(1, formato.parse( "21/09/2020"), "bpmachado@gmail.com", "Seja bem vindo!", TipoEnvio.EMAIL, "Novo");

    }


}

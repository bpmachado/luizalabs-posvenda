package br.com.luizalabs.posvenda.domain;

import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AgendamentoTest {

    @Test
    public void testAgendamento() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Agendamento agendamento = new Agendamento(1, formato.parse( "21/09/2020"), "bpmachado@gmail.com", "Seja bem vindo!", TipoEnvio.EMAIL, "Novo");

    }


}

package br.com.luizalabs.posvenda.dto;

import br.com.luizalabs.posvenda.domain.Agendamento;
import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(MockitoJUnitRunner.class)
public class AgendamentoDtoTest {


    @Test
    public void testAgendamentoDto() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Date data = formato.parse("23/11/2015");

        Agendamento agendamento = new Agendamento();
        agendamento.setDestinatario("bpmachado@gmail.com");
        agendamento.setStatus("Novo");
        agendamento.setMensagem("Seja bem vindo!");
        agendamento.setDataEnvio(formato.parse( "21/09/2020"));
        agendamento.setId(1);
        agendamento.setTipoEnvio(TipoEnvio.EMAIL);


        AgendamentoDTO agendamentoDTO = new AgendamentoDTO(agendamento);
        agendamentoDTO.setDestinatario("bpmachado@gmail.com");
        agendamentoDTO.setStatus("Novo");
        agendamentoDTO.setMensagem("Seja bem vindo!");
        agendamentoDTO.setDataEnvio(data);
        agendamentoDTO.setId(1);
        agendamentoDTO.setTipoEnvio(1);



        Assert.assertEquals("bpmachado@gmail.com", agendamentoDTO.getDestinatario());
        Assert.assertEquals("Novo", agendamentoDTO.getStatus());
        Assert.assertEquals(data, agendamentoDTO.getDataEnvio());
        Assert.assertEquals("1", String.valueOf(agendamentoDTO.getTipoEnvio().getCod()));
        Assert.assertEquals("1", agendamentoDTO.getId().toString());
        Assert.assertEquals("1", String.valueOf(agendamentoDTO.getTipoEnvio().getCod()));

    }


}

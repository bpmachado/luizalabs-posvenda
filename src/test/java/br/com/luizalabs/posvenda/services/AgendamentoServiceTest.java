package br.com.luizalabs.posvenda.services;

import br.com.luizalabs.posvenda.domain.Agendamento;
import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;
import br.com.luizalabs.posvenda.repositories.AgendamentoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;



import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AgendamentoServiceTest {

    @Mock
    AgendamentoRepository agendamentoRepository;

    @InjectMocks
    private AgendamentoService agendamentoService;

    @Test
    public void testInsert() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        Agendamento agendamento = new Agendamento();
        agendamento.setDestinatario("bpmachado@gmail.com");
        agendamento.setStatus("Novo");
        agendamento.setMensagem("Seja bem vindo!");
        agendamento.setDataEnvio(sdf.parse( "21/09/2020"));
        agendamento.setId(1);
        agendamento.setTipoEnvio(TipoEnvio.EMAIL);

        agendamentoService.insert(agendamento);

        verify(agendamentoRepository, times(1)).save(agendamento);

    }

    @Test
    public void testFind() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        Agendamento agendamento = new Agendamento();
        agendamento.setDestinatario("bpmachado@gmail.com");
        agendamento.setStatus("Novo");
        agendamento.setMensagem("Seja bem vindo!");
        agendamento.setDataEnvio(sdf.parse( "21/09/2020"));
        agendamento.setId(1);
        agendamento.setTipoEnvio(TipoEnvio.EMAIL);

        agendamentoService.find(1);

        //verify(agendamentoRepository, times(1)).findAllById(1);

    }


}

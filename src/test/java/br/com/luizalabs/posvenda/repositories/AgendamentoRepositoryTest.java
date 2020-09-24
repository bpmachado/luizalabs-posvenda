package br.com.luizalabs.posvenda.repositories;

import br.com.luizalabs.posvenda.domain.Agendamento;
import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;
import br.com.luizalabs.posvenda.repositories.AgendamentoRepository;
import br.com.luizalabs.posvenda.services.AgendamentoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AgendamentoRepositoryTest {


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

        lenient().when(agendamentoRepository.findById(1)).thenReturn(Optional.of(agendamento));

    }

    @Test
    public void testDelete() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Agendamento agendamento = new Agendamento();
        agendamento.setDestinatario("bpmachado@gmail.com");
        agendamento.setStatus("Novo");
        agendamento.setMensagem("Seja bem vindo!");
        agendamento.setDataEnvio(sdf.parse( "21/09/2020"));
        agendamento.setId(1);
        agendamento.setTipoEnvio(TipoEnvio.EMAIL);

        agendamentoRepository.deleteById(agendamento.getId());
        verify(agendamentoRepository, times(1)).deleteById(agendamento.getId());

    }




}

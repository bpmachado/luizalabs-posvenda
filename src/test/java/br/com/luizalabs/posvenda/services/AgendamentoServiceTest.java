package br.com.luizalabs.posvenda.services;

import br.com.luizalabs.posvenda.domain.Agendamento;
import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;
import br.com.luizalabs.posvenda.dto.AgendamentoDTO;
import br.com.luizalabs.posvenda.repositories.AgendamentoRepository;
import br.com.luizalabs.posvenda.services.exception.DataIntegrityException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AgendamentoServiceTest {

    @Mock
    AgendamentoDTO agendamentoDTO;


    @Mock
    AgendamentoRepository agendamentoRepository;

    @InjectMocks
    private AgendamentoService agendamentoService;

    @Test
    public void testfromDTO() throws ParseException {
        AgendamentoService agendamentoService = new AgendamentoService();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("23/11/2015");
        Agendamento agendamento = new Agendamento();
        agendamento.setDestinatario("bpmachado@gmail.com");
        agendamento.setStatus("Novo");
        agendamento.setMensagem("Seja bem vindo!");
        agendamento.setDataEnvio(formato.parse( "21/09/2020"));
        agendamento.setId(1);
        agendamento.setTipoEnvio(TipoEnvio.EMAIL);
        AgendamentoDTO agendamentoDTO= new AgendamentoDTO(agendamento);
        agendamentoDTO.setDestinatario("bpmachado@gmail.com");
        agendamentoDTO.setStatus("Novo");
        agendamentoDTO.setMensagem("Seja bem vindo!");
        agendamentoDTO.setDataEnvio(data);
        agendamentoDTO.setId(1);
        agendamentoDTO.setTipoEnvio(1);

        agendamentoService.fromDTO(agendamentoDTO);
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

        when(agendamentoRepository.findById(1)).thenReturn(Optional.of(agendamento));
        agendamentoService.find(1);

        Assert.assertNotNull(agendamentoService.find(1));
    }

    @Test(expected=DataIntegrityException.class)
    public void testFindNull() throws ParseException {
        agendamentoService.find(1);
        Assert.assertNull(agendamentoService.find(1));
    }

    @Test
    public void testFindAll() throws ParseException {
        List<Agendamento> list = new ArrayList<Agendamento>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Agendamento agendamento = new Agendamento();
        agendamento.setDestinatario("bpmachado@gmail.com");
        agendamento.setStatus("Novo");
        agendamento.setMensagem("Seja bem vindo!");
        agendamento.setDataEnvio(sdf.parse( "21/09/2020"));
        agendamento.setId(1);
        agendamento.setTipoEnvio(TipoEnvio.EMAIL);

        list.add(agendamento);

        when(agendamentoRepository.findAll()).thenReturn(list);
        agendamentoService.findAll();
        Assert.assertNotNull(agendamentoService.findAll());
    }

    @Test(expected=DataIntegrityException.class)
    public void testFindAllVazio() throws ParseException {
        List<Agendamento> list = new ArrayList<Agendamento>(0);

        when(agendamentoRepository.findAll()).thenReturn(list);
        agendamentoService.findAll();
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

        when(agendamentoRepository.findById(1)).thenReturn(Optional.of(agendamento));

        agendamentoService.delete(1);
        verify(agendamentoRepository, times(0)).delete(agendamento);
    }


    @Test(expected=DataIntegrityException.class)
    public void testDeleteIdInvalido() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Agendamento agendamento = new Agendamento();
        agendamento.setDestinatario("bpmachado@gmail.com");
        agendamento.setStatus("Novo");
        agendamento.setMensagem("Seja bem vindo!");
        agendamento.setDataEnvio(sdf.parse( "21/09/2020"));
        agendamento.setId(1);
        agendamento.setTipoEnvio(TipoEnvio.EMAIL);

        lenient().when(agendamentoRepository.findById(1)).thenReturn(Optional.of(agendamento));

        agendamentoService.delete(2);

    }


}

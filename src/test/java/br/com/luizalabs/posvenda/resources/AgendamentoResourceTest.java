package br.com.luizalabs.posvenda.resources;

import br.com.luizalabs.posvenda.domain.Agendamento;
import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;
import br.com.luizalabs.posvenda.repositories.AgendamentoRepository;

import br.com.luizalabs.posvenda.services.AgendamentoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(AgendamentoResource.class)
public class AgendamentoResourceTest {
    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AgendamentoService mockRepositoryService;


    @Test
    public void findAllAgendamento() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Agendamento agendamento = new Agendamento(1, sdf.parse("21/09/2020"), "bpmachado@gmail.com", "Teste unitario", TipoEnvio.EMAIL, "Novo");

        List<Agendamento> allEmployees = Arrays.asList(agendamento);

        given(mockRepositoryService.findAll()).willReturn(allEmployees);

        mvc.perform(get("/agendamento")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(agendamento.getId())));
    }

    @Test
    public void findByIdAgendamento() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Agendamento agendamento = new Agendamento(1, sdf.parse("21/09/2020"), "bpmachado@gmail.com", "Teste unitario", TipoEnvio.EMAIL, "Novo");

        List<Agendamento> allEmployees = Arrays.asList(agendamento);

        Optional<Agendamento> obj = Optional.of(agendamento);

        given(mockRepositoryService.find(1)).willReturn(agendamento);


        mvc.perform(get("/agendamento/1"))
                .andExpect(status().isOk());

    }



}




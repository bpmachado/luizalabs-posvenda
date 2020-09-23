package br.com.luizalabs.posvenda.services;

import br.com.luizalabs.posvenda.repositories.AgendamentoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;

@RunWith(MockitoJUnitRunner.class)
public class DBServiceTest {

    @Mock
    AgendamentoRepository agendamentoRepository;

    @InjectMocks
    private AgendamentoService agendamentoService;

    @Test
    public void testDBService() throws ParseException {
        DBService dbService = new DBService(agendamentoRepository);

        dbService.instantiateTestDataBase();
    }
}

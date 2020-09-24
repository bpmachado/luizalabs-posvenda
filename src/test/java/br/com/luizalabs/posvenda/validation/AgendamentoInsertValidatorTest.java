package br.com.luizalabs.posvenda.validation;

import br.com.luizalabs.posvenda.domain.Agendamento;
import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;
import br.com.luizalabs.posvenda.dto.AgendamentoDTO;
import br.com.luizalabs.posvenda.resources.exception.FieldMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class AgendamentoInsertValidatorTest {

    @Test
    public void testAgendamentoInsertValidator() throws ParseException {
        AgendamentoInsertValidator agendamentoInsertValidator = new AgendamentoInsertValidator();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Date data = formato.parse("23/11/3000");

        Agendamento agendamento = new Agendamento();
        agendamento.setDestinatario("bpmachado@gmail.com");
        agendamento.setStatus("Novo");
        agendamento.setMensagem("Seja bem vindo!");
        agendamento.setDataEnvio(formato.parse( "21/09/3000"));
        agendamento.setId(1);
        agendamento.setTipoEnvio(TipoEnvio.EMAIL);


        AgendamentoDTO agendamentoDTO = new AgendamentoDTO(agendamento);
        agendamentoDTO.setDestinatario("bpmachado@gmail.com");
        agendamentoDTO.setStatus("Novo");
        agendamentoDTO.setMensagem("Seja bem vindo!");
        agendamentoDTO.setDataEnvio(data);
        agendamentoDTO.setId(1);
        agendamentoDTO.setTipoEnvio(1);

        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);
        FieldMessage e = new FieldMessage();
        e.setFieldName("dataEnvio");
        e.setMessage("teste");

        agendamentoInsertValidator.isValid(agendamentoDTO,context);

    }

}

package br.com.luizalabs.posvenda.resources.exception;

import br.com.luizalabs.posvenda.services.exception.DataIntegrityException;
import br.com.luizalabs.posvenda.services.exception.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
public class ExceptionTest {

    @MockBean
    HttpServletRequest httpServletRequest;

    @Test
    public void testFieldMessage(){

        FieldMessage fieldMessage1 = new FieldMessage("DataEnvio","Data inválida");
        FieldMessage fieldMessage2 = new FieldMessage();

        fieldMessage2.setFieldName("tipoEnvio");
        fieldMessage2.setMessage("Tipo envio inválido");

        Assert.assertEquals("tipoEnvio",fieldMessage2.getFieldName());
        Assert.assertEquals("Tipo envio inválido",fieldMessage2.getMessage());

    }

    @Test
    public void testStanderError(){

        StanderError standerError = new StanderError(1L, 404,"Data inválida", "/agendamento");

        standerError.setTimeStamp(1L);
        standerError.setStatus(404);
        standerError.setError("Data inválida");
        standerError.setPath("/agendamento");

        Assert.assertEquals("1",standerError.getTimeStamp().toString());
        Assert.assertEquals("404",standerError.getStatus().toString());
        Assert.assertEquals("Data inválida",standerError.getError());
        Assert.assertEquals("/agendamento",standerError.getPath());

    }

    @Test
    public void testValidationError(){

        ValidationError validationError = new ValidationError(1L, 404,"Data inválida", "/agendamento");

        validationError.setTimeStamp(1L);
        validationError.setStatus(404);
        validationError.setError("Data inválida");
        validationError.setPath("/agendamento");

        Assert.assertEquals("1",validationError.getTimeStamp().toString());
        Assert.assertEquals("404",validationError.getStatus().toString());
        Assert.assertEquals("Data inválida",validationError.getError());
        Assert.assertEquals("/agendamento",validationError.getPath());

    }

    @Test
    public void testObjectNotFoundException() {
        ObjectNotFoundException obj = new ObjectNotFoundException("TesteLuizalabs");

        ResourceExceptionHandler resourceExceptionHandler = new ResourceExceptionHandler();
        ResponseEntity retorno = resourceExceptionHandler.objectNotFound(obj,httpServletRequest);

        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), retorno.getStatusCodeValue());
    }

    @Test
    public void testDataIntegrityException() {
        DataIntegrityException obj = new DataIntegrityException("Erro interno");

        ResourceExceptionHandler resourceExceptionHandler = new ResourceExceptionHandler();
        ResponseEntity retorno = resourceExceptionHandler.dataIntegrety(obj,httpServletRequest);

        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), retorno.getStatusCodeValue());
    }



}

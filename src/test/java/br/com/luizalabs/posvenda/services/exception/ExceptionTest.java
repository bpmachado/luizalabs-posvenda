package br.com.luizalabs.posvenda.services.exception;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionTest {

    @Test
    public void testDataIntegrityExceptionTest(){
        DataIntegrityException exception1 = new DataIntegrityException("Teste luizalabs");
        DataIntegrityException exception2 = new DataIntegrityException("Teste luizalabs", null);
        ObjectNotFoundException exception3 = new ObjectNotFoundException("Teste luizalabs");
        ObjectNotFoundException exception4 = new ObjectNotFoundException("Teste luizalabs", null);

        Assert.assertEquals("Teste luizalabs", exception1.getMessage());
        Assert.assertEquals("Teste luizalabs", exception2.getMessage());
        Assert.assertEquals("Teste luizalabs", exception3.getMessage());
        Assert.assertEquals("Teste luizalabs", exception4.getMessage());

    }
}

package br.com.luizalabs.posvenda.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DevConfigTest {

    @Autowired
    private DevConfig devConfig;

    @Test
    public void testInstantianteDataBase() throws ParseException {

        Assert.assertTrue(devConfig.instantianteDataBase());
    }

}

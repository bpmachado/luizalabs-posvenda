package br.com.luizalabs.posvenda.config;

import br.com.luizalabs.posvenda.services.exception.DataIntegrityException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.text.ParseException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DevConfigTest {

    @InjectMocks
    private DevConfig devConfig = new DevConfig();

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(devConfig, "strategy", "none");
    }

    @Test(expected= NullPointerException.class)
    public void testInstantianteDataBase() throws ParseException {
        String test = "none";

        when(devConfig.instantianteDataBase()).thenReturn(Boolean.valueOf((true)));


    }

}

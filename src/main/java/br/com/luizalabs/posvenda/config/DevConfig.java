package br.com.luizalabs.posvenda.config;

import br.com.luizalabs.posvenda.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    public String strategy;


    @Bean
    public boolean instantianteDataBase() throws ParseException {

        if (!(strategy.equals("create"))) {
            return false;
        } else {
            dbService.instantiateTestDataBase();
            return true;
        }



    }

}
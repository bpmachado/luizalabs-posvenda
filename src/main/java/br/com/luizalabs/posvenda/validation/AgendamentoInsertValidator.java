package br.com.luizalabs.posvenda.validation;

import br.com.luizalabs.posvenda.dto.AgendamentoDTO;
import br.com.luizalabs.posvenda.repositories.AgendamentoRepository;
import br.com.luizalabs.posvenda.resources.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Calendar.*;

public class AgendamentoInsertValidator implements ConstraintValidator<AgendamentoInsert, AgendamentoDTO> {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    private Date dataAtual;

    @Override
    public void initialize(AgendamentoInsert constraintAnnotation) {
    }

    @Override
    public boolean isValid(AgendamentoDTO agendamentoDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();
        


        for(FieldMessage e : list){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }


        return list.isEmpty();
    }
}
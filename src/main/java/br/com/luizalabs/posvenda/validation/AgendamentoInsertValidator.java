package br.com.luizalabs.posvenda.validation;

import br.com.luizalabs.posvenda.dto.AgendamentoDTO;
import br.com.luizalabs.posvenda.repositories.AgendamentoRepository;
import br.com.luizalabs.posvenda.resources.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AgendamentoInsertValidator implements ConstraintValidator<AgendamentoInsert, AgendamentoDTO> {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    private Calendar dataAtual;

    @Override
    public void initialize(AgendamentoInsert constraintAnnotation) {
    }

    @Override
    public boolean isValid(AgendamentoDTO agendamentoDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();
        dataAtual = Calendar.getInstance();

        if(!dataAtual.getTime().before(agendamentoDTO.getDataEnvio())){
            list.add(new FieldMessage("dataEnvio","A Data/Hora de envio não pode ser menor que a data atual."));
        }

        for(FieldMessage e : list){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }


        return list.isEmpty();
    }
}

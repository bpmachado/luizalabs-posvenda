package br.com.luizalabs.posvenda.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StanderError {
    private static final long serialVersionUID = 1L;
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Long timeStamp, Integer status, String error, String path) {
        super(timeStamp, status, error, path);
    }


    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void setAdd(String fieldName, String messages){
        errors.add(new FieldMessage(fieldName, messages));
    }
}

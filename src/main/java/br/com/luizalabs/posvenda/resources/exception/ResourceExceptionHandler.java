package br.com.luizalabs.posvenda.resources.exception;

import javax.servlet.http.HttpServletRequest;

import br.com.luizalabs.posvenda.services.exception.DataIntegrityException;
import br.com.luizalabs.posvenda.services.exception.ObjectNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StanderError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StanderError err = new StanderError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não encontrado", request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StanderError> dataIntegrety(DataIntegrityException e, HttpServletRequest request){
		StanderError err = new StanderError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de dados", request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StanderError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", request.getRequestURI());
		for(FieldError x : e.getBindingResult().getFieldErrors()){
			err.setAdd(x.getField(), x.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<StanderError> emptyResult(EmptyResultDataAccessException e, HttpServletRequest request){
		StanderError err = new StanderError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Registro não encontrado", request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StanderError> iilegalArgumentException(IllegalArgumentException e, HttpServletRequest request){
		StanderError err = new StanderError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Dados de entrada inválido para o campo tipoEnvio, por favor enviar o número 1-E-mail, 2-SMS, 3-PUSH e 4-WHASTAPP", request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}

package telran.spring.calculator.exceptions;

import javax.validation.ConstraintViolationException;

import org.slf4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandler {
	static Logger LOG = LoggerFactory.getLogger(GlobalExceptionsHandler.class);
@ExceptionHandler({BadRequestException.class,
	ConstraintViolationException.class, MethodArgumentNotValidException.class})
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
String getCustomExceptionText(Exception e) {
	LOG.error("Server has thrown exception with message: {}",e.getMessage());
	return e.getMessage();
}
@ExceptionHandler(RuntimeException.class)
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) 
String getStandardExceptionText(RuntimeException e) {
	LOG.error("Server has thrown exception with message: {}",e.getMessage());
	return e.getMessage();
}
}
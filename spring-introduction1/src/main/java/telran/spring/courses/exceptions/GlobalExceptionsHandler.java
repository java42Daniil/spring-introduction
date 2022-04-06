package telran.spring.courses.exceptions;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@RestControllerAdvice
public class GlobalExceptionsHandler {
	static Logger LOG = LoggerFactory.getLogger(GlobalExceptionsHandler.class);
	
	@ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class, BadRequest.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	String getExceptionMessage(Exception e) {
		LOG.error("Server says: {}", e.getMessage());
		return e.getMessage();
	}
	// V.R. There isn't processing of code=404 NotFoundException
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	String getStandardExceptionText(RuntimeException e) {
		LOG.error("Server says: {}", e.getMessage());
		return e.getMessage();
	}
}
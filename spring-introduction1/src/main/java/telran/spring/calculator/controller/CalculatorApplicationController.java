package telran.spring.calculator.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import telran.spring.calculator.dto.CalculateData;
import telran.spring.calculator.exceptions.GlobalExceptionsHandler;
import telran.spring.calculator.service.Calculator;

@RestController
@RequestMapping("/calculator")
@Validated
public class CalculatorApplicationController {
	static Logger LOG = LoggerFactory.getLogger(CalculatorApplicationController.class);
	@Autowired
	Calculator calculator;
	@PostMapping
	double calculate(@RequestBody @Valid CalculateData calculateData) {
		LOG.debug("calculation operation: {}", calculateData.operation);
		return calculator.calculate(calculateData.operation, calculateData.operands);
	}
	@GetMapping("/operations")
	String[] getOperations() {
		LOG.debug("get operations");
		return calculator.getAllOperations();
	}
	@GetMapping("/operation")
	boolean hasOperation(@RequestParam(name = "operation") @NotEmpty String operation) {
		LOG.debug("hasOperation {}", operation);
		return calculator.hasOperation(operation);
		
	}
}
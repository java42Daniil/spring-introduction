package telran.spring.calculator.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.spring.calculator.exceptions.BadRequestException;

@Service
public class Calculator {
	Map<String, CalculatorOperation> mapOperations;
	@Autowired
	public Calculator(List<CalculatorOperation> listOperations) {
		mapOperations = listOperations.stream()
				.collect(Collectors.toMap(CalculatorOperation::getOperation, co -> co));
	}
	public double calculate(String operation, double operands[]) {
		CalculatorOperation calculatorOperation = mapOperations.get(operation);
		if (calculatorOperation == null) {
			throw new BadRequestException(String.format("operation \"%s\" is not implemented", operation));
		}
		return calculatorOperation.calculate(operands);
	}
	public String[] getAllOperations() {
		return mapOperations.keySet().toArray(String[]::new);
	}
	public boolean hasOperation(String operation) {
		return mapOperations.containsKey(operation);
	}
}
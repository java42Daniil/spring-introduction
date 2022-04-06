package telran.spring.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorOperationMultiply implements CalculatorOperation {

	@Override
	public double calculate(double operands[]) {
		
		return operands[0] * operands[1];
	}

	@Override
	public String getOperation() {
		
		return "*";
	}

}
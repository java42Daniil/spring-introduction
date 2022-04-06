package telran.spring.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorOperationPow implements CalculatorOperation {

	@Override
	public double calculate(double[] operands) {
		CalculatorOperation.checkOperandsNumber(operands, 2);
		return Math.pow(operands[0], operands[1]);
	}

	@Override
	public String getOperation() {
		
		return "**";
	}

}
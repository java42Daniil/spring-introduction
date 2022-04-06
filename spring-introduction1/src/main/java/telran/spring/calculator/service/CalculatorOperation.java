package telran.spring.calculator.service;

import telran.spring.calculator.exceptions.BadRequestException;

public interface CalculatorOperation {
double calculate (double operands[]);
String getOperation();
 static void checkOperandsNumber(double operands[], int required) {
	if (operands.length != required) {
		throw new BadRequestException(String.format("wrong operands number: required %d, actual %d",
				required, operands.length));
	}
}
}
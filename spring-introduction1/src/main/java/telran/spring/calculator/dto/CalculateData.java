package telran.spring.calculator.dto;

public class CalculateData {
public String operation;
public double[] operands;
public CalculateData(String operation, double[] operands) {
	this.operation = operation;
	this.operands = operands;
}
public CalculateData() {
}
}
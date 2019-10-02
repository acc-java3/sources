package edu.acc.java3.calqlator;

public class Calqlator implements java.io.Serializable {

	public static double execute(String operand1, String op, String operand2) {
		double op1 = Double.parseDouble(operand1);
		double op2 = Double.parseDouble(operand2);
		switch (op) {
			case "+": return op1 + op2;
			case "-": return op1 - op2;
			case "x": return op1 * op2;
			case "/": return op1 / op2;
			case "%": return op1 % op2;
			case "^": return Math.pow(op1, op2);
			default:
				throw new UnsupportedOperationException(op);
		}
	}
	
}
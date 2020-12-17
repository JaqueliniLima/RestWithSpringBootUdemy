package br.com.erudio.math;

public class SimpleMath {
	
	public Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}
	
	public Double minus(Double numberOne, Double numberTwo) {
		return numberOne - numberTwo;
	}
	
	public Double multiply(Double numberOne, Double numberTwo){
		return numberOne * numberTwo;
	}
	
	public Double divide(Double numberOne, Double numberTwo)  {
		return numberOne / numberTwo;
	}
	
	public Double mean(Double numberOne, Double numberTwo) {
		return (numberOne + numberTwo) / 2;
	}
	
	public Double squareRoot(Double number)  {
		return (Double) Math.sqrt(number);
	}
}

package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.NumberConverter;

@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.sum(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}
	
	@RequestMapping(value="/minus/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double minus(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		
		return math.minus(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}
	
	@RequestMapping(value="/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiply(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		
		return math.multiply(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}
	
	@RequestMapping(value="/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double divide(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		
		return math.divide(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}
	
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		
		return math.mean(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}
	
	@RequestMapping(value="/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) {
		if(!NumberConverter.isNumeric(number))
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		
		return math.squareRoot(NumberConverter.convertDouble(number));
	}
	
}

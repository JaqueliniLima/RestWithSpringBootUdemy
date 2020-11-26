package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public	Double greeting(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}


	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replace(",", ".");
		if(isNumeric(strNumber)) return Double.parseDouble(number);
		return 0D;
	}


	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replace(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}

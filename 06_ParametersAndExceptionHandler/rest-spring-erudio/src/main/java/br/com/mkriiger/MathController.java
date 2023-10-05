package br.com.mkriiger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.mkriiger.exceptions.UnsupportedMathOperationException;
import br.com.mkriiger.utils.Util;

@RestController
public class MathController {
	
//	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!Util.isNumeric(numberOne) || !Util.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return Util.convertToDouble(numberOne) + Util.convertToDouble(numberTwo);
	}
	
	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!Util.isNumeric(numberOne) || !Util.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return Util.convertToDouble(numberOne) - Util.convertToDouble(numberTwo);
	}
	
	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!Util.isNumeric(numberOne) || !Util.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return Util.convertToDouble(numberOne) * Util.convertToDouble(numberTwo);
	}
	
	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!Util.isNumeric(numberOne) || !Util.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return Util.convertToDouble(numberOne) / Util.convertToDouble(numberTwo);
	}
	
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!Util.isNumeric(numberOne) || !Util.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return (Util.convertToDouble(numberOne) + Util.convertToDouble(numberTwo)) / 2;
	}
	
	@GetMapping("/squareRoot/{numberOne}")
	public Double squareRoot(
			@PathVariable(value = "numberOne") String numberOne
			) throws Exception {
		
		if(!Util.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return Math.sqrt(Util.convertToDouble(numberOne));
	}

}

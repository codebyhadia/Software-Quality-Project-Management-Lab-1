package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/add")
	public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
							@RequestParam(name="operand2", required=false, defaultValue="") String operand2,
							@RequestParam(name="operator", required=false, defaultValue="+") String operator)

 {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);


	 switch(operator) {
		 case "+": return Binary.add(number1, number2).getValue();
		 case "*": return Binary.multiply(number1, number2).getValue();
		 case "&": return Binary.and(number1, number2).getValue();
		 case "|": return Binary.or(number1, number2).getValue();
		 default: return "error";
	 }
	}

	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
								   @RequestParam(name="operand2", required=false, defaultValue="") String operand2,
								   @RequestParam(name="operator", required=false, defaultValue="+") String operator) {
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);

		BinaryAPIResult result;
		switch (operator) {
			case "+":
				result = new BinaryAPIResult(number1, "add", number2, Binary.add(number1, number2));
				break;
			case "*":
				result = new BinaryAPIResult(number1, "multiply", number2, Binary.multiply(number1, number2));
				break;
			case "&":
				result = new BinaryAPIResult(number1, "and", number2, Binary.and(number1, number2));
				break;
			case "|":
				result = new BinaryAPIResult(number1, "or", number2, Binary.or(number1, number2));
				break;
			default:
				result = new BinaryAPIResult(number1, "error", number2, new Binary("error"));
				break;
		}
		return result;
	}


	}
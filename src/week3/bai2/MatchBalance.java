package week3.bai2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Stack;

public class MatchBalance {
	private Double result;
	private ArrayList<String> listInput;

	public MatchBalance(String input) {
		super();
		// khai bao

		listInput = new ArrayList<String>();
		this.result = 0d;

		// xu li input => arraylist
		String tmpChar = "";
		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			if (currentChar != ' ') {
				tmpChar += String.valueOf(input.charAt(i));
			} else {
				listInput.add(tmpChar);
				tmpChar = "";
			}
			if (i == input.length() - 1) {
				listInput.add(tmpChar);
			}
		}
		handleMath();

	}

	private void handleMath() {
		 Stack <Double> tmpStack = new Stack<Double>();
	        for (int i=0; i<listInput.size(); i++){
	            char c = listInput.get(i).charAt(0);
	            if (isNumber(listInput.get(i))){
	            	tmpStack.push(Double.parseDouble(listInput.get(i)));
	            }else{
	                double num = 0f;
	                double num1 = tmpStack.pop();
	                double num2 = tmpStack.pop();
	                switch (c) {
	                    case '+' :
	                    	num = sum(num1, num2);
	                    	break;
	                    case '-' :
	                    	num = subtraction(num1, num2);
	                    	break;
	                    case '*' :
	                    	num = multiplication(num1, num2);
	                    	break;
	                    case '/' : 
	                    	num = division(num1, num2);
	                    	break;
	                    default:
	                        break;
	                }
	                tmpStack.push(num);
	            }
	        }
	         this.result=tmpStack.pop();
	}

	private double sum(double a, double b) {
		return b + a;
	}

	private double subtraction(double a, double b) {
		return b - a;
	}

	private double multiplication(double a, double b) {
		return b * a;
	}

	private double division(double a, double b) {
		return b / a;
	}

	private boolean isNumber(String string) {
		String regex = "[0-9]+";
		return string.matches(regex);
	}

	public String result() {
		NumberFormat formatter = new DecimalFormat("#0"); 
		String tmpResult = formatter.format(this.result);
		if (String.valueOf(this.result).equals(tmpResult+".0")) {
			return tmpResult;
		}else {
			return String.valueOf(this.result);
		}
		
	}

}

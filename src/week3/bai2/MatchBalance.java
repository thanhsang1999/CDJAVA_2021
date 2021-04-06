import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class MatchBalance {
	private int result;
	private ArrayList<String> listInput;

	public MatchBalance(String input) {
		super();
		// khai bao

		listInput = new ArrayList<String>();
		this.result = 0;

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
		 Stack <Integer> tmpStack = new Stack<Integer>();
	        for (int i=0; i<listInput.size(); i++){
	            char c = listInput.get(i).charAt(0);
	            if (isNumber(listInput.get(i))){
	            	tmpStack.push(Integer.parseInt(listInput.get(i)));
	            }else{
	            	int num = 0;
	                int num1 = tmpStack.pop();
	                int num2 = tmpStack.pop();
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

	private int sum(int a, int b) {
		return b + a;
	}

	private int subtraction(int a, int b) {
		return b - a;
	}

	private int multiplication(int a, int b) {
		return b * a;
	}

	private int division(int a, int b) {
		return b / a;
	}

	private boolean isNumber(String string) {
		String regex = "[0-9]+";
		return string.matches(regex);
	}

	public String result() {
//		NumberFormat formatter = new DecimalFormat("#0"); 
//		String tmpResult = formatter.format(this.result);
//		if (String.valueOf(this.result).equals(tmpResult+".0")) {
//			return tmpResult;
//		}else {
//			return String.valueOf(this.result);
//		}
		return String.valueOf(this.result);
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int tmpStr = Integer.parseInt(sc.nextLine());
	ArrayList<String> list = new ArrayList<String>();
	for (int i = 0; i < tmpStr; i++) {
		MatchBalance encode = new MatchBalance(sc.nextLine());
		list.add(encode.result());
	}
	for (String string : list) {
		System.out.println(string);
		
	}
}
}

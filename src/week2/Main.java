package week2;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		MyStringTokenizer mySTR = new MyStringTokenizer("Truong@#!dai@ hoc! nong lam","[Tm]");
//		MyStringTokenizer mySTR = new MyStringTokenizer("t r u o n g");
		System.out.println("countTokens: "+mySTR.countTokens());
		while (mySTR.hasMoreTokens()) {
			System.out.println(mySTR.nextToken());
		}
		
//		StringTokenizer stringTokenizer = new StringTokenizer("truong@#!dai@ hoc! nong lam","[!]");
////		StringTokenizer stringTokenizer = new StringTokenizer("t r u o n g");
//		System.out.println(stringTokenizer.countTokens());
//		while (stringTokenizer.hasMoreTokens()) {
//			System.out.println(stringTokenizer.nextToken());
//		}
		
	}
}

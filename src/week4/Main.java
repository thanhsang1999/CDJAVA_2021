package week4;

public class Main {
	public static void main(String[] args) {
		BigNumber bigNumber = new BigNumber();
		String result1 = bigNumber.plus("65","23");//123222343660443543618
		String result2 = bigNumber.minus("12","2");//-725215756
		String result3 = bigNumber.multiply("61","43832834152");//705780864
		String[] result4 = bigNumber.divide("438","4");//726112
		System.out.println("plus: "+result1);
		System.out.println("minus: "+result2);
		System.out.println("multiply: "+result3);
		System.out.println("divide result: "+result4[0]);
		System.out.println("divide phan du: "+result4[1]);
		
	}
}

package week4;

public class Main {
	public static void main(String[] args) {
		BigNumber<Long> bigNumber = new BigNumber<Long>();
		String result1 = bigNumber.plus(3123121L, 203213123L);//123222343660443543618
		String result2 = bigNumber.minus(12L,2L);//-725215756
		String result3 = bigNumber.multiply(61L,438328L);//705780864
		String[] result4 = bigNumber.divide(438L,4L);//726112
		System.out.println("plus: "+result1);
		System.out.println("minus: "+result2);
		System.out.println("multiply: "+result3);
		System.out.println("divide result: "+result4[0]);
		System.out.println("divide phan du: "+result4[1]);
		
	}
}

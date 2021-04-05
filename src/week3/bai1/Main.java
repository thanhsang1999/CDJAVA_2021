package week3.bai1;

public class Main {
	public static void main(String[] args) {
		/*
		a = "toi di hoc"
		b = 123
		=> 
		1 => t =>> t
		2 = > oi =>> io
		3 => " di" =>> "id "
		1 => " " =>> " "
		2 => ho =>> "oh"
		3 => "c  " =>> "  c"
		==>> tioid  oh  c
		
		lay gia tri mat khau 
		=> input password
		
		arrayList<int>
		*/

		String input = "3\r\n"
				+ "truong dai hoc nong lam tphcm\r\n"
				+ "1234\r\n"
				+ "phuong linh trung quan thu duc\r\n"
				+ "1452\r\n"
				+ "mot ngay dep troi\r\n"
				+ "164";
		EncodeLuxy encodeLuxy = new EncodeLuxy(input);
		for (String string : encodeLuxy.result()) {
			System.out.println(string);
		}
		System.out.println(encodeLuxy.result().get(0).equals("*turgnoiad  ohn c gnolmapt  mch*"));
		System.out.println(encodeLuxy.result().get(1).equals("*pnouhnil g htgnurnauq t hud u    c*"));
		System.out.println(encodeLuxy.result().get(2).equals("*magn toed yp iort *"));
	}
}

package week3.bai2;

public class Main {
	public static void main(String[] args) {
		
//		((4*2)+(3*8)-(2*3)+(3*7))*3
//		4 2 * 3 8 * + 2 3 * - 3 * 7 + 3 *
		String input = "3\r\n"
				+ "3 4 /\r\n"
				+ "5 6 + 8 *\r\n"
				+ "4 8 + 10 2 - * 4 /\r\n"
				+ "1 2 + 3 -";
		Balance balance = new Balance(input);
//		MatchBalance balance2 = new MatchBalance("4 8 + 10 2 - * 4 /");
		// ((4+8)*(10-2))/4
//		MatchBalance balance3 = new MatchBalance("5 6 + 8 *");
//		MatchBalance balance4 = new MatchBalance("1 2 + 3 -");
		MatchBalance balance5 = new MatchBalance("4 2 * 3 8 * + 2 3 * - 3 7 * + 3 4 + * 3 2 * 2 * - 1 + 3 - 6 2 + 5 * +");
//		System.out.println(balance2.result());
//		System.out.println(balance3.result());
//		System.out.println(balance4.result());
		System.out.println(balance5.result());
		for (String item : balance.result()) {
			System.out.println(item);
		}
//		int a = 1;
//		double b = 0.75;
//		System.out.println(Integer.parseInt(String.valueOf("0.5")));
//		System.out.println(Double.parseDouble(String.valueOf(a))==b);
	}
}

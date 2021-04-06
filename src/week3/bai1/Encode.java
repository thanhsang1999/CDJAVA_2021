import java.util.ArrayList;
import java.util.Scanner;

public class Encode {
	String result;
	String input;
	ArrayList<Integer> password;

	public Encode(String input, String password) {
		super();
		// khai bao
		this.password = new ArrayList<Integer>();
		this.input = input;
		this.result="";
		//xu li password
		for (int i = 0; i < password.length(); i++) {
			int number = Character.getNumericValue(password.charAt(i));
			this.password.add(number);
		}
		// ma hoa
		handleEncode();

	}

	private void handleEncode() {
		
		//khai bao bien dung tam thoi
		ArrayList<String> listStringSplited = new ArrayList<String>();
		char[] tmpArr = this.input.toCharArray();
		int i = 0;
		int tmpIndex = 0;
		String tmpString = "";
		
		// tach chuoi theo password
		for (int j = 0; j < tmpArr.length; j++) {
			tmpIndex++;
			tmpString += tmpArr[j];
			if (tmpIndex == this.password.get(i)) {
				listStringSplited.add(tmpString);
				tmpString = "";
				tmpIndex=0;
				i++;
				if (i == password.size()) {
					i = 0;
				}
			}else if(j==tmpArr.length-1){ //them " " neu khong du
				int intSpace =this.password.get(i)-tmpIndex;
				String space ="";
				for (int k = 0; k < intSpace; k++) {
					space+=" ";
				}
				listStringSplited.add(tmpString+space);
			}
		}
		//dao chuoi roi add vao result
		for (String item : listStringSplited) {
			result+=reverse(item);
		}
//		System.out.println(listStringSplited.toString());
	}

	// ham dao chuoi
	private String reverse(String item) {
		String result = "";
		for (int i = item.length()-1; i >= 0; i--) {
			result+=item.charAt(i);
		}
		return result;
	}

	public String result() {
		return "*"+this.result+"*";
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int tmpStr = Integer.parseInt(sc.nextLine());
	ArrayList<String> list = new ArrayList<String>();
	for (int i = 0; i < tmpStr; i++) {
		Encode encode = new Encode(sc.nextLine(), sc.nextLine());
		list.add(encode.result());
	}
	for (String string : list) {
		System.out.println(string);
	}
}
}

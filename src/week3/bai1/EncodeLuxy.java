package week3.bai1;

import java.util.ArrayList;

public class EncodeLuxy {
	ArrayList<String> result;
	int numberTestCase;
	ArrayList<String> stringInput;
	ArrayList<String> passwordInput;

	public EncodeLuxy(String string) {
		result = new ArrayList<String>();
		// tien xu ly
		String[] tmpArr = string.split(System.getProperty("line.separator"));
		for (int i = 1; i < tmpArr.length; i++) {
			String a = tmpArr[i]; // input
			String b = tmpArr[++i]; // password
			//goi class xu ly
			Encode encode = new Encode(a, b);
			//ket qua sau khi xu ly
			result.add(encode.result());
		}
	}

	public ArrayList<String> result() {
		return this.result;
	}

}

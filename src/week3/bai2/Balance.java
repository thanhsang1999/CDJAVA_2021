package week3.bai2;

import java.util.ArrayList;

public class Balance {
	private ArrayList<String> result;

	public Balance(String string) {
		result = new ArrayList<String>();
		// tien xu ly
		String[] tmpArr = string.split(System.getProperty("line.separator"));
		for (int i = 1; i < tmpArr.length; i++) {
			//goi class xu ly
			MatchBalance matchBalance = new MatchBalance(tmpArr[i]);
			//ket qua sau khi xu ly
			result.add(matchBalance.result());
		}
	}

	public ArrayList<String> result() {
		return this.result;
	}

}

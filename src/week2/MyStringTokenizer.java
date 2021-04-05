package week2;
import java.util.ArrayList;
import java.util.Iterator;

public class MyStringTokenizer {
	ArrayList<String> listString;
	String stringInput;
	int index;
	String delim;
	public MyStringTokenizer(String string) {
		super();
		this.index=0;
		this.stringInput=string;
		this.delim=" ";
		stringToArr();
	}
	public MyStringTokenizer(String string,String delim) {
		super();
		this.index=0;
		this.stringInput=string;
		this.delim=delim;
		stringToArr();
	}
	public void stringToArr() {
		ArrayList<String> tmpListString = new ArrayList<>();
		//tu thuc hien split
		if(checkDelim(this.delim)) {
			tmpListString.addAll(coverSplit(stringInput,this.delim));
		}else {
			tmpListString.addAll(coverSplit2(stringInput,convertDelim(this.delim)));
		}
		
		//return
		listString=tmpListString;
	}
	private String convertDelim(String delim) {
		String result="";
		for (int i = 1; i < delim.length()-1; i++) {
			result+=delim.charAt(i);
		}
		return result;
	}
	//return true if not "[]"
	private boolean checkDelim(String delim) {
		char tmpChar1= delim.charAt(0);
		char tmpChar2= delim.charAt(delim.length()-1);
		if (tmpChar1=='['&&tmpChar2==']') {
			return false;
		}else {
			return true;
		}
	}
	//chuyen string sang arraylist
	private ArrayList<String> coverSplit(String stringInput, String delim) {
		int currentIndex = 0;
		int nextIndex;
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < stringInput.length(); i++) {
			int tmpIndex = 0;
			for (int j = 0; j < delim.length(); j++) {
				char tmp1 = stringInput.charAt(i);
				char tmp2 = delim.charAt(j);
				if (tmp1==tmp2) {
					tmpIndex++;
					i++;
				}
			}
			if(tmpIndex==delim.length()) {
				nextIndex=i-tmpIndex;
				result.add(addToResult(stringInput,currentIndex,nextIndex));
				currentIndex=nextIndex+tmpIndex;
			}else if(tmpIndex>0) {
				i=i-tmpIndex;
			}
		}
		result.add(addToResult(stringInput,currentIndex,stringInput.length()));
		return result;
	}
	private ArrayList<String> coverSplit2(String stringInput, String delim) {
		int currentIndex = 0;
		int nextIndex;
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < stringInput.length(); i++) {
			int tmpIndex = 0;
			for (int j = 0; j < delim.length(); j++) {
//				System.out.println(i);
				//check limit of stringInput
				if(i<stringInput.length()) {
					char tmp2 = delim.charAt(j);
					char tmp1 = stringInput.charAt(i);
					if (tmp1==tmp2) {
						tmpIndex++;
						j--;
						i++;
					}
				}
			}
			if(tmpIndex>0) {
				nextIndex=i-tmpIndex;
				String tmpResult = addToResult(stringInput,currentIndex,nextIndex);
				if (!tmpResult.isEmpty()) {
					result.add(tmpResult);
				}
				currentIndex=nextIndex+tmpIndex;
			}
		}
		String tmpResult = addToResult(stringInput,currentIndex,stringInput.length());
		if (!tmpResult.isEmpty()) {
			result.add(tmpResult);
		}
		
		return result;
	}
	// return string tu current đến next
	private String addToResult(String string, int currentIndex, int nextIndex) {
		String result ="";
		for (int i = currentIndex; i < nextIndex; i++) {
			result+=string.charAt(i);
		}
		return result;
	}
	//method
	public boolean hasMoreTokens() {
		if (index<listString.size()) {
			return true;
		}else {
			return false;
		}
	}
	public String nextToken(String string) {
		this.delim=string;
		String result = listString.get(index);
		this.index++;
		return result;
	}
	public String nextToken() {
		String result = listString.get(index);
		this.index++;
		return result;
	}
	public int countTokens() {
		
		return listString.size()-index;
	}
	
	

}

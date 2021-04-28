package week4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BigNumber {
	public BigNumber() {
	}

	public String plus(String input1, String input2) {
		input1 = clear0(input1);
		input2 = clear0(input2);
		String result = "";
		// tien xu ly
		// String => List<number>
		// listNumber1 >listNumber2
		if (input1.charAt(0)=='-'||input2.charAt(0)=='-') {
			if (input1.charAt(0)=='-'&&input2.charAt(0)=='-') {
				return "-"+plus(clearMinus(input1), clearMinus(input2));
			}
			return minus(clearMinus(input1), clearMinus(input2));
		}
		boolean isGreater = checkNumGreater(input1, input2);// true if input1>=input2
		ArrayList<Integer> listNumber1 = handleParseListNumber(isGreater ? input1 : input2);
		ArrayList<Integer> listNumber2 = handleParseListNumberLess(!isGreater ? input1 : input2,
				Math.abs(input1.length() - input2.length()));
		// => 2 list chua so
		// listNumber1>listNumber2
		// TODO xu ly
		
		
		Stack<Integer> digitalTempMemory = new Stack<Integer>();
		Stack<Integer> tmpResult = new Stack<Integer>();
		for (int i = listNumber1.size() - 1; i >= 0; i--) {
			int a = listNumber1.get(i);
			int b = listNumber2.get(i);
			int c = a + b;
			if (digitalTempMemory.size() > 0) {
				if (c >= 10) {
					int n1 = c % 10;// so 0-9
					int n2 = c / 10;// 10-18
					int n3 = digitalTempMemory.pop() + n1;
					digitalTempMemory.add(n2);
					tmpResult.add(n3);
				} else {
					c = c + digitalTempMemory.pop();
					if (c >= 10) {
						int n1 = c % 10;// so 0-9
						int n2 = c / 10;// 10-18
						digitalTempMemory.add(n2);
						tmpResult.add(n1);
					} else {
						tmpResult.add(c);
					}
				}
			} else {
				if (c >= 10) {
					int n1 = c % 10;// so 0-9
					int n2 = c / 10;// 10-18
					digitalTempMemory.add(n2);
					tmpResult.add(n1);
				} else {
					tmpResult.add(c);
				}
			}
		}
		if (digitalTempMemory.size() > 0)
			tmpResult.add(digitalTempMemory.pop());
		while (tmpResult.size() > 0) {
			result += tmpResult.pop();
		}
		return result;
	}

	public String minus(String input1, String input2) {
		input1 = clear0(input1);
		input2 = clear0(input2);
		String result = "";
		// tien xu ly
		// String => List<number>
		// listNumber1 >listNumber2
		boolean isGreater = checkNumGreater(input1, input2);// true if input1>=input2
		ArrayList<Integer> listNumber1 = handleParseListNumber(isGreater ? input1 : input2);
		ArrayList<Integer> listNumber2 = handleParseListNumberLess(!isGreater ? input1 : input2,
				Math.abs(input1.length() - input2.length()));
		
		if (input1.charAt(0)=='-'||input2.charAt(0)=='-') {
			if (input1.charAt(0)=='-'&&input2.charAt(0)=='-') {
				return "-"+plus(clearMinus(input1), clearMinus(input2));
			}
			return plus(clearMinus(input1), clearMinus(input2));
		}
		
		// => 2 list chua so
		// listNumber1>listNumber2
		// TODO xu ly
		Stack<Integer> digitalTempMemory = new Stack<Integer>();
		Stack<Integer> tmpResult = new Stack<Integer>();
		for (int i = listNumber1.size() - 1; i >= 0; i--) {
			int a = listNumber1.get(i);
			int b = listNumber2.get(i);
			int c = a - b;
			if (c < 0) {
				listNumber1.set(i - 1, listNumber1.get(i - 1) - 1);
				c += 10;
			}
			tmpResult.add(c);
		}
		while (tmpResult.size() > 0) {
			result += tmpResult.pop();
		}

		if (!isGreater) {
			result = "-" + result;
		}
		return clear0(result);
	}

	public String multiply(String input1, String input2) {
		input1 = clear0(input1);
		input2 = clear0(input2);
		String result = "0";
		
		if (input1.charAt(0)=='-'||input2.charAt(0)=='-') {
			if (input1.charAt(0)=='-'&&input2.charAt(0)=='-') {
				return multiply(clearMinus(input1), clearMinus(input2));
			}
			return "-"+multiply(clearMinus(input1), clearMinus(input2));
		}
		
		// tien xu ly
		// String => List<number>
		boolean isGreater = checkNumGreater(input1, input2);// true if input1>=input2
		String numberStr = isGreater ? input1 : input2;// so lon
		ArrayList<Integer> listNumberLess = handleParseListNumber(!isGreater ? input1 : input2);// so be
		// TODO xu ly

		// nhan so be hon 9 => numberStr*[1-9]
		Queue<String> digitalTempMemory = new LinkedList<String>();
		for (int i = listNumberLess.size() - 1; i >= 0; i--) {
			String tmpNumber = multiplyMini(numberStr, listNumberLess.get(i));
			digitalTempMemory.add(tmpNumber);
		}
		String zeros = "";
		while (digitalTempMemory.size() > 0) {
			result = plus(result, digitalTempMemory.poll() + zeros);
			zeros += "0";
		}
		return result;
	}

	public String multiplyMini(String numberStr, int size) {
		String result = "0";
		for (int i = 0; i < size; i++) {
			result = plus(result, numberStr);
		}
		return result;
	}

	public String[] divide(String numberBiger, String numberSmaller) {
		String result[] = { "", "0" };
		numberBiger = clear0(numberBiger);
		numberSmaller = clear0(numberSmaller);
		if (!checkNumGreater(numberBiger, numberSmaller)) {
			result[0] = "0";
			result[1] = numberBiger;
			return result;
		}
		if (numberBiger.charAt(0)=='-'||numberSmaller.charAt(0)=='-') {
			if (numberBiger.charAt(0)=='-'&&numberSmaller.charAt(0)=='-') {
				return divide(clearMinus(numberBiger), clearMinus(numberSmaller));
			}
			String [] tmpRs = divide(clearMinus(numberBiger), clearMinus(numberSmaller));
			tmpRs[0]="-"+tmpRs[0];
			return tmpRs;
		}
		Queue<Integer> tmpResult = new LinkedList<>();
		boolean isStop = false;
		// 1. Chuyen input 1 va input thanh Queue<Integer>
		Queue<Integer> stackNumberBiger = new LinkedList<Integer>(handleParseListNumber(numberBiger));
		// 2. lay do day cua so nho, get length number smaller
		int lengthNSmall = numberSmaller.length();
		// Xu li/Handle
		// dung stack de luu so chuan bi xu ly
		Stack<String> preProcess = new Stack<String>();
		String tmpStr1 = "";
		while (stackNumberBiger.size() >= 0) {
			tmpStr1 += stackNumberBiger.poll();
			if (checkNumGreater(tmpStr1, numberSmaller)) {
				break;
			}
		}
		preProcess.add(tmpStr1);
		while (!isStop) {
			String tmpBignumber = preProcess.pop();
			for (int i = 9; i >= 1; i--) {
				String surplus = minus(tmpBignumber, multiplyMini(numberSmaller, i));
				
				if (checkPositiveNumber(surplus)) {
					tmpResult.add(i);
					String nextBigNumber = surplus;
					if (stackNumberBiger.size() > 0) {
						nextBigNumber = surplus + stackNumberBiger.poll();
						if (!checkNumGreater(nextBigNumber, numberSmaller)) {
							 tmpResult.add(0);
							 if (stackNumberBiger.size() > 0) {
									nextBigNumber = nextBigNumber + stackNumberBiger.poll();
								}
						}
					}
					if (!checkNumGreater(nextBigNumber, numberSmaller)) {
						 if(stackNumberBiger.size() <= 0) {
								result[1] = clear0(nextBigNumber);
								isStop = true;
								break;
							}
						
					} else {
						preProcess.add(nextBigNumber);
					}
					break;
				}
			}

		}
		while (tmpResult.size() > 0) {
			result[0] += tmpResult.poll();
		}

		return result;
	}

	public boolean checkNumGreater(String input1, String input2) {
		// loai bo 0 o dau

		input1 = clear0(input1);
		input2 = clear0(input2);

		boolean result = false;
		if (input1.length() > input2.length()) {
			return true;
		} else if (input1.length() == input2.length()) {
			ArrayList<Integer> nums1 = handleParseListNumber(input1);
			ArrayList<Integer> nums2 = handleParseListNumber(input2);
			for (int i = 0; i < nums1.size(); i++) {
				if (nums1.get(i) > nums2.get(i)) {
					return true;
				} else if (nums1.get(i) == nums2.get(i)) {
					result = true;
				} else if (nums1.get(i) < nums2.get(i)) {
					return false;
				}
			}
		}
		return result;
	}

	/**
	 * so sanh neu bang thi false
	 */
	public boolean checkNumGreaterNotEqual(String input1, String input2) {
		// loai bo 0 o dau

		input1 = clear0(input1);
		input2 = clear0(input2);

		boolean result = false;
		if (input1.length() > input2.length()) {
			return true;
		} else if (input1.length() == input2.length()) {
			ArrayList<Integer> nums1 = handleParseListNumber(input1);
			ArrayList<Integer> nums2 = handleParseListNumber(input2);
			for (int i = 0; i < nums1.size(); i++) {
				if (nums1.get(i) > nums2.get(i)) {
					return true;
				} else if (nums1.get(i) == nums2.get(i)) {
					result = false;
				} else if (nums1.get(i) < nums2.get(i)) {
					return false;
				}
			}
		}
		return result;
	}
	public boolean checkNumGreaterEqual(String input1, String input2) {
		// loai bo 0 o dau

		input1 = clear0(input1);
		input2 = clear0(input2);

		boolean result = false;
		if (input1.length() == input2.length()) {
			ArrayList<Integer> nums1 = handleParseListNumber(input1);
			ArrayList<Integer> nums2 = handleParseListNumber(input2);
			for (int i = 0; i < nums1.size(); i++) {
				if (nums1.get(i) == nums2.get(i)) {
					result = true;
				}else {
					return false;
				}
			}
		}
		return result;
	}
	private String clear0(String input1) {
		while (true && input1.length() > 1) {
			if (String.valueOf(input1.charAt(0)).equals("0")) {
				input1 = input1.substring(1, input1.length());
			} else {
				break;
			}
		}
		return input1;
	}
	private String clearMinus(String input1) {
		while (true && input1.length() > 1) {
			if (String.valueOf(input1.charAt(0)).equals("-")) {
				input1 = input1.substring(1, input1.length());
			} else {
				break;
			}
		}
		return input1;
	}
	public boolean checkPositiveNumber(String number) {
		if (String.valueOf(number.charAt(0)).equals("-")) {
			return false;
		}
		return true;
	}

	private ArrayList<Integer> handleParseListNumber(String str) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='-'&&i==0) {
				result.add(Integer.parseInt(String.valueOf("-"+str.charAt(++i))));
				
			}else {
				result.add(Integer.parseInt(String.valueOf(str.charAt(i))));				
			}
		}
		return result;
	}

	private ArrayList<Integer> handleParseListNumberLess(String str, int differenceNum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (str.charAt(0)=='-') {
			differenceNum=differenceNum+1;
		}
		for (int i = 0; i < str.length() + differenceNum; i++) {
			if (i < differenceNum) {
				result.add(0);
				continue;
			}
			if (str.charAt(i - differenceNum)=='-'&&(i - differenceNum)==0) {
				result.add(Integer.parseInt(String.valueOf("-"+str.charAt(++i - differenceNum))));	
				
			}else {
				result.add(Integer.parseInt(String.valueOf(str.charAt(i - differenceNum))));		
			}
		}
		return result;
	}

}

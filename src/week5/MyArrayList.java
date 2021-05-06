package week5;

public class MyArrayList<T> {
	private T[] data;

	public MyArrayList() {
		this.data = (T[]) new Object[] {};
	}
	public MyArrayList(T[] arr) {
		this.data = arr;
	}

	public void add(T input) {
		T[] tmpData = cloneArr(this.data, 1);
		tmpData[data.length] = input;
		this.data = tmpData;
	}

	public void add(T input, int index) {
		int tmpIndex = index<=size()?index:size();
		T[] tmpData1 = cloneArr(this.data, 1);

		// handle
		T[] tmpData2 = cloneArr(tmpData1);
		for (int i = 0; i < tmpData1.length; i++) {
			if (i > index) {
				tmpData2[i] = tmpData1[i-1];
			} else if (i == tmpIndex) {
				tmpData2[i] = input;
			} else {
				tmpData2[i] = tmpData1[i];
			}
		}

		this.data = tmpData2;
	}
	public T remove() {
		//handle
		T oldValue = this.data[size()-1];
		T[] tmpData1 = cloneArrMinus(this.data, 1);
		this.data=tmpData1;
		return oldValue;
	}
	public T remove(int index) {
		int tmpIndex = index<0?0:index;
		tmpIndex = tmpIndex<size()?tmpIndex:size()-1;
		T oldValue = this.data[tmpIndex];
		//handle
		T[] tmpData1 = cloneArr(this.data);
		T[] tmpData2 = cloneArrMinus(tmpData1,1);
		for (int i = 0; i < tmpData2.length; i++) {
			if (i > tmpIndex) {
				tmpData2[i] = tmpData1[i+1];
			} else if(i == tmpIndex) {
				tmpData2[i] = tmpData1[i+1];
			}else {
				tmpData2[i] = tmpData1[i];
			}
		}
		this.data=tmpData2;
		//
		return oldValue;
	}
	public int indexOf(T input) {
		T[] tmpData1 = cloneArr(this.data);
		for (int i = 0; i < tmpData1.length; i++) {
			if (input==tmpData1[i]) {
				return i;
			}
		}
		return -1;
	}
	public int indexOf(T[] input) {
		T[] tmpData1 = cloneArr(this.data);
		int countCorrect = 0;
		int result = -1;
		for (int i = 0; i < tmpData1.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (tmpData1[i]==input[j]) {
					countCorrect++;
					result=i;
					i++;
					if (i>=tmpData1.length) {
						break;
					}
				}else {
					result=-1;
				}
			
			}
			if (countCorrect==input.length) {
				return result-(input.length-1);
			}else if (countCorrect>0) {
				i-=countCorrect;
				countCorrect=0;
			}
		}
		return -1;
	}
	public int indexOf(MyArrayList<T> input) {
		T[] tmpInput = input.data;
		T[] tmpData1 = cloneArr(this.data);
		int countCorrect = 0;
		int result = -1;
		for (int i = 0; i < tmpData1.length; i++) {
			for (int j = 0; j < tmpInput.length; j++) {
				if (tmpData1[i]==tmpInput[j]) {
					countCorrect++;
					result=i;
					i++;
					if (i>=tmpData1.length) {
						break;
					}
				}else {
					result=-1;
				}
			
			}
			if (countCorrect==tmpInput.length) {
				return result-(tmpInput.length-1);
			}else if (countCorrect>0) {
				i-=countCorrect;
				countCorrect=0;
			}
		}
		return -1;
	}
	public int lastIndexOf(T input) {
		T[] tmpData1 = cloneArr(this.data);
		for (int i = tmpData1.length-1; i >=0 ; i--) {
			if (input==tmpData1[i]) {
				return i;
			}
		}
		return -1;
	}
	public int lastIndexOf(T[] input) {
		T[] tmpData1 = cloneArr(this.data);
		int countCorrect = 0;
		int result = -1;
		for (int i = tmpData1.length-1; i >=0; i--) {
			for (int j = input.length-1; j >=0; j--) {
				if (tmpData1[i]==input[j]) {
					countCorrect++;
					result=i;
					i--;
					if (i<0) {
						break;
					}
				}else {
					result=-1;
				}
			
			}
			if (countCorrect==input.length) {
				return result;
			}else if (countCorrect>0) {
				i+=countCorrect;
				countCorrect=0;
			}
		}
		return -1;
	}
	public int lastIndexOf(MyArrayList<T> input) {
		T[] tmpIndex = input.data;
		T[] tmpData1 = cloneArr(this.data);
		int countCorrect = 0;
		int result = -1;
		for (int i = tmpData1.length-1; i >=0; i--) {
			for (int j = tmpIndex.length-1; j >=0; j--) {
				if (tmpData1[i]==tmpIndex[j]) {
					countCorrect++;
					result=i;
					i--;
					if (i<0) {
						break;
					}
				}else {
					result=-1;
				}
			
			}
			if (countCorrect==tmpIndex.length) {
				return result;
			}else if (countCorrect>0) {
				i+=countCorrect;
				countCorrect=0;
			}
		}
		return -1;
	}
	public MyArrayList<T> sup(int start, int length) {
		start=start<0?0:start;
		length=length>size()-start?size()-start:length;
		T[] tmpResult = (T[]) new Object[length];
		for (int i = 0; i < length; i++) {
			tmpResult[i] = this.data[i+start];
		}
		return new MyArrayList<>(tmpResult);
	}
	public int size() {
		return data.length;
	}

	private T[] cloneArr(T[] data2) {
		T[] result = (T[]) new Object[data2.length];
		for (int i = 0; i < data2.length; i++) {
			result[i] = data2[i];
		}
		return result;
	}

	private T[] cloneArr(T[] data2, int number) {
		T[] result = (T[]) new Object[data2.length + number];
		for (int i = 0; i < data2.length; i++) {
			result[i] = data2[i];
		}
		return result;
	}
	private T[] cloneArrMinus(T[] data2, int number) {
		T[] result = (T[]) new Object[data2.length - number];
		for (int i = 0; i < result.length; i++) {
			result[i] = data2[i];
		}
		return result;
	}

	@Override
	public String toString() {
		String result = "[";
		for (int i = 0; i < data.length; i++) {
			if (i != 0) {
				result += ",";
			}
			result += data[i];
		}
		result += "]";
		return result;
	}

	
}

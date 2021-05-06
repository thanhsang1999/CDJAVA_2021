package week5;

import java.util.Iterator;

public class MyLinkedList<T> {
	private int size;
	private Node<T> first;
	private Node<T> last;

	public MyLinkedList() {
	}

	public MyLinkedList(T[] arr) {
		for (T t : arr) {
			add(t);
		}
	}

//Handle
	public boolean add(T item) {
		linkLast(item);
		return true;
	}

	public boolean add(T item, int index) {
		if (size == 0) {
			linkFirst(item);
		} else if (index <= 0) {
			linkFirst(item);
		} else if (index >= size) {
			linkLast(item);
		} else {
			Node<T> current = first;
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			insertNode(item, current);
		}

		return true;
	}

	private void insertNode(T item, Node<T> node) {
		// b1 lay prev node
		Node<T> nodePrev = node.getPrev();
		Node<T> newNode = new Node<T>(item, nodePrev, node);
		nodePrev.setNext(newNode);
		node.setPrev(newNode);
		size++;
	}

	public boolean addFirst(T item) {
		linkFirst(item);
		return true;
	}

	public boolean addLast(T item) {
		linkLast(item);
		return true;
	}

	private void linkLast(T item) {
		Node<T> tmpNode = last;
		Node<T> newNote = new Node<>(item, tmpNode, null);
		setLast(newNote);
		if (tmpNode == null) {
			setFirst(newNote);
		} else {
			tmpNode.setNext(newNote);
		}
		size++;
	}

	private void linkFirst(T item) {
		Node<T> tmpNode = first;
		Node<T> newNote = new Node<>(item, null, tmpNode);
		setFirst(newNote);
		if (tmpNode == null) {
			setLast(newNote);
		} else {
			tmpNode.setPrev(newNote);
		}
		size++;
	}

	public T remove() {
		if (last == null) {
			return null;
		}
		T tmpLast = last.getItem();
		unLinkLast();
		return tmpLast;
	}

	public T remove(int index) {
		if (size == 0) {
			return null;
		} else if (index <= 0) {
			T tmp = first.item;
			unLinkFirst();
			return tmp;
		} else if (index >= size - 1) {
			T tmp = last.item;
			unLinkLast();
			return tmp;
		} else {
			Node<T> current = first;
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			T tmp = current.item;
			unLinkNode(current);
			return tmp;
		}
	}

	public T removeFirst() {
		if (first == null) {
			return null;
		}
		T tmpFirst = first.getItem();
		unLinkFirst();
		return tmpFirst;
	}

	public T removeLast() {
		if (last == null) {
			return null;
		}
		T tmpLast = last.getItem();
		unLinkLast();
		return tmpLast;
	}

	private void unLinkNode(Node<T> current) {
		// lay prev va next
		Node<T> prevCurr = current.prev;
		Node<T> nextCurr = current.next;
		prevCurr.setNext(nextCurr);
		nextCurr.setPrev(prevCurr);
		current.setNext(null);
		current.setPrev(null);
		size--;
	}

	private void unLinkLast() {
		if (last != null) {
			Node<T> preLast = last.getPrev();
			if (preLast == null) {
				setFirst(null);
				setLast(null);
				size--;
			} else {
				preLast.setNext(null);
				setLast(preLast);
				size--;
			}
		}
	}

	private void unLinkFirst() {
		if (first != null) {
			Node<T> nextFirst = first.getNext();
			if (nextFirst == null) {
				setFirst(null);
				setLast(null);
				size--;
			} else {
				nextFirst.setPrev(null);
				setFirst(nextFirst);
				size--;
			}
		}
	}

	public int indexOf(T input) {
		Node<T> current = first;
		for (int i = 0; i < size; i++) {
			T tmpValue = current.item;
			if (tmpValue.equals(input)) {
				return i;
			}
			current = current.next;
		}
		return -1;
	}

	public int indexOf(MyLinkedList<T> input) {
		Node<T> current = first;
		Node<T> currentInput = input.first;
		int countCorrect = 0;
		int result = 0;
		int index = 0;
		while (current != null) {
			
			if (current.item.equals(currentInput.item)) {
				countCorrect++;
				//trung vi tri dau tien
				Node<T> tmpCurrent = current;
				Node<T> tmpCurrentInput = currentInput;
				for (int i = 0; i < input.size()-1; i++) {
					tmpCurrent=tmpCurrent.next;
					if (tmpCurrent==null) break;
					tmpCurrentInput=tmpCurrentInput.next;
					if(tmpCurrent.item.equals(tmpCurrentInput.item)) {
						countCorrect++;
					}else {
						countCorrect=0;
						current = current.next;
						index++;
						break;
					}
				}
				if(countCorrect==input.size()) {
					return index;
				}else {
					countCorrect=0;
					current = current.next;
					index++;
				}
			}else {
				current = current.next;
				index++;
			}
			
			
		}
		return -1;
	}
	public int lastIndexOf(T input) {
		Node<T> current = last;
		for (int i = 0; i < size; i++) {
			T tmpValue = current.item;
			if (tmpValue.equals(input)) {
				return size()-++i;
			}
			current = current.prev;
		}
		return -1;
	}

	public int lastIndexOf(MyLinkedList<T> input) {
		Node<T> current = last;
		Node<T> currentInput = input.last;
		int countCorrect = 0;
		int index = 0;
		while (current != null) {
			
			if (current.item.equals(currentInput.item)) {
				countCorrect++;
				//trung vi tri dau tien
				Node<T> tmpCurrent = current;
				Node<T> tmpCurrentInput = currentInput;
				for (int i = 0; i < input.size()-1; i++) {
					tmpCurrent=tmpCurrent.prev;
					if (tmpCurrent==null) break;
					tmpCurrentInput=tmpCurrentInput.prev;
					if(tmpCurrent.item.equals(tmpCurrentInput.item)) {
						countCorrect++;
					}else {
						countCorrect=0;
						current = current.prev;
						index++;
						break;
					}
				}
				if(countCorrect==input.size()) {
					return size-(index+input.size);
				}else {
					countCorrect=0;
					current = current.prev;
					index++;
				}
			}else {
				current = current.prev;
				index++;
			}
			
			
		}
		return -1;
	}
	
	public MyLinkedList<T> sup(int start, int length) {
		start=start<0?0:start;
		length=length<0?0:length;
		start=start>size()?size():start;
		length=length>size()-start?size()-start:length;
		MyLinkedList<T> result = new MyLinkedList<T>();
		Node<T> current = first;
		for (int i = 0; i < start+length; i++) {
			if(i>=start) {
				result.add(current.item);
			}
			current=current.next;
		}
		return result;
		
	}
	
	public int size() {
		return size;
	}

	// Khai bao getter,setter
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node<T> getFirst() {
		return first;
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}

	public Node<T> getLast() {
		return last;
	}

	public void setLast(Node<T> last) {
		this.last = last;
	}

	/** Node save data */
	private class Node<T> {
		private T item;
		private Node<T> prev;
		private Node<T> next;

		public Node(T item, Node<T> prev, Node<T> next) {
			super();
			this.item = item;
			this.prev = prev;
			this.next = next;
		}

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

	}

	@Override
	public String toString() {
		Node<T> current = getFirst();
		if (current == null) {
			return "[]";
		}
		String result = "[" + current.getItem();
		current = current.getNext();
		while (current != null) {
			result += "," + current.getItem();
			current = current.getNext();
		}
		result += "]";
		return result;
	}
}

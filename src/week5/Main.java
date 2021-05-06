package week5;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
//		LinkedList<String> abc = new LinkedList<String>();
//		abc.add("Nguyen");
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>(new Integer[] {232,1,1,2,3,99,4,5,6,1,2,7,8,23});
		MyLinkedList<Integer> myLinkedList2 = new MyLinkedList<Integer>(new Integer[] {7,8,23,2});
		System.out.println(myLinkedList);
//		System.out.println(myLinkedList2);
//		System.out.println(myLinkedList.lastIndexOf(myLinkedList2));
		System.out.println(myLinkedList.sup(2,999));
//		myLinkedList.add("Nguyen");
//		myLinkedList.add("Sang");
		System.out.println();
//		System.out.println(myLinkedList+" size: "+myLinkedList.size());
		
		
	}
}

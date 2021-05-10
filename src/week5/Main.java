package week5;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
//		LinkedList<String> abc = new LinkedList<String>();
//		abc.add("Nguyen");
//		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>(new Integer[] {232,1,1,2,3,99,4,5,6,1,2,7,8,23});
//		MyLinkedList<Integer> myLinkedList2 = new MyLinkedList<Integer>(new Integer[] {7,8,23,2});
//		System.out.println(myLinkedList);
//		System.out.println(myLinkedList2);
//		System.out.println(myLinkedList.lastIndexOf(myLinkedList2));
//		System.out.println(myLinkedList.sup(2,999));
//		myLinkedList.add("Nguyen");
//		myLinkedList.add("Sang");
//		System.out.println();
//		System.out.println(myLinkedList+" size: "+myLinkedList.size());
		Student student1 = new Student("Sang1");
		Student student2 = new Student("Sang2");
		Student student3 = new Student("Sang1");
		Student student4 = new Student("Sang4");
		
		MyArrayList<Student> myArrayList = new MyArrayList<Student>();
		myArrayList.add(student1);
		myArrayList.add(student2);
		myArrayList.add(student3);
		myArrayList.add(student4);
		System.out.println(myArrayList.indexOf(new Student("Sang4")));		
//		LinkedList<Student> linkedList = new LinkedList<Student>();
//		linkedList.add(student1);
//		linkedList.add(student2);
//		linkedList.add(student3);
//		linkedList.add(student4);
//		System.out.println(linkedList.get(0));
//		System.out.println(linkedList.get(1));
//		System.out.println(linkedList.get(2));
//		System.out.println(linkedList.get(3));
//		System.out.println(linkedList.indexOf(student4));
//		System.out.println(linkedList);
	}
}

package week5;

public class Student {
String name;

public Student(String name) {
	super();
	this.name = name;
}
@Override
	public String toString() {
		return "Student{name=\'"+name+"\'}";
	}
@Override
	public boolean equals(Object obj) {
		Student tmpStudent = (Student) obj;
		return name.equals(tmpStudent.name);
	}
}

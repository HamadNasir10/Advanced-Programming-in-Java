package labS;

import java.util.Date;

public class StudentFactory {
	
	public static Student getStudentObject(String firstName, String lastName, Date dob, String address, String className) {
		return new Student(firstName, lastName, dob, address, className);
	}
	
	public static Student getStudentObjectStructure() {
		return new Student();
	}
}

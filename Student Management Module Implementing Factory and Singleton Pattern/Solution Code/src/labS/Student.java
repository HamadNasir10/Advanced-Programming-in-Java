package labS;

import java.util.Date;

public class Student {
	
	private String firstName;
	private String lastName;
	private Date dob;
	private String address;
	private String className;
	
	//empty constructor
	Student(){}
	
	//another constructor with parmeters 
	Student(String firstName, String lastName, Date dob, String address, String className){
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.className = className;
	}
	
	
	public String getAddress() {
		return address;
	}
	
	public String getClassName() {
		return className;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	//Returns formatted Student String
	@Override
	public String toString() {
		return String.format("FirstName: %s\nLastName: %s\nDate Of Birth: %s\nAddress; %s\nClass Name: %s\n ",
				this.getFirstName(),this.getLastName(), this.getDob(),this.getAddress(),this.getClass());
	}
}

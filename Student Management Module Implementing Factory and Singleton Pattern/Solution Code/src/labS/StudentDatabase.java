package labS;


 
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

public class StudentDatabase {	
	private List<Student> students = new ArrayList<Student>();   //stores all the students from file
	
	public void addStudent(String firstName, String lastName, Date dob, String address, String className) {
		
		//returns Student object given the parameters following the Factory pattern
		Student student = StudentFactory.getStudentObject(firstName,lastName,dob,address,className);
		
		File file = FileSingleton.getFile();
        FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		FileOutputStream fop = null;
		try {
			fop = new FileOutputStream(file,true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			SequenceWriter seqWriter = mapper.writer().writeValues(fileWriter);
			seqWriter.write(student);
			fop.write("\n".getBytes());
	        seqWriter.close();
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
	public void displayStudents() {
		File studentsFile = FileSingleton.getFile();
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(studentsFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//Reading all the jsons in the List converting to Student type using Jackson's readValue()
		String stud;
		try {
			while ((stud = br.readLine()) != null) {
				students.add(mapper.readValue(stud, Student.class));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Calling toString method of Student to display formatted student object
		for(Student student: students) {
			System.out.println(student);
		}
				
	}
	
}
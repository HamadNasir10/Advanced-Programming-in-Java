package labS;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		StudentDatabase database = new StudentDatabase();	
			
			
				System.out.print("Enter first Name: ");
				String firstName = input.next();
				
				System.out.print("Enter last Name: ");
				String lastName = input.next();
				
				System.out.print("Enter date of birth (e.g 27-AUG-1997): ");
				String dob = input.next();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				Date date = null;
				try {
					date = dateFormat.parse(dob);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.print("Enter Address: ");
				String address = input.next();
				
				System.out.print("Enter class Name: ");
				String className = input.next();
				
				database.addStudent(firstName, lastName, date, address, className);	
				database.displayStudents();
				
			}
}

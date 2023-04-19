import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Collections;

public class StudentRegistration {

    public static void main(String[] args)  {
      //creating two collections one for student entries and another for id's
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList idList = new ArrayList();
        Scanner input = new Scanner(System.in);
        
		int choice=0 ;  
//using do while loop for showing options after every student entry
        do {
            System.out.println("1. Register Student");
            System.out.println("2. View Student Information");
            System.out.println("3. Exit");
			System.out.println("4. View Full Register");
            System.out.print("Enter your choice: ");
               // validating user input for choice
			   try
                {
				choice= input.nextInt();
				
                }
                catch (InputMismatchException e)
                {
					System.out.println("Pls Select the Choice As Mention in above range");
					input.nextLine();
					continue;

                } 
          // providing choices implementation using Switch Case     
            switch (choice) {
                case 1:
                    Student student = new Student();
                    System.out.print("Enter name: ");
                    String name = input.next();
					//validating user input for name field 
                    try {
                        student.setName(name);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

					System.out.print("Enter ID: ");
                    String id = input.next();
					//validating user input for id field 
                    try {
						//adding id if id is not present in idlist collection otherwise completing iteration
						if(!idList.contains(id)){
						idList.add(id);
                        student.setid(id);
					 	}
						else {
							   System.out.println("ID is not Available");
							   continue;
						}
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    System.out.print("Enter email: ");
                    String email = input.next();
					//validating user input for email field 
                    try {
                        student.setEmail(email);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    System.out.print("Enter phone number: ");
                    String phoneNumber = input.next();
					//validating user input for phone number field 
                    try {
                        student.setPhoneNumber(phoneNumber);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
					//finally Adding student to students collection after validating all inputs

                    students.add(student);
                    System.out.println("Student registered successfully!");
                    break;

                case 2:
					// searching student details using for each loop on the basis of emailid  and getter method
                    System.out.print("Enter student email: ");
                    String studentEmail = input.next();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getEmail().equals(studentEmail)) {
							System.out.println("ID: " + s.getid());
                            System.out.println("Name: " + s.getName());
                            System.out.println("Email: " + s.getEmail());
                            System.out.println("Phone Number: " + s.getPhoneNumber());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;
                case 4:
					//displaying all entries 
					System.out.println("\t\t\tStudent Register");
				System.out.println("========================================================================");
				Collections.sort(students);
				for(Student s: students)
				{
					 System.out.println(s);
				}
				break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
			 

        } while (choice != 3);
    }
}
//creating Student class 
class Student implements Comparable {
    private String name;
    private String email;
    private String phoneNumber;
	private String id;
//creating setter and getter methods and adding validation check logic for every field
	public void setid(String id ) throws IllegalArgumentException{  
		for(int i=0; i<id.length();i++)
		{
			if (id.charAt(i)>=48 && id.charAt(i)<= 57)
			{
				continue;
			}else
			{
				throw new IllegalArgumentException("Invalid id. ID Should contain only digits 0 to 9.");
			}
		}
		this.id=id;
	}
	public String getid()
	{
		return this.id;
	}
	
    public void setName(String name) throws IllegalArgumentException  {
        if (name.matches("[a-zA-Z ]+")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name. Name should contain only alphabets and spaces.");
        }
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (email.matches("[\\w.]+@[\\w.]+")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email. Please enter a valid email address.");
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
        if (phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid phone number. Please enter a 10-digit phone number.");
        }
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
	//@Override toString method to display states 
	public String toString()
	{
		return "ID: "+id+"\t,Name: "+name+ "\t,Email: "+email+"\t,Phone Number: "+phoneNumber;
	}

	// @Override compareTo method of Comparable interface for sorting purpose on the basis of id's
	public int compareTo(Object o)
	{  Student temp = (Student)o;
	//as id is taken in string format so converting it into Integer Object for comparison purpose
		if (Integer.parseInt(this.id) > Integer.parseInt(temp.id))
		{
			return 1;
		}
		if (Integer.parseInt(this.id) < Integer.parseInt(temp.id))
		{
			return -1;
		}
		return 0;
	}

	
}
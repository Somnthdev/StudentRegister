import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Collections;

public class StudentRegistration {

    public static void main(String[] args)  {
        ArrayList<Student> students = new ArrayList<Student>();
		ArrayList idList = new ArrayList();
        Scanner input = new Scanner(System.in);
        
		int choice=0 ;  

        do {
            System.out.println("1. Register Student");
            System.out.println("2. View Student Information");
            System.out.println("3. Exit");
			System.out.println("4. View Full Register");
            System.out.print("Enter your choice: ");
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
             // choice = input.nextInt();
                  //  input.nextLine();    
              
          
            switch (choice) {
                case 1:
                    Student student = new Student();
                    System.out.print("Enter name: ");
                    String name = input.next();
                    try {
                        student.setName(name);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

					System.out.print("Enter ID: ");
                    String id = input.next();
                    try {
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
                    try {
                        student.setEmail(email);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    System.out.print("Enter phone number: ");
                    String phoneNumber = input.next();
                    try {
                        student.setPhoneNumber(phoneNumber);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    students.add(student);
                    System.out.println("Student registered successfully!");
                    break;

                case 2:
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

class Student implements Comparable {
    private String name;
    private String email;
    private String phoneNumber;
	private String id;

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

	// 
	public int compareTo(Object o)
	{  Student temp = (Student)o;
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
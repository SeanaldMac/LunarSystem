// Sean MacDonald
// 111152768
// CSE 214 HW5
// Allows user to interact with database of Students
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LunarSystem
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		String webID = "", department, semester, course = "", choice = "", key = "";
		int number, menu = 0; // menu = 0 for general, 1 for student, 2 for registrar options
		Student registrar = new Student();
		/*
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("G:\\address.ser");
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(fout);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		*/
		
		System.out.println("Welcome to the Lunar System");
		
		
		
		/*
		ObjectInputStream objectinputstream = null;
		try {
			FileInputStream streamIn = new FileInputStream("G:\\address.ser");
		    objectinputstream = new ObjectInputStream(streamIn);
		    Student readCase = null;
		    do {
		        readCase = (Student) objectinputstream.readObject();
		        if(readCase != null){
		        	key = "" + readCase.getWebID().charAt(0) + readCase.getWebID().charAt(webID.length() - 1);
		            database.put(key ,readCase);
		        } 
		    } while (readCase != null);
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    if(objectinputstream != null){
		        try {
					objectinputstream .close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } 
		}
		
		*/
		
		
		do
		{
		
			
			
			
			if(menu == 0)
			{
			switch(choice)
			{
			case "L":
			case "l":
				choice = "";
				System.out.println("Please enter webid: ");
				webID = input.next();
				
				if(webID.length() < 2)
				{
					System.out.println("webID too short to use");
					break;
				}
				
				key = "" + webID.charAt(0) + webID.charAt(webID.length() - 1);
				if(registrar.getWebID() == null)
				{
					registrar = new Student(webID);
					
					System.out.println("Welcome " + webID);
					menu = 2;
					System.out.println();
				}
				else if(webID.equals(registrar.getWebID()))
				{
					System.out.println("Welcome " + webID);
					System.out.println();
					menu = 2;
				}
				else if(database.containsKey(key))
				{
					System.out.println("Welcome " + webID);
					System.out.println();
					menu = 1;
				}
				else
				{
					System.out.println("Specified webID does not exist in the system");
				}
				break;
			case "X":
			case "x":
				/*
				try{
				    fout = new FileOutputStream("G:\\address.ser", true);
				    oos = new ObjectOutputStream(fout);
				    oos.writeObject(database);
				} catch (Exception ex) {
				    ex.printStackTrace();
				} finally {
				    if(oos != null){
				        try {
							oos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    } 
				}
				*/
				choice = "q";
				break;
			
			}
			
			
			
			}
			
			if(menu == 1)
			{
				switch(choice)
				{
				case "A":
				case "a":
					System.out.println("Please enter course department: ");
					department = input.next();
					System.out.println("Please enter course number: ");
					number = input.nextInt();
					System.out.println("Please select a semester: ");
					semester = input.next();
					
					database.get(key).getCourses().add(new Course(department, number, semester));
					System.out.println(database.get(key).getCourses().get(database.get(key).getCourses().size() - 1));
					System.out.println(department + " " + number + " added in " + semester);
					System.out.println();
					break;
				case "D":
				case "d":
					System.out.println("Please enter course department");
					department = input.next();
					System.out.println("Please enter course number");
					number = input.nextInt();
					
					for(int i = 0; i < database.get(key).getCourses().size(); i++)
					{
						if(database.get(key).getCourses().get(i).getDepartment().equals(department) && database.get(key).getCourses().get(i).getNumber() == number)
						{
							String sem = database.get(key).getCourses().get(i).getSemester();
							database.get(key).getCourses().remove(i);
							System.out.println(department + " " + number + " dropped from " + sem);
							break;
						}
					}
					break;
				case "C":
				case "c":
					ArrayList<Course> courses = new ArrayList<>();
					for(int i = 0; i < database.get(key).getCourses().size(); i++)
					{
						courses.add(database.get(key).getCourses().get(i));
					}
					
					courseSort(courses);
					System.out.println();
					System.out.println("Dept. Course Semester");
					for(Course coursee : courses)
					{
						System.out.println(coursee.toString());
					}
					break;
				case "S":
				case "s":
					ArrayList<Course> coursess = database.get(key).getCourses();
					semesterSort(coursess);
					System.out.println();
					System.out.println("Dept. Course Semester");
					for(Course coursee : coursess)
					{
						System.out.println(coursee.toString());
					}
					break;		
				case "L":
				case "l":
					choice = "";
					System.out.println(database.get(key).getWebID() + " logged out");
					menu = 0;
					System.out.println();
					break;
				}	
			}
			
			if(menu == 2)
			{
				switch(choice)
				{
				case "R":
				case "r":
					System.out.println("Please enter a webid for the new student: ");
					webID = input.next();
					if(webID.length() < 2)
					{
						System.out.println("webID too short to use");
						break;
					}
					key = "" + webID.charAt(0) + webID.charAt(webID.length() - 1);
					
					if(database.containsKey(key))
					{
						System.out.println(webID + " is already registered");
						break;
					}
					
					database.put(key, new Student(webID));
					
					System.out.println(webID + " registered");
					System.out.println();
					break;
				
				case "D":
				case "d":
					System.out.println("Please enter a webid for the student to be deregistered: ");
					webID = input.next();
					key = "" + webID.charAt(0) + webID.charAt(webID.length() - 1);
					
					if(database.containsKey(key))
					{
						database.remove(key);
						
						System.out.println(webID + " deregistered");
						System.out.println();
						break;
					}
					else
					{
						System.out.println("Student not found");
						System.out.println();
						break;
					}
					
				case "E":
				case "e":
					System.out.println("Please enter department: ");
					department = input.next();
					System.out.println("Please enter course number: ");
					number = input.nextInt();
					
					System.out.println();
					System.out.println("Students Registered in " + course + ":");
					System.out.println("Student   Semester");
					System.out.println("--------------------");
					
					for(Student student: database.values())
					{
						for(int i = 0; i < student.getCourses().size(); i++)
						{
							if(student.getCourses().get(i).getDepartment().equalsIgnoreCase(department) && student.getCourses().get(i).getNumber() == number)
							{
								System.out.println(student.toString() + "      "+  student.getCourses().get(i).getSemester());
								break;
							}
						}
					}
					break;
				case "L":
				case "l":
					choice = "";
					System.out.println(registrar + " logged out");
				menu = 0;
				System.out.println();
				break;
				
				
				}
				
				
		
				
			}
			
			
			
			
			if(!choice.equalsIgnoreCase("Q"))
			{
				switch(menu)
				{
				case 0:
					System.out.println("Menu: ");
					System.out.println("	L) Login");
					System.out.println("	X) Save state and quit");
					System.out.println("	Q) Quit without saving state");
					System.out.println();
					break;
				case 1:
					System.out.println("Menu: ");
					System.out.println("	A) Add a class");
					System.out.println("	D) Drop a class");
					System.out.println("	C) View your classes sorted by course name/department");
					System.out.println("	S) View your classes sorted by semester");
					System.out.println("	L) Logout");
					System.out.println();
					break;
				case 2:
					System.out.println("Menu: ");
					System.out.println("	R) Register a student");
					System.out.println("	D) De-egister a student");
					System.out.println("	E) View course enrollment");
					System.out.println("	L) Logout");
					System.out.println();
					break;
				}
				System.out.println();
				
				System.out.println("Please select an option: ");
				choice = input.next();
				
			}
			
			
			
			
			
			
			
		}
		while(!choice.equalsIgnoreCase("Q"));
		
		System.out.println("Goodbye, please pick the right SUNY next time");
		
		
	
		
		
		
	}
	
	private static HashMap<String, Student> database = new HashMap(26);
	
	
	
	

	public static void courseSort(ArrayList<Course> arr)
	{
		CourseNameComparator comp = new CourseNameComparator();
		int n = arr.size();
		 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (comp.compare(arr.get(j), arr.get(min_idx)) == -1)
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            Course temp = new Course(null, 0, null);
            temp.setDepartment(arr.get(min_idx).getDepartment());
            temp.setNumber(arr.get(min_idx).getNumber());
            temp.setSemester(arr.get(min_idx).getSemester());
           // arr[min_idx] = arr[i];
            arr.get(min_idx).setDepartment(arr.get(i).getDepartment());
            arr.get(min_idx).setNumber(arr.get(i).getNumber());
            arr.get(min_idx).setSemester(arr.get(i).getSemester());
            
           // arr[i] = temp;
            arr.get(i).setDepartment(temp.getDepartment());
            arr.get(i).setNumber(temp.getNumber());
            arr.get(i).setSemester(temp.getSemester());
        }

	}
	
	public static void semesterSort(ArrayList<Course> arr)
	{
		SemesterComparator comp = new SemesterComparator();
		int n = arr.size();
		 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (comp.compare(arr.get(j), arr.get(min_idx)) == -1)
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            Course temp = new Course(null, 0, null);
            temp.setDepartment(arr.get(min_idx).getDepartment());
            temp.setNumber(arr.get(min_idx).getNumber());
            temp.setSemester(arr.get(min_idx).getSemester());
           // arr[min_idx] = arr[i];
            arr.get(min_idx).setDepartment(arr.get(i).getDepartment());
            arr.get(min_idx).setNumber(arr.get(i).getNumber());
            arr.get(min_idx).setSemester(arr.get(i).getSemester());
            
           // arr[i] = temp;
            arr.get(i).setDepartment(temp.getDepartment());
            arr.get(i).setNumber(temp.getNumber());
            arr.get(i).setSemester(temp.getSemester());
        }
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

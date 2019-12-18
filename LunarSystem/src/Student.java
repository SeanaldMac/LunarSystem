// Sean MacDonald
// 111152768
// CSE 214 HW5
// Stored element in the Lunar System Database
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable
{
	private String webID;
	private ArrayList<Course> courses;
	
	public Student()
	{
		courses = new ArrayList<Course>();
	}
	
	public Student(String webID)
	{
		this.webID = webID;
		
		courses = new ArrayList<Course>();
	}
	
	
	
	
	// Getters and Setters
	public void setWebID(String webID)
	{
		this.webID = webID;
	}
	
	public String getWebID()
	{
		return webID;
	}
	
	public void setCourses(ArrayList<Course> courses)
	{
		this.courses = courses;
	}
	
	public ArrayList<Course> getCourses()
	{
		return courses;
	}
	
	@Override 
	public String toString()
	{
		return "" + webID;
	}
	
	
	
	
}

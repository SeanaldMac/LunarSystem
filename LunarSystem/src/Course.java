import java.io.Serializable;

// Sean MacDonald
// 111152768
// CSE 214 HW5
// Has a designated department, three digit number and a semester associated with it, courses are associated with students that are taking them
public class Course implements Serializable
{
	private String department;
	private int number;
	private String semester;
	
	public Course(String department, int number, String semester)
	{
		this.department = department;
		this.number = number;
		this.semester = semester;
	}
	
	
	
	
	
	
	// Getters and Setters
	public void setDepartment(String department)
	{
		this.department = department;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public void setNumber(int number)
	{
		this.number = number;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public void setSemester(String semester)
	{
		this.semester = semester;
	}
	
	public String getSemester()
	
	{
		return semester;
	}
	
	@Override
	public String toString()
	{
		return "" + department + " " + number + " " + semester;
	}
	
	
	
	
	
	
	
	
	
}

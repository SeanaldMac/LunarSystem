// Sean MacDonald
// 111152768
// CSE 214 HW5
// Compares based on Department, then Number
import java.util.Comparator;

public class CourseNameComparator implements Comparator
{
	public CourseNameComparator()
	{
	}
	
	// Priority: Department, Number:: returns -1 if left is less than right, 0 if the same, 1 if left great than right
	@Override
	public int compare(Object o1, Object o2)
	{
		Course left = (Course) o1;
		Course right = (Course) o2;
		
		// Compares Departments
		for(int i = 0; i < left.getDepartment().length() && i < right.getDepartment().length(); i++)
		{
			if(Character.getNumericValue(left.getDepartment().charAt(i)) < Character.getNumericValue(right.getDepartment().charAt(i)))
				return -1;
			if(Character.getNumericValue(left.getDepartment().charAt(i)) > Character.getNumericValue(right.getDepartment().charAt(i)))
				return 1;
		}
		
		// Compares Numbers
		if(left.getNumber() < right.getNumber())
			return -1;
		else if(left.getNumber() > right.getNumber())
			return 1;
		
		return 0;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

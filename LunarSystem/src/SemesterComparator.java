// Sean MacDonald
// 111152768
// CSE 214 HW5
// Compares based on Semester
import java.util.Comparator;

public class SemesterComparator implements Comparator
{

	// Priority: Semester:: returns -1 if left is less than right, 0 if the same, 1 if left great than right
	public int compare(Object o1, Object o2)
	{
		Course left = (Course) o1;
		Course right = (Course) o2;
		
		// Compares Semesters
		for(int i = 0; i < left.getDepartment().length() && i < right.getDepartment().length(); i++)
		{
			if(Character.getNumericValue(left.getSemester().charAt(i)) < Character.getNumericValue(right.getSemester().charAt(i)))
				return -1;
			if(Character.getNumericValue(left.getSemester().charAt(i)) > Character.getNumericValue(right.getSemester().charAt(i)))
				return 1;
		}
		
		return 0;
	}

	
	
	
	
	
}

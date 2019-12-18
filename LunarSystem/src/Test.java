// Testing
public class Test
{
	public static void main(String [] args)
	{
		Course c1 = new Course("CSE", 214, "F2017");
		Course c2 = new Course("CSE", 214, "F2017");
		Course c3 = new Course("CSE", 219, "F2017");
		Course c4 = new Course("CSE", 214, "S2018");
		Course c5 = new Course("AMS", 214, "F2017");
		CourseNameComparator comp = new CourseNameComparator();
		SemesterComparator sComp = new SemesterComparator();
		
		System.out.println(comp.compare(c1, c2)); // 0
		System.out.println(comp.compare(c1, c3)); // -1
		System.out.println(comp.compare(c3, c2)); // 1
		System.out.println(comp.compare(c1, c5)); // 1
		System.out.println(comp.compare(c5, c1)); // -1
		System.out.println();
		
		System.out.println(sComp.compare(c1, c2)); // 0
		System.out.println(sComp.compare(c1, c4)); // -1
		System.out.println(sComp.compare(c4, c1)); // 1
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
}

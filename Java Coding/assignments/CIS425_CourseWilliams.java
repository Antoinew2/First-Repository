package assignments;

public class CIS425_CourseWilliams {
	/*Here are the methods needed for CIS425_Course:

	Constructor, create a class of (int capacity) CIS425_Students
	    Use an array: roster[ ] of size capacity to hold the CIS425_Student objects
	    Also, save the capacity as a class variable and set an enrolled class variable to 0
	public boolean addStudent( String name, int num_exams )
	    Creates a new CIS425_Student( name, num_exams ) object and add to the roster[ ] array
	    Check to see if there is space for the new student, if no room, return false
	    Create a new CIS425_Student object and add to the roster[ ] array, return true
	public CIS425_Student findStudent( String name )
	    Find student with name and return object
	    If student cannot be found, return null
	public double computeAverage( int exam )
	    Compute and return the course average on a specific exam ( that is, 1, 2, …) for all the students
	    Check for divide by 0 and other errors
	main( )
	    Create a CIS425_Course of 30 students
	    Add two (2) students: Sally Smarty and Phil Phailure, each with 3 exams
	    Search for these two students and give them a grade of 100 and 60 respectively on exam 1
	    Output the average of the class on exam 1
		*/
	
	// jrg public CIS425_CourseWilliams[] roster;
	public CIS425_StudentWilliams[] roster;
	public int capacity;
	public static int enrolledclass=0;
	int AverageCounter =0;
	int Average=0;
	int NewCounter=-1;
	public  CIS425_CourseWilliams (int size ) 
		 { 
		capacity=size;	
		roster= new CIS425_StudentWilliams[capacity];
        
		 }
	     public boolean addStudent ( String name, int num_exams ) 
	     { 
	    	 
	    	 CIS425_StudentWilliams s = new CIS425_StudentWilliams(name, num_exams);
	    	 if( enrolledclass >= capacity)
	    	 {
	    		 return false;
	    		 
	    	 }
	    	 else 
	    	 {

	    		 roster[enrolledclass] = s;
	    	 enrolledclass++;
	    	 
	    	 return true;
	    	 }
	     }
	     public CIS425_StudentWilliams findStudent( String name ) 
	     {
	    	 
	    	int i = 0;
	    		 while (i < enrolledclass)
	    		 {
	    			 if( roster[i].Studentname==name)
	    		 return  roster[i];
	    			 else
	    				 i++;
	    		 }
	    	return null;	 
	    	 
	    	 
	    	 
	     }
	     public double computeAverage( int exam ) 
	     { 
	    	
	    	  while (AverageCounter < enrolledclass)
	    	 {
	    		 Average= Average + roster[AverageCounter].getGrade(exam);
	    		 AverageCounter=AverageCounter +1;
	    	 }
	    	 return Average/enrolledclass; 
	     } 
	     public static void main( String[] args ) 
	     { 
	    	int PhilGrade =60;
	    	int SallyGrade=100;
	    	 int size = 30;
	    	 CIS425_CourseWilliams cis425 = new CIS425_CourseWilliams(size); 
	    	 	

	    	 cis425.addStudent("Sally Smarty",3);

	    	 System.out.println("Added Sally...");
	    	cis425.findStudent("Sally Smarty").addGrade(0,100);
	    	System.out.println("Added exam 1 for Sally with grade of 100");
	    	cis425.addStudent("Phil Phailure",3);
	    	System.out.println("Added Phil");
	    	cis425.findStudent("Phil Phailure").addGrade(0,60);
	    	System.out.println("Added exam 1 for Phil with grade of 60");
	    	
	    	 System.out.println("The Average of the students who took exam one is: "+cis425.computeAverage(0));
	    	
	     }
}

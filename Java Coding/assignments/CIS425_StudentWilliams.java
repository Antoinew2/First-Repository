package assignments;


public class CIS425_StudentWilliams extends StudentWilliams {
   


	/* For this assignment you will create a Java class named CIS425. This program can be used to manage this CIS 425 course. Your task is to extend the base Student class definition (below) and customize it for CIS 425 students. Next, you will create a new class definition which will manage all CIS 425 students in this course. So, your program will have the following classes:

    Student (already written for you as a base class)
    CIS425_Student (extends Student, you will have to write this)
    CIS425_Course (manages all CIS425_Student objects, you will have to write this)
Here are the methods needed for CIS425_Student:

Constructor: public CIS425_Student( String name, int num_exams )
    Create an int array exams[num_exams] which will hold all exam grades for a student
    Save num_exams for later error checking
public boolean addGrade( int exam, int grade )
    Save a grade in the exams[ ] array at index exam
    If exam is out of range, return false (Note: exams are numbered 1,2,3,....)
    If OK, save the grade in exams[ ] array and return true
public int getGrade( int exam )
    Return grade saved in exams[ ] array at index exam
    If exam is out of range, return -1
    If OK, return grade from exams[ ] array
public String getName( )
    Return student name
*/
public int[] exams;
public String Studentname;
public int numexams;
 
public CIS425_StudentWilliams( String name, int num_exams)
{ 
	
	super(name);
	Studentname=name; 
	exams = new int[num_exams];
	numexams=num_exams;
}
	
public  boolean addGrade( int exam, int grade ) 
{ 
	if(exam < numexams && exam >= 0)
	{
		exams[exam]=grade;
	System.out.println("added grade of  "+ grade+ " to "+ exam+ " slot.");
		return true;
	}
	else
		System.out.println("not working");
		return false;
}
	    
public int getGrade( int exam ) 
{ 
	if (exam <numexams && exam >=0)
		return exams[exam]; 
	else return -1;
}
	    

}

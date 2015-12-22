package exercises;

/*
 * File: GradeCalculator.java
 * Author: Java, Java, Java
 * Description: Instances of this class are used to calculate
 *  a course average and a letter grade. In order to calculate
 *  the average and the letter grade, a GradeCalculator must store
 *  two essential pieces of data: the number of grades and the sum
 *  of the grades.  Therefore these are declared as instance variable.
 *  Each time calcAverage(grade) is called, a new grade is added to
 *  the running total, and the number of grades is incremented.
 */

/*
 *  1) Change the program so that it outputs +/- letter grades (you can decide
 *     the thresholds )
 *
 *  2) Output, in addition to the average and letter grade, the number of grades
 *     entered so far. This requires a new method in the GradeCalculator class:
 *       public int getCount()
 *
 *  3) Modify the addGrade() method in the GradeCalculator class so that it will
 *     reject grades that are out of range... and do not update the grade count if
 *     there is a problem with the grade range.
 *     a) notify the user that the grade has been rejected, but keep the program
 *        running
 *
 *  4) Check user input for errors. The program should handle the entry of characters,
 *     and other non-numeric symbols without causing a crash
 */

public class GradeCalculator
{
   public int getCount()
   {
	   return gradeCount;
   }
	private int gradeCount = 0;      // GradeCalculator's internal state
    private double gradeTotal = 0.0;

    /**
     * calcAdd() is given a grade, which is added to
     *  the running total. It then increments the grade count
     *  .
     */

    // Hint: change code to reject grades out of the range 0 to 100 by returning false, do
    // not update gradeCount if there is an error
    public boolean addGrade(double grade)
    {
    	if (grade <0 || grade >100)
    	{
    		System.out.println("\nNumbers need to be between 0 and 100");
    		return false;
    	}
    	else
    	{
    	gradeTotal += grade;
        ++gradeCount;
        return true;
        }
    } // calcAdd

    /**
     * calcAverage() is given a grade, which is added to
     *  the running total. It then increments the grade count
     *  and returns the running average.
     */
    public double calcAvg()
    {
        return gradeTotal/gradeCount;
    } // calcAvg

//	HINT:
//	Add a new public method that returns the gradeCount
//	public int getCount() -- fill in rest of code

    /**
     * calcLetterGrade() returns the letter grade for this object.
     * Algorithm: The course average is first computed from the stored
     *  gradeTotal and gradeCount and then converted into a
     *  letter grade.
     * @return a String representing "A" through "F"
     */
    public String calcLetterGrade ()
    {
		// HINT: Change if/else logic for +/- letter grades

        double avg = gradeTotal / gradeCount; // Get the average
        if (avg >= 95)
        	return "A+";
        else if (avg >= 90.0)
            return "A";
        else if(avg>=87)
        	return "A-";
        else if (avg >=84)
        	return "B+";
        else if (avg >= 80.0)
            return "B";
        else if(avg >= 77)
        	return "B-";
        else if (avg>=74)
        	return "C+";
        else if (avg >= 70.0)
            return "C";
        else if ( avg >=67)
        	return "C-";
        else if ( avg>=64)
        	return "D+";
        else if (avg >= 60.0)
            return "D";
        else if (avg >= 0)
            return "F";
        return "Error";
    } //calcLetterGrade()
} // GradeCalculator

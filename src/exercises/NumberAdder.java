package exercises;

/*
 * File: NumberAdder.java
 *
 * Description: This class adds its two instance variables
 * when the getSum() method is called.
 *
 * Assignment: 1) Add a getDifference method (to subtract num1-num2)
 *             2) Add a getMult method to multiply the numbers
 *             3) Add a getDiv method to divide the numbers num1/num2 
 *                - check if num2 is not equal to 0.0 before division
 *                - if num2 is 0.0 return the value: Double.NaN
 *             4) Test the new methods in the main()
 */

public class NumberAdder
{
    private double num1;
    private double num2;

    /**
     * setNums() sets the two instance variables from the given parameters
     * @param n1 -- one of the given numbers
     * @param n2 -- the second given number
     */
    public void setNums(double n1, double n2)
    {
        num1 = n1;
        num2 = n2;
    } // setNums()

    /**
     * getSum() returns the sum of the two instance variables
     */
    public double getMult()
    {
    return num1*num2;
    }
    
    public double getDifference()
    {
    	return num1 - num2;
    	
    }
    
    public double getSum()
    {
        return num1 + num2 ;
    } // getSum()
    public double getDiv()
    {
    	if( num2==0)
    			{
    		return 0;
    			}
    	else return num1 / num2;
    }
    /**
     * main() creates two instances of this class and tests its
     *  setNums() and getSum() methods
     */
    public static void main(String args[])
    {
        NumberAdder adder1 = new NumberAdder(); // Create two instances
        NumberAdder adder2 = new NumberAdder();
        adder1.setNums(10,15);                  // Set the instances' values
        adder2.setNums(100,200);
        System.out.println("Sum of adder1 " + adder1.getSum());  // Print the values
        System.out.println("Sum of adder2 " + adder2.getSum());
        System.out.println("Difference of two numbers "+ adder1.getDifference());
        System.out.println("Multiple of two numbers " +adder1.getMult());
        System.out.println("Division of two number "+ adder1.getDiv());
    }
}// main()
 // NumberAdder


package exercises;

/*
 * File: Temperature.java
 *
 * Assignment: 1) Add two new methods:
 *                  incrementTemp()
 *                  decrementTemp()
 *                that increment and decrement the current temperature value 
 *                by one degree respectively
 *             2) Add a method: changeTemp( double t ) that adds t to the 
 *                current temperature
 *             3) Add a main() method to this class
 *             4) In the main method: create two instances of the Temperature 
 *                object each with a different
 *                temperature
 *             5) Call the getTemp() method in each of the temperature objects 
 *                and print the result to the users screen
 *             6) Call the incrementTemp(), decrementTemp() and changeTemp(t) 
 *                methods several times from the main() (use getTemp() to see 
 *                if the temperature did change)
 *             Remember that there should not be any print statements in the 
 *             Temperature class
 *
 * Description: This class stores the current temperature.
 * It contains access methods to set and get the temperature.
 *
 */

public class Temperature
{
    private double currentTemp;

    /**
     * setTemp() sets the temperature to the given value
     * @param t -- the given value
     */
    public void changeTemp(double t)
    {
    currentTemp= currentTemp + t;
    }
    public void incrementTemp()
    {
    currentTemp++;
    }
    public void decrementTemp()
    {
    currentTemp--;
    }
    public void setTemp(double t)
    {
        currentTemp = t;
    }

    /**
     * getTemp() returns the current temperature
     */
    public double getTemp()
    {
        return currentTemp;
    }

    /**
     * incrementTemp() returns the (new) current temperature
     */


     /**
	    * decrementTemp() returns the (new) current temperature
      */


     /**
      * changeTemp( double t ) adds t to current temperature and 
      * then returns the (new) temperature
      */
public static void main(String[] arguments)
{
Temperature first= new Temperature(); 	
Temperature second= new Temperature();
first.setTemp(50);
second.setTemp(25);
System.out.println("The first Temperature is: "+ first.getTemp());
System.out.println("The second temperature is: "+second.getTemp());
first.changeTemp(10);
second.changeTemp(20);
first.incrementTemp();
first.incrementTemp();
second.decrementTemp();
second.decrementTemp();
System.out.println("New first Temperature is: "+first.getTemp());
System.out.println("New second Temperature is: "+ second.getTemp());
}
}
 // Temperature
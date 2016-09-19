package exercises;
import java.util.Scanner;
import java.util.InputMismatchException;
public class PairManager {
/*
 * For this exersize we are going to write a Pair Manager class that manages a pair of integers. 
 * This class will create and manage two integers. To simplify this problem, we will only define a few management methods (functions). 
 * A more useful class would have many more management methods. We want our class to be robust, so we will add error checking as appropriate.
Problem Statement
Create a PairManager class with the following characteristics/properties/methods:

A default constructor that initializes the pair of integers to 0.
There will be several public and private methods defined in this class:
private int getInput(String prompt) - this method returns an integer from the keyboard. 
You must check for exceptions with try/catch blocks and recover gracefully from an exception. 
The prompt string is printed as a user prompt.
public boolean getPair( ) - this method assigns values to the pair of integers by reading two numbers. 
You should call getInput( ) for each number.
public int getFirst() - this method returns the first integer
public int compAverage( ) - returns the average of the pairs.
main ( ) - this method is the entry point to the program; it should create a PairManager object,
 call getPairs( ) and output the average of the pair.
*/
public PairManager()
{

}
	int FirstValue;
int SecondValue;	

public void initialize()
	{
		FirstValue=0;
		SecondValue=0;
	}
private static int getInput()
{
	Scanner user_input= new Scanner(System.in);
	System.out.println("Enter the Integer");
	return user_input.nextInt();
	
}
public boolean getPair(int one, int two)
{
	FirstValue = one;
	SecondValue=two;
	return true;
}
public int getFirst()
{
	return FirstValue;
}
public int compAverage()
{
	return (FirstValue + SecondValue)/2;
}

public static void main(String[] arguments)
{
int IntegerOne = 0;
int IntegerTwo = 0;
int Average;
boolean error= true;
while(error==true)
{
try{IntegerOne = getInput();
error=false;
}
catch(Exception e)
{
	System.out.println("Please enter a number");
}
}
error= true;
while(error==true)
{
try
{
IntegerTwo=getInput();
error=false;
}
catch(Exception e)
{
	System.out.println("please enter a number");
}
}
PairManager pair = new PairManager(); 
pair.initialize();
pair.getPair(IntegerOne, IntegerTwo);
Average= pair.compAverage();
System.out.println("Average of the two numbers is: "+ Average);
}
}


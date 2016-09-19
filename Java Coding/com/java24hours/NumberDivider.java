package com.java24hours;

public class NumberDivider {
public static void main (String[] arguments)
{
if(arguments.length==2)
{
	int result = 0;
	try
	{
	result=Integer.parseInt(arguments[0])/Integer.parseInt(arguments[1]);	
	System.out.println(arguments[0]+" Divided by: "+arguments[1]+" equals: "+ result);
	
	}
	catch(NumberFormatException e)
	{
		System.out.println("Both arguements must be numbers.");
	}
	catch(ArithmeticException e)
	{
		System.out.println("You cannot divide by zero");
	}
}
}
}

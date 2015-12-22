package com.java24hours;
import java.time.*;
import java.time.temporal.*;
public class Clock {
public static void main(String[] arguments)
{
	//get the current time and date
	LocalDateTime now = LocalDateTime.now();
	int hour = now.get(ChronoField.HOUR_OF_DAY);
	int minute = now.get(ChronoField.MINUTE_OF_HOUR);
	int month = now.get(ChronoField.MONTH_OF_YEAR);
	int day= now.get(ChronoField.DAY_OF_MONTH);
	int year= now.get(ChronoField.YEAR);
	
	//display greeting
	if(hour<12){
	System.out.println("Good morning. \n");
	}
	else if(hour<17)
	{
		System.out.println("Good afternoon \n");
	}
	else
	{
		System.out.println("Good evening \n");
	}
	// Begin time messages by showing the minutes
	System.out.print("It's");
	if ( minute != 0)
	{
		System.out.print(" "+ minute +" ");
		System.out.print( (minute != 1)? "minutes" : 
			"minute");
		System.out.print(" past");
	}
	//Display the hour
	System.out.print(" ");
	System.out.print( (hour>12) ? (hour -12): hour);
	System.out.print(" o'clock on ");
	
	//Display the name of the month
	switch (month){
	case 1:
		System.out.print("January");
	case 2:
		System.out.print("Febuary");
	case 3:
		System.out.print("March");
	case 4:
		System.out.print("April");
	case 5:
		System.out.print("May");
	case 6:
		System.out.print("June");
	case 7:
		System.out.print("July");
	case 8:
		System.out.print("August");
	case 9:
		System.out.print("September");
	case 10:
		System.out.print("October");
	case 11:
		System.out.print("November");
	case 12:
		System.out.print("December");
	}
	//display the date and the year
	System.out.println(" " + day + ", "+ year + ".");
}
	
}

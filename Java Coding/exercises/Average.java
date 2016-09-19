package exercises;
/* 
 * File: Average.java
 * 
 * Write a program that inputs 10 integers from the keyboard and 
 * computes their average.
 * if the user enters 9999, the program exits early, and outputs 
 * the average of the numbers entered so far.
 */

// Fill in the blanks to make the program work

import java.util.Scanner;

public class Average {

  public static void main( String args[] ) {
    int ave=0, cnt, num;
    Scanner sc = new Scanner(System.in);

    System.out.println( "Integer Averaging Program" );
    System.out.println( "Enter 10 Integers" );
     cnt=0;
    for (int i = 1; i <11; i++) {
      System.out.print("Enter Integer "+i+": ");
      num=sc.nextInt();
      if (num==9999)
      {   break;}
      else
      {
      cnt++;
      ave=ave+num;
      }
    }
    if (ave != 0)
    	ave= ave/cnt;
    else
    	
    	System.out.println("Cannot find the average no numbers inputted");

    System.out.println("The average of " + cnt + " numbers is " + ave );
  }
}
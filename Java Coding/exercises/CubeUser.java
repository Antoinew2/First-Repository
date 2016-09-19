package exercises;

/*
 * File: CubeUser.java
 *
 * Description: This class creates an instance of the Cube
 *  class and prints its area and volume.
 *
 * Assignment: 1) Create 3 cube objects. The size of each of the cubes 
 *                should be input from the keyboard
 *                (hint: study the code below)
 *             2) Print the Side length, Surface area and Volume to the 
 *                users screen for each of the cubes
 *             3) The program should catch input error exceptions and 
 *                deal with them in a reasonable manner
 *
 */

import java.util.Scanner;
import java.io.IOException;
public class CubeUser
{
   private double size;
    public CubeUser (int s)
    {
    	size = s;
    
    }
    public double getLength(int length)
    {
    	return size*4;
    }
    public double calculateSurfaceArea(int area)
    {
    	return size*size;
    }
    public double calculateVolume(int volume)
    {
    	return size*size*size;
    }
	public static void main(String args[]) throws IOException
    {
  
  Scanner user_input= new Scanner(System.in);
  System.out.print("Enter First Cube");
  while(!user_input.hasNextInt())
  {
	  user_input.next();
  System.out.print("enter an Integer");
  }
 
  int length = user_input.nextInt();
CubeUser cube1 = new CubeUser(length);
        
        System.out.println("Side length of cube1 is " + cube1.getLength(length));
        System.out.println("Surface Area of cube1 is " + cube1.calculateSurfaceArea (length));
        System.out.println("Volume of cube1 is " + 	cube1.calculateVolume(length));

        
        
        
        
        
        
user_input.close();
    } // main()
} // CubeUse
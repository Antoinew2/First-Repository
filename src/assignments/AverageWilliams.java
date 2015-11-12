package assignments;
import java.util.Scanner;
public class AverageWilliams {
	public static void main( String args[] ) {
	    int ave=0, cnt, num;
	    Scanner sc = new Scanner(System.in);

	    System.out.println( "Integer Averaging Program" );
	    System.out.println( "Enter 20 Integers" );
	     cnt=0;
	    for (int i = 1; i <21; i++) {
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
	sc.close();
	}

}

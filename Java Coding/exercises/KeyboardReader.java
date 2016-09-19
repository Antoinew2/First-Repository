package exercises;


/*
 * File: KeyBoardReader.java
 *
 */
 import java.io.*;
// See Box.java for instructions

public class KeyboardReader implements UserInterface
{    private BufferedReader reader;
public static int test;
     public KeyboardReader() {
		 reader = new BufferedReader(new InputStreamReader(System.in));
     }

     public String getKeyboardInput() {
        return readKeyboard();
     }

     public int getKeyboardInteger() {
        test = Integer.parseInt(readKeyboard());
    	 return test;
     }
     public static int getKeyboardIntegerRange(int min, int max) 
     {
    if (min>test)
    {
    	return 1;
    }
    else if(max < test)
    {
    	return 1;
    }
    else 
    	return 0;
     }
// HINT: add new method that limits input in range from Min to Max
//	 public int getKeyboardInteger(int min, int max) {}
//	    fill in rest, method should not return until the user entered number is within range
//		Prompt user with message if number is not within range before looping for another try.
//      Catch exceptions

    public double getKeyboardDouble() {
        return Double.parseDouble(readKeyboard());
    }

    public String getUserInput() {
    	return getKeyboardInput();
    }

    public void prompt(String s) {
       System.out.print(s);
    }

    public void report(String s) {
       System.out.print(s);
    }

    public void display(String s) {
       System.out.print(s);
    }

    private String readKeyboard() {
       String line = "";
       try {
            line = reader.readLine();
       }
       catch (IOException e) {
            e.printStackTrace();
       }
       return line;
     }
   
}

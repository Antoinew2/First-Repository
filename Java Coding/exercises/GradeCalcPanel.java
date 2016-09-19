package exercises;

/*
 * File: GradeCalcPanel.java
 * Author: Java Java Java  -
 * This class provides a user interface to
 * the GradeCalc class, which calculates a student's average
 * and letter grade for grades input into a JTextField.
 * The interface consists of input and output JTextFields and
 * and button to calculate the course average and letter grades.
 */

  // See GradeCalculator.java for instructions
import java.util.InputMismatchException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.*;

public class GradeCalcPanel extends JPanel implements ActionListener
{
    private JLabel prompt;           // GUI components
    private JTextField inputField;
    private JLabel resultLabel;
    private JTextField resultField;
    private JButton button;
    private GradeCalculator calculator;  // The Calculator object

    public GradeCalcPanel()
    {
       calculator = new GradeCalculator(); // Create a calculator instance
 // setLayout( new GridLayout(1,5,10,10));
    prompt = new JLabel("Grade:");
    resultLabel = new JLabel("Average:");
    inputField = new JTextField(10);
    resultField = new JTextField(20);
    resultField.setEditable(false);
    button = new JButton("Enter");
    button.addActionListener(this);

    add(prompt);
    add(inputField);
    add(button);
    add(resultLabel);
    add(resultField);
    inputField.setText("");

    } // GradeCalcPanel()


    /**
     * actionPerformed() handles clicks on the button.
     *  It takes the data from the input JTextFields, and sends them to
     *  the GradeCalculater class to calculate a running average and
     *   computes the letter grade, which are displayed in TextFields.
     * @param e -- the ActionEvent the generated this system call
     */
    public void actionPerformed(ActionEvent e)
    {

      double count,grade = 0, ave;
        DecimalFormat df = new DecimalFormat("0.00");

        String inputString = inputField.getText();

        // HINT: use try/catch blocks to catch bad input to parseDouble()
        //Type mismatch
        //check for range too
     boolean error = true;
        
        try{
        grade = Double.parseDouble(inputString);
       error=false;
        }
       catch(Exception e1)
       {
    	  System.out.println("input a number"); 
       }
        
       
  // HINT: reject a bad grade in some way (the modified addGrade will return false
  // there is a problem with the grade

       
       
  // HINT: output grade count along with average and letter grade
        if(error==false)
        {
        inputField.setText("");
        calculator.addGrade(grade);
        ave = calculator.calcAvg();
        count=calculator.getCount();
        String average = "" + df.format(ave);
        String letterGrade = calculator.calcLetterGrade();
        resultField.setText(average + " " + letterGrade+" "+ count);
        }
    } // actionPeformed()

} // GradeCalcPanel class
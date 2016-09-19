package exercises;

/*
 * File: LeftRightPanel.java
 *
 * Description: This class defines a GUI in a JPanel which contains
 * two JButtons with initial labels "Left" and "Right" and a
 * JTextField. Pressing a button causes the label of that button
 * to be printed into the textfield.
 *
 * Assignment: 1) Create a centerButton (label it "Center")
 *             2) Create another JPanel
 *             3) Add the Left,Center,Right Buttons to the JPanel 
 *                in step 2
 *             4) Change the Layout Manager of LeftRightPanel to 
 *                BorderLayout
 *             5) Place the JPanel of step 2 in the center position 
 *                of LeftRightPanel
 *             6) Place the JTextField( outField ) in the south 
 *                position of LeftRightPanel
 *             7) Change the ActionEvent code so the pressing the 
 *                centerButton displays "center' in the outField
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.applet.Applet;
public class LeftRightPanel extends JPanel implements ActionListener
{
  
	private JButton leftButton;
    private JButton rightButton;
    private JButton centerButton;
    // HINT: declare new JButton

    private JTextField outField;

    public LeftRightPanel()
    {

    	setLayout(new BorderLayout());
  
       	
// HINT: setLayout Manager
    	
// HINT: create a new JPanel


        leftButton = new JButton("Left");
        leftButton.addActionListener(this);
        rightButton = new JButton("Right");
        rightButton.addActionListener(this);
        centerButton=new JButton("Center");
        centerButton.addActionListener(this);
// HINT: create Middle button, add event handler


        outField = new JTextField(10);

// HINT: add three buttons to the JPanel
        add(leftButton, BorderLayout.WEST);
        add(centerButton,BorderLayout.CENTER);
        add(rightButton,BorderLayout.EAST);
        add(outField,BorderLayout.SOUTH);

// HINT: put everything together
//       JPanel goes in the CENTER position of LeftRightPanel
//       outField goes in the SOUTH position


// HINT: these are not needed in the new layout
        
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton) e.getSource();
		outField.setText( b.getText() );

    } // actionPeformed()
} // LeftRightPanel class


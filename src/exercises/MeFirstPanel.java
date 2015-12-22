package exercises;

/*
 * File: MeFirstPanel.java
 *
 * Description: This class defines a GUI in a JPanel which contains
 * two JButton with initial labels "Me first!" and "Me next!".
 * Pressing either button causes the labels to be exchanged.
 *
 * Assignment: 1) Add a third button to the panel, with the label "third"
 *             2) Every time any of the buttons are pressed, the labels 
 *                should shift one place to the right first->second->third 
 *                would shift to third->first->second when one of the buttons
 *                was pressed
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MeFirstPanel extends JPanel implements ActionListener
{
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    // add button here

    String aText = "first";
    String bText = "second";
    String cText= "third";
    // add string here

    String tempText; // To use to exchange labels

    public MeFirstPanel()
    {
        aButton = new JButton(aText);
		aButton.addActionListener(this); // add event handler
		bButton = new JButton(bText);
		bButton.addActionListener(this); // add event handler
		cButton= new JButton(cText);
		cButton.addActionListener(this);
		add(aButton); // add button to JPanel
		add(bButton); // add button to JPanel
		add(cButton);
    } // MeFirstPanel()


    public void actionPerformed(ActionEvent e)
    {
            tempText = cText;  // Exchange the strings
            cText = bText;
            bText = aText;
            aText=tempText;
            // add code here
            aButton.setText(aText); // Set button labels
            bButton.setText(bText);
            cButton.setText(cText);
            // add code here

    } // actionPeformed()
} // MeFirstPanel class
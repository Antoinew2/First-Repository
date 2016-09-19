package assignments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.applet.Applet;
public class GUIProgramPanel extends JPanel implements ActionListener
{
    final static boolean shouldFill=true;
    private JButton FirstButton;
    private JButton SecondButton;
    private JButton ThirdButton;
    private JButton FourthButton;


    private JTextField outField;
    public GUIProgramPanel()
    {

    	setLayout(new GridBagLayout());
    	GridBagConstraints c= new GridBagConstraints();
       	


        FirstButton = new JButton("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady=40;
        c.weightx=.5;
        c.weighty=.5;
        c.gridx=0;
        c.gridy=0;
        FirstButton.addActionListener(this);
        add(FirstButton,c);
        SecondButton = new JButton("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady=40;
        c.weightx=.5;
        c.weighty=.5;
        c.gridx=2;
        c.gridy=0;
        SecondButton.addActionListener(this);
        add(SecondButton,c);
        ThirdButton=new JButton("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady=40;
        c.gridx=0;
        c.weightx=.5;
        c.weighty=.5;
        c.gridy=1;
        ThirdButton.addActionListener(this);
        add(ThirdButton,c);
        FourthButton = new JButton("3");
        c.fill= GridBagConstraints.HORIZONTAL;
        c.ipady=40;
        c.gridx=2;
        c.weightx=.5;
        c.weighty=.5;
        c.gridy=1;
        FourthButton.addActionListener(this);
        add(FourthButton,c);


        outField = new JTextField();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.ipady=20;
        c.gridwidth=3;
        c.gridx=0;
        c.gridy=4;	
        c.weightx=.5;
        c.weighty=.5;
        
       
        
       
        add(outField,c);
        
        
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton) e.getSource();
		outField.setText( b.getText() );

    } 
} 


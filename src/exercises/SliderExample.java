package exercises;

/*
* File: SliderExample.java 
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderExample extends JFrame implements ChangeListener
{

    private JSlider vsb0 = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
    private JSlider vsb1 = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
    private JTextField tf = new JTextField(25);

    public SliderExample()
    {   
      setSize(300,200);

      Container contentPane = getContentPane();

      contentPane.setLayout(new GridLayout(3,1));
      contentPane.add( vsb0 );
      contentPane.add( vsb1 );
      contentPane.add( tf );

      vsb0.addChangeListener(this);
      vsb1.addChangeListener(this);

      //register 'Exit upon closing' as a default close operation

      setDefaultCloseOperation( EXIT_ON_CLOSE );

    }

//    public void paintComponent(Graphics g) //    { //        super.paintComponent(g); // //    }

    public void stateChanged( ChangeEvent e)
    {
      int v;

      JSlider sb = (JSlider)e.getSource();
      if (sb==vsb0) 
      {
        v = sb.getValue();
        tf.setText( "Slider0 Val= "+ Integer.toString(v) );
      }
      if (sb==vsb1)
      {
        v = sb.getValue();
        tf.setText( "Slider1 Val= "+ Integer.toString(v) );
      }        
      //repaint();  
    }

    public static void main(String args[])
    { 
      SliderExample s = new SliderExample(); 
      s.setVisible(true);     } 
    // main()

}
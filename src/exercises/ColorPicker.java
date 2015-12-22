package exercises;

/*
 *  File: ColorPicker.java
 *
 *  Description: This app illustrates the use of the
 *  java.awt.Color class. It lets the user type red, green and
 *  blue (RGB) values into text fields, and displays the resulting
 *  color both as a font color and as a colored rectangle.

 *  This version of ColorPicker uses programmer defined IntFields
 *  which throw an out-of-range exception if the values input are
 *  not between 0 and 255. The only changes required occur in the
 *  declarations for the IntFields, in the init() method where the
 *  IntFields are instantiated, and in the actionPerformed() method
 *  the the getInt() method is used to retrieve their data.
 *
 *
 * Assignment:  1) Run this program to see how it works
 *              2) Modify this program so that it uses JSliders to 
 *                 select the range of colors. Arrange the JSliders
 *                 so they are oriented horizontally and stacked using
 *                 a grid layout:
 *
 *                |-------- slider1 ----------|
 *                |-------- slider2 ----------|
 *                |-------- slider3 ----------|
 *
 *              - See the example below (SliderExample) to get started
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

// HINT: use ChangeListener rather than ActionListener

public class ColorPicker extends JFrame implements ChangeListener {
    //private IntField redIn, greenIn, blueIn;
    private JLabel R = new JLabel("R:"),
                   G = new JLabel("G:"),
                   B = new JLabel("B:");
    private JPanel controls = new JPanel();
    private Canvas canvas = new Canvas();
    private JSlider redIn= new JSlider(SwingConstants.HORIZONTAL,0,255,0);
    private JSlider greenIn = new JSlider(SwingConstants.HORIZONTAL,0,255,0);
    private JSlider blueIn = new JSlider(SwingConstants.HORIZONTAL,0,255,0);
    /**
     *  init() sets up the app's interface. A (default) border layout
     *   is used, with the controls at the north and the drawing canvas
     *   in the center.
     */
    public ColorPicker() {
        initControls();
        getContentPane().add(controls, "North");
        getContentPane().add(canvas, "Center");
        canvas.setBorder(BorderFactory.createTitledBorder("The Color Display"));
        getContentPane().setBackground(Color.white);
        setSize(300,300);
               //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

    /**
     *  initControls() arranges the app's control components in a separate
     *   JPanel, which is placed at the north border. The controls consist of
     *   three JTextFields into which the user can type RGB values.
     */
    private void initControls() {

		// HINT create 3 sliders instead of IntFields

      //  redIn = new IntField(4, 0, 255);     // Create 3 integer textfields
       // greenIn = new IntField(4, 0, 255);   //  that accept values between
       // blueIn = new IntField(4, 0, 255);    //  0 and 255
        //redIn.setText("128");                // And set their initial text values
        //greenIn.setText("128");
        //blueIn.setText("128");

        //HINT: addChangeListener(this) instead of addActionListener()

        redIn.addChangeListener(this);       // Give them listeners
        greenIn.addChangeListener(this);
        blueIn.addChangeListener(this);

        // HINT use a GridLayout(6,1) with sliders

        controls.setLayout( new GridLayout(6,1));
        controls.setBorder(BorderFactory.createTitledBorder("Use Sliders to change Vaules for RGB"));
        controls.add(R);
        controls.add(redIn);     // Add prompts and textfields
        controls.add(G);
        controls.add(greenIn);
        controls.add(B);
        controls.add(blueIn);
    } // initControls()


	// HINT: if you are not using IntField, then you do not need actionPerformed()

    /**
     *  actionPerformed() handles the app's actions. No matter which action
     *   led to the method call, integer values are read from the RGB text fields
     *   and passed along as a new color to the canvas object. The app is then
     *   repainted. If the user types an invalid value into the IntField, a message
     *   dialog is used to print an error message.
     */
    public void stateChanged(ChangeEvent e) {
        
            int r = redIn.getValue();    // Get user's inputs
            int g = greenIn.getValue();
            int b = blueIn.getValue();
            canvas.setColor(new Color(r, g, b)); // If no error, reset the canvas's color
            repaint();                           //  and repaint the app
       
        }
     // actionPerformed()

	// HINT: add the following

	//public void stateChanged( ChangeEvent e) {
	//		int r, g, b;
	//		r=redIn.getValue();
	//		 fill in rest of code
	//}

    public static void main(String args[]) {
        ColorPicker c = new ColorPicker();
        c.setVisible(true);
    } // main()
}//ColorPicker.java
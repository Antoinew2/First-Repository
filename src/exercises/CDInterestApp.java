package exercises;

/*
 * File: CDInterestApp.java
 *
 * Description: This program creates a CDInterestPanel and
 *  adds it to the Frame's content pane and sets its size.
 *
 * Assignment: See CDInterestPanel.java file
 *
 */


import javax.swing.*;

public class CDInterestApp extends JFrame
{
    public CDInterestApp()
    {
        getContentPane().add(new CDInterestPanel());
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    } // CDInterestFrame() constructor

    public static void main(String args[]){
        CDInterestApp aframe = new CDInterestApp();
        aframe.setSize(700,400);
        aframe.setVisible(true);
    } // main()

} // CDInterestFrame class


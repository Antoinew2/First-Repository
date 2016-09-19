package assignments;

import javax.swing.*;

import assignments.GUIProgramPanel;
public class GUIProgramApp extends JFrame
{
    public GUIProgramApp()
    {
        getContentPane().add(new GUIProgramPanel());
        
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    } 

    public static void main(String args[]){
        GUIProgramApp aframe = new GUIProgramApp();
        aframe.setSize(600,400);
        aframe.setVisible(true);
    } 

} 
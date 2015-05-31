//----------------------------------------------------
// Programmer: Harry Staley	
// Course: COSC 2337
// Semester: Spring 2014
// Assignment #: 2
// Due Date: 2/11/2014
//----------------------------------------------------

import java.awt.*;
import javax.swing.JFrame;

public class StackTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x, y; //used to center the frame

			// instantiate a frame
		JFrame frame = new JFrame("Reverse a string");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			// instantiate our 'primary' panel for our frame
		StackGUI primary = new StackGUI();
		
			// add this panel to the frame
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
		
			//center the frame on the screen		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension size = frame.getSize();
		screenSize.height = screenSize.height / 2;
		screenSize.width = screenSize.width / 2;
		size.height = size.height / 2;
		size.width = size.width / 2;
				
		x = screenSize.width - size.width;
		y = screenSize.height - size.height;
		frame.setLocation(x, y);

	}   // end method main

}   // end class StackTester


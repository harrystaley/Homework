//----------------------------------------------------
// Programmer:		Harry Staley
// Course:			COSC 1337 Section 0005
// Semester:		Fall 2014
// Assignment #:	Semester Project
// Due Date:		October 22, 2014
//----------------------------------------------------

import java.awt.*;
import javax.swing.JFrame;

public class PizzaOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		   // instantiate a frame
			JFrame frame = new JFrame("Harry's Pizza Palace");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		   // instantiate our 'primary' panel for our frame
			PizzaControls primary = new PizzaControls();
			
		   // add this panel to the frame
			frame.getContentPane().add(primary);
			frame.pack();
			frame.setVisible(true);
			// Center the frame on the screen.
			Dimension screensize =
					Toolkit.getDefaultToolkit().getScreenSize();
			Dimension size = frame.getSize();
			screensize.height = screensize.height / 2;
			screensize.width = screensize.width / 2;
			size.height = size.height / 2;
			size.width = size.width / 2;
			 int y = screensize.height - size.height;
			 int x = screensize.width - size.width;
			frame.setLocation(x, y);
			
	}   // end method main

}   // end class PizzaOrder

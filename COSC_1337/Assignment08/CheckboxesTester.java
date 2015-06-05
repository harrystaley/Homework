//----------------------------------------------------
// Programmer: 		Harry Staley
// Course: 			COSC 1337 Section 0005
// Semester: 		Fall 2014
// Assignment #: 	8
// Due Date: 		10-8-2014
//----------------------------------------------------

import javax.swing.JFrame;

public class CheckboxesTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			// instantiate a frame
			// from the class JFrame
		JFrame frame = new JFrame("Fun with check boxes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
			// the primary panel is added
			// to the frame and made visible
		frame.getContentPane().add(new CheckboxesGUI());
		frame.pack();
		frame.setVisible(true);
		
	}	// end method main

}	// end class CheckboxesTester

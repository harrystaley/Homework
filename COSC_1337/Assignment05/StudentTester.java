//----------------------------------------------------
// Programmer:		Harry Staley
// Course:			COSC 1337 Section 0005
// Semester:		Fall 2014
// Assignment #:	5
// Due Date:		September 24, 2014
//----------------------------------------------------

import javax.swing.*;   // for GUIs using swing

public class StudentTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			// declare local variables to be used in program
		String street, town, state, zipCodeText;
		String firstName, lastName, testScore1Text;
		String testScore2Text, testScore3Text;
		int zipCode, testScore1, testScore2, testScore3;
		
		Address school = new Address ("800 Lancaster Ave",
									"Villanova", "PA", 19085);
		
		
			// enter student information via
			// option panes
		street = JOptionPane.showInputDialog(null, "Please enter street.");
		town = JOptionPane.showInputDialog(null, "Please enter town.");
		state = JOptionPane.showInputDialog(null, "Please enter state.");
		zipCodeText = JOptionPane.showInputDialog(null, "Please enter Zip Code.");
		zipCode = Integer.parseInt(zipCodeText);
		
			// prompt and read in first
			// name and last name of student
		firstName = JOptionPane.showInputDialog(null, "Please enter first name.");
		lastName = JOptionPane.showInputDialog(null, "Please enter last name.");
		
			// prompt and read in three test scores of
			// student and convert each to an integer
		testScore1Text = JOptionPane.showInputDialog(null, "Please enter the first test score for " +
			firstName + " " + lastName + ".");
		testScore1 = Integer.parseInt(testScore1Text);
		testScore2Text = JOptionPane.showInputDialog(null, "Please enter the second test score for " +
				firstName + " " + lastName + ".");
		testScore2 = Integer.parseInt(testScore2Text);
		testScore3Text = JOptionPane.showInputDialog(null, "Please enter the third test score for " +
				firstName + " " + lastName + "."); 
		testScore3 = Integer.parseInt(testScore3Text);
		
			// instantiate an object about
			// student's home address
		Address sHome = new Address(street, town,state, zipCode);  
		
			// instantiate an object about student (home and
			// school address and test scores)
		Student myStudent = new Student(firstName, lastName, sHome, school, testScore1, testScore2, testScore3);
		
			// print out info about student using option pane
		JOptionPane.showMessageDialog(null, myStudent);
		
			// replace test score two with another value
		testScore2Text = JOptionPane.showInputDialog(null, "Please update the second test score for " +
				firstName + " " + lastName + ".");
		testScore2 = Integer.parseInt(testScore2Text);
		
			// now update test score number two
		myStudent.setTestScore(2, testScore2);
		
			// show in option pane that a new score for test
			// two has taken place
		JOptionPane.showMessageDialog(null, firstName + " " + lastName +
				"'s second test score is now " + myStudent.getTestScore(2)+ ".");
		
			// print out info about student using option pane
		JOptionPane.showMessageDialog(null, myStudent);
		
		JOptionPane.showMessageDialog(null,
				"This program was written by Harry Staley" +
				"\nEnd of program.");
		
	}   // end method main

}   // end class StudentTester

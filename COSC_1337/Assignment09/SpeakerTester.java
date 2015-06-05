//----------------------------------------------------
// Programmer: 		Harry Staley
// Course: 			COSC 1337 Section 0005
// Semester: 		Fall 2014
// Assignment #: 	9
// Due Date: 		10-8-2014 
//----------------------------------------------------


import javax.swing.*;
public class SpeakerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   // declare object variables
		   // to be used in program
		Speaker rover, aristotle, someone;
		
		   // instantiate 'rover' to be a 'Dog' object
		rover = new Dog("Rover");
		rover.speak();
		rover.announce("Ruff ruff to all my fellow dogs!");
		
		   // instantiate 'aristotle' to be a 'Philosopher' object
		aristotle = new Philosopher("Aristotle", 
				"A true friend is a soul in two bodies.");
		aristotle.speak();
		aristotle.announce("All men by nature desire to know.");
		
		
			// have aristotle pontificate!
		((Philosopher)aristotle).pontificate();
		
			// instantiate 'someone' to be a 'Dog' object
		someone = new Dog("someone");
		someone.speak();
		someone.announce("Somebody thinks he's a dog.");
		
		
			// instantiate 'someone' to be a 'Philosopher' object
		someone = new Philosopher("someone", "I think like a Philosopher.");
		someone.speak();
		someone.announce("Somebody thinks he's smart.");
		
			// have 'someone' pontificate!
		((Philosopher)someone).pontificate();
		
		JOptionPane.showMessageDialog(null, "This program was ritten by Harry Staley. \n End of Program.");
	}   // end method main

}   // end class SpeakerTester

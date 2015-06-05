//----------------------------------------------------
// Programmer:	Harry Staley
// Course:		COSC 1337 Section 0005
// Semester:	Fall 2014
// Assignment #: 3
// Due Date:	17 September, 2014
//----------------------------------------------------

import java.util.Scanner;
import java.io.*;

import javax.swing.*;

import java.util.Random;

public class FlightTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
			// declare variables to 
			// be used in program
		final int NUM = 3;
		String airline, origin, destination;
		String flightNumberText;
		String output, fileText;
		int flightNumber, i, j, number;
		
			// instantiate object from Random class
		Random gen = new Random();
		

		   	// declare an array of 'Flight' objects
		Flight allFlights[] = new Flight[5];
		
			// prompts the user to enter the
			// data and read it in
		fileText = JOptionPane.showInputDialog(null, "Please enter data file name.:");
		
		File inputFile = new File(fileText);
		Scanner fromFile = new Scanner(inputFile);
		i = 0;
		output = "";
		
		   	// read in from the data file the airline, 
			// origin, destination, and the flight
		   	// number for each flight
		while (fromFile.hasNext()) // need to change condition
		{
			airline = fromFile.next();
			origin = fromFile.next();
			destination = fromFile.next();
			flightNumberText = fromFile.next();
			flightNumber = Integer.parseInt(flightNumberText);
			
			
			   	// instantiate an object from the
				//Flight class and pass to
			   	// the constructor the arguments read
				// from the data file
			allFlights[i] = new Flight(airline, origin, destination, flightNumber);
			
			i++;
		}   // end while loop
		
		   // close the data file
		fromFile.close();
		
			// build a string for display
		output = "(AIRLINE, ORIGIN, DESTINATION, FLIGHT NUMBER)\n\n";
		
			// concatenate the info from the array
			// to the 'output' string
		for (j = 0; j < i; j++)
		{
			output += allFlights[j] + "\n";
		}
		
		   // print this 'output' string to the option pane
		JOptionPane.showMessageDialog(null, output);
		
		   	// prompt and read in new information to
			// modify one of the Flight
		   	// objects via the four mutator methods
		airline = JOptionPane.showInputDialog(null,
				"Please enter new airline: ");
		origin = JOptionPane.showInputDialog(null,
				"Please enter new origin: ");
		destination = JOptionPane.showInputDialog(null,
				"Please enter new destination: ");
		flightNumberText = JOptionPane.showInputDialog(null,
				"Please enter new flight number: ");
		flightNumber = Integer.parseInt(flightNumberText);
		
		
			// randomly generate a number to
			// signify which flight to modify
		number = gen.nextInt(NUM);
		
			// display which flight will be changed
		JOptionPane.showMessageDialog(null,
				"Number " +	number + 
				" flight will be changed!");
		
		   	// invoke the mutator methods
		allFlights[number].setAirline(airline);
		allFlights[number].setOrigin(origin);
		allFlights[number].setDestination(destination);
		allFlights[number].setFlightNumber(flightNumber);
		
			// prepare string to display new
			// information about the flight that
			// you changed via the four accessor
			// methods to an option pane
		output = "(AIRLINE, ORIGIN, DESTINATION, FLIGHT NUMBER)\n\n";
		output += "(";
		output += allFlights[number].getAirline() + ",";
		output += allFlights[number].getOrigin() + ",";
		output += allFlights[number].getDestination() + ",";
		output += allFlights[number].getFlightNumber() + ",";
		output += ")";
		   
			// now display this new flight!
		JOptionPane.showMessageDialog(null, 
			"New flight infor for number " +
		   	number + "\n\n" +
				output);
		
			// prepare string to display all flight records
		output = "(AIRLINE, ORIGIN, DESTINATION, FLIGHT NUMBER)\n\n";
		
		for (j = 0; j < i; j++)
		{
			output += allFlights[j] + "\n";
		}
		
		   // now display all the flights!
		JOptionPane.showMessageDialog(null, output);
		
		JOptionPane.showMessageDialog(null,
		"\nThis program was written by Harry Staley.\n" +
		"End of program.");

	}   // end method main

}   // end class FlightTester


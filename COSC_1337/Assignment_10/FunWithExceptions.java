//----------------------------------------------------
// Programmer: 		Harry Staley
// Course: 			COSC 1337 Section 0005
// Semester: 		Fall 2014
// Assignment #: 	10
// Due Date: 		10-8-2014
//----------------------------------------------------

import javax.swing.*;
import java.util.Random;

public class FunWithExceptions
{
   public static void main (String[] args) throws
        StringTooLongException, NoEvenNumberException
   {
	   	// declare variables to be used in program
        final int MAX = 20;
        int num;
        String input = "", name = "Harry Staley";

      	
        // instantiate an object from the
      	// Random class so we can 
      	// generate random numbers
       Random rand = new Random();

      	
       // set up exceptions to 
      	// be caught if raised
        StringTooLongException lengthException = 
        	 new StringTooLongException ("String has too many characters");
       
        NoEvenNumberException noEvenException = 
        	 new NoEvenNumberException("No even numbers are allowed!");
      	
        
        // process string
      	// and number
        do
        {
                // prompt the user to enter a 
        	    // string and then read it in 
            input = JOptionPane.showInputDialog(null,
            		"Please enter a string.  Enter DONE " +
                    "when finished.");
            
                  // this string will be
                  // attempted to be processed
             if (!input.equalsIgnoreCase("DONE"))
                try
                 {
                			// string too long
                			// throw exception!
                	if(input.length() > MAX)
                	{ 
                		throw lengthException;
                	}
                    else // string is okay to process
                    {
                        JOptionPane.showMessageDialog(null,
                        	   "You entered: \"" +
                                input +
                                "\", its length was " +
                                input.length(),
                                "String info",
                                JOptionPane.INFORMATION_MESSAGE);
                    }  // end else statement
                
                	    // generate a random number
                	    // between 0 and 99
                num = rand.nextInt(100); 
                System.out.println("num is: " + num);
                
                	// number is an even number
                	// throw exception!
                if (num % 2 == 0)
                {
                	throw noEvenException;
                }
                
                }   // end try clause 
             
                 // catch long string exception
             	// that was raised!
             catch (StringTooLongException e)
             {
                JOptionPane.showMessageDialog(null,
                		e.getMessage() +
                		"\nPlease try again!",
                		"Invalid string input",
                		JOptionPane.ERROR_MESSAGE);
             }  
             
             catch (NoEvenNumberException e)
             {
                 JOptionPane.showMessageDialog(null,
                 		e.getMessage() +
                 		"\nOops!",
                 		"Invalid even number",
                 		JOptionPane.ERROR_MESSAGE); 
             }
             
             // keep processing strings and numbers
             //until is finished
       } while (!input.equalsIgnoreCase("DONE"));	
        
        JOptionPane.showMessageDialog(null,
        		"This program was written by " +
                 name +
                 "\nEnd of program.",
                 "Good bye!",
                 JOptionPane.INFORMATION_MESSAGE);
        
        // end method main
}}// end class FunWithExceptions

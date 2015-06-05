//---------------------------------------------------
// Programmer: <Harry Staley>
// Course: COSC 1337 Section 005
// Semester: Fall 2014
// Assignment #: 1
// Due Date: September 10, 2014
//---------------------------------------------------

import javax.swing.*;

import java.text.NumberFormat;
import java.util.Random;

public class PlayWithNumbers {

	/**
	 * @param args
	 */
		// declare constants to be used in program
	final static double PAY_RATE = 25.25;
	final static double CHARITY = 0.03;
	final static int YES = 0;
	final static int NO = 1;
	
		// declare format for numbers to be printed
    static NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
    static NumberFormat fmt2 = NumberFormat.getPercentInstance();
    
    	// instantiate object from Random class
    static Random gen = new Random();
	
    	// declare enumeration of types of ice cream
	enum IceCream { chocolate, vanilla, strawberry, cream_in_cookies, neopolitan, bannanna_nut}
    
	static IceCream typeIceCream;
	
	public static void main(String[] args) {
			// declare variables to be used in program
	      int oddCount = 0, evenCount = 0, zeroCount = 0;
	      int value, digit, i, n, num, answer;
	      double earnings, hours;
	      String valueText;
	      String name = "Harry Staley"; // replace with your name
	      Boolean inValid = true;
	      
	      	// prompt and read in an integer number
		 valueText = JOptionPane.showInputDialog(null, 
				 "Please enter your Banner number");
				 
		 	// convert to integer
		 value = Integer.parseInt(valueText); 
		 
		 	// iterate through loop until user has entered
		 	// an integer value that is not zero
		 do
		 {
			 if (value ==0)
			 {
				 inValid = true;
				 JOptionPane.showMessageDialog(null, 
						 "Cannot enter zero", 
						 "Invalid Input", 
						 JOptionPane.ERROR_MESSAGE);
				 
				 valueText = JOptionPane.showInputDialog(null, 
						 "Please enter your Banner number");
				 value = Integer.parseInt(valueText); 
			 } //end if
			 else
			 {
				 inValid = false; 
			 } // entered a non zero value
		 } while (inValid); //End Do While Loop
		 
		 	// get magnitude of the number
		 value = Math.abs(value);
		 System.out.println("Your number is: " + value);

	      	// go through all digits of this numbers
	      	// and determine what kind of digit it is
	      while (value > 0)
	      {
	    	  digit = getLastDigit(value);
	    	  
	    	  if (digit == 0)
	    	  {
	    		  zeroCount++;
	    	  }
	    	  else if (digit % 2 == 0)
	    	  {
	    		evenCount++;  
	    	  }
	    	  else
	    	  {
	    		  oddCount++;
	    	  }
	    	  value = truncateDigit(value);
	      }// end while loop
	      
	      	// print out results
	      System.out.println("Zero digits: " + zeroCount);
	      System.out.println("Even digits: " + evenCount);
	      System.out.println("Odd digits: " + oddCount);
	      
	      	// get length of number as it
	      	// came in as a string
	      n = valueText.length();
	      
		  	// convert to integer
	      value = Integer.parseInt(valueText);
	      System.out.println("\nHere is your Banner number backwards: ");
	      	
	      // one by one, print out each digit of number
	      // starting with least significant digit
	      for (i = 0; i < n; i++)
	      {
	    	  num = getLastDigit(value);
	    	  value = truncateDigit(value);
	    	  System.out.print(num);
	      }// end for loop
	      
	      System.out.println();
	      
	      	// obtain the amount of hours user has entered
	      	// and then print it out
	      hours = getHours();
		 System.out.println("\nYou worked " + hours + " hours this week.");
	      	// calculate full earnings for user
		 earnings = hours * PAY_RATE;
		 
		 	// print out earnings in in a nice format
		 System.out.println("Your earnings are: " + 
		 	fmt1.format(earnings));
		 
		 	// obtain answer to whether user will
		 	// contribute to charity
		 answer = contributeToCharity();
		 
		 	// calculate new earnings with deduction of charity 
		 determinePay(answer, earnings);
		 
		 JOptionPane.showMessageDialog(null,
				   "\nThis program was written by " + name +
				   "\nEnd of program.",
				   "\nGood bye!",
				   JOptionPane.INFORMATION_MESSAGE);
	}	// end method main
	
	static int getLastDigit(int value)
	{
		int result;
		
			// extract least significant digit
		result = value % 10;
				
		return result;
	}	// end method nextDigit
	
	static int truncateDigit(int value)
	{
		int result;
		
			// truncate number
		result = value /10;
		return result;
	}	// end method truncateDigit
	
	static double getHours()
	{
		String hoursText;
		double hours;
		
		  	// prompt and read in the amount
			// of hours the user has worked
		 hoursText = JOptionPane.showInputDialog(null,
		             "Please enter the amount of hours you worked this week\n" +
				 	 "Assume you will earn $25.25 per hour and there is " +
		             "no overtime.");
		 
		 	// convert to double
		 hours = Double.parseDouble(hoursText);
		 
		 return  hours;
	}	// end method getHours;
	
	static int contributeToCharity()
	{
		int answer;
		
			// obtain the answer on whether the
			// user will contribute to a charity
		answer = JOptionPane.showConfirmDialog(null,
				 "Would you like to donate 3% of your earnings to a charity?",
				 "Charity Question",
				 JOptionPane.YES_NO_OPTION);
		
		return answer;
	}	// end method contributeToCharity
	
	static void determinePay(int answer, double earnings)
	{
		int type;
		
			// user will contribute to a charity
		 if (answer == YES)
		 {
			earnings = earnings - earnings * CHARITY; 
			 System.out.println("With " + fmt2.format(CHARITY) 
					 + " charity deductions your earnings are: " + fmt1.format(earnings));
			
			 type = gen.nextInt(6);
			 
			 	// determine what kind of ice cream
			 	// the user may get
			 switch (type)
			 {
			 case 0: typeIceCream = IceCream.chocolate; break;
			 case 1: typeIceCream = IceCream.vanilla; break;
			 case 2: typeIceCream = IceCream.strawberry; break;
			 case 3: typeIceCream = IceCream.cream_in_cookies; break;
			 case 4: typeIceCream = IceCream.neopolitan; break;
			 case 5: typeIceCream = IceCream.bannanna_nut; break;
			 default: System.out.println("Error in type of ice cream");
			 		System.exit(0);
			 }
			 
			 System.out.println("For your generosity you will get " + 
			 typeIceCream + " ice cream!");
			 
		 }
		 	// user will NOT contribute to a charity
		 else if (answer == NO)
		 {
			 System.out.println("With *no* charity deductions your earnings are: " +
			 			fmt1.format(earnings) + ", no ice cream for you! :(");
		 }
		 else	// an error occurred here
		 {
			 JOptionPane.showMessageDialog(null,
		    		    "Error! Invalid value.",
		    		    "Invalid input",
		    		    JOptionPane.ERROR_MESSAGE);
		 }
	}	// end method determinePay
	
}	// end class PlayWithNumbers

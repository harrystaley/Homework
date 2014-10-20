/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package a7main;

/**
 *
 * @author staleyh
 */
import java.util.Scanner;
public class A7main {

    /**
     * @param args the command line arguments 
     */
  
    public static void main(String[] args) {
       
        
int monthsPassed = 0;

		Scanner SC = new Scanner(System.in);

		// Get starting balance & create demoAccount object
		System.out.print("Please enter the starting balance: $");
		
                SavingsAccount SAcctCl = new SavingsAccount(SC.nextDouble());

		// Gets annual interest rate
		System.out.print("Enter the annual interest rate (decimal): ");
		SAcctCl.setAnnualInterestRate(SC.nextDouble());

		// Gets number of months that have concluded since the inception of the account
		System.out.print("Enter the number of months that have passed since the account\'s establishment: ");
		monthsPassed = SC.nextInt();

		// Loops through all of the 
		for (int count = 1; count <= monthsPassed; count++)
		{
			// Display month number
			System.out.println("\n-----MONTH " + count + "-----");

			// Gets amount deposited into account for the particular month
			System.out.printf("Enter the amount deposited into the account: $");
			SAcctCl.deposit(SC.nextDouble());


			// Gets amount withdrawn from the account for the month
			System.out.printf("Enter the amount withdrawn from the account: $");
			SAcctCl.withdraw(SC.nextDouble());

			// Displays and increments monthly interest
			System.out.printf("This month\'s interest is: $%.2f\n", SAcctCl.getMonthlyInterest());
			SAcctCl.addMonthlyInterest();
		}

		System.out.printf("\nEnding balance: $%.2f", SAcctCl.getBalance());
		System.out.printf("\nTotal deposits: $%.2f", SAcctCl.getAccumulativeDeposits());
		System.out.printf("\nTotal withdrawals: $%.2f", SAcctCl.getAccumulativeWithdrawals());
		System.out.printf("\nTotal interest: $%.2f", SAcctCl.getAccumulativeInterest());


		SC.close();        
        
    }
    
}

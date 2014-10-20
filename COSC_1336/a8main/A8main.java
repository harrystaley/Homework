/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package a8main;
//import Java functions
import java.util.Scanner;

/**
 *
 * @author staleyh
 */

public class A8main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //call functions
        Rainfall RF = new Rainfall();
        Scanner keyboard = new Scanner(System.in);
                //declare variables
                final int SIZE = 12;
		double[] monthlyRain = new double[SIZE];
                //prompt for rainfall
		System.out.println("Enter the monthly rain fall amount for each of the following months.: ");
		int i = 0;

		// Input validation with 'Do-While Loop'
		for(i = 0; i < SIZE; i++){

			do{
				System.out.print("Month " + (i+1) + ": ");
				monthlyRain[i] = keyboard.nextDouble();
			}
			while(monthlyRain[i] < 0);

		}		
                //Display rainfall statistics
		System.out.println("The annual sum of rain: " + RF.sumRain(monthlyRain));
		System.out.println("The average sum of rain: " + RF.averageRain(monthlyRain));
		System.out.println("The most amount of rain fall: " + RF.mostRain(monthlyRain));
		System.out.println("The least amount of rain fall: " + RF.leastRain(monthlyRain));
	}		


    }
    


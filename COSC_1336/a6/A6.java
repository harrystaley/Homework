/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a6;
import java.util.Scanner;
/**
 *
 * @author staleyh
 */
public class A6 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
	

		
                //declare variables
                double meters = 0;
		double res = 0;
		int choice = 0;
              
               
                
                    
               while(choice != 4)
		{     
                 
                do{    
                System.out.print("Please enter distance in meters: ");
		meters = sc.nextDouble();}
                while (meters < 0);
                
                
                
                while(choice != 4)
		{ 		
                 //call the menu       
		showMenu();
                        //get the chouce from input and execute the particular option if selected
			choice = sc.nextInt();
			switch(choice) {
                            case 1:
                                res = showKilometers(meters);
				System.out.println(meters + " meters is " + res + " kilometers.\n");
                                break;
                            case 2:
				res = showInches(meters);
				System.out.println(meters + " meters is " + res + " inches.\n");
                                break;
                            case 3:
				res = showFeet(meters);
				System.out.println(meters + " meters is " + res + " feet.\n");
                                break;
                            case 4:
                                break;
                            default:
			   System.out.println("You have entered an incorrect selection!\n");
                        }
                		 
                }
	
		}
		   
	}
    
    
    
    
	public static void showMenu()
	{
		//Prompt the user for input
                System.out.println("Please make a selection:\n\n" +
                        "OPTIONS\n" +
                        "1) Convert to Kilometers\n" +
                        "2) Convert to Inches\n" +
                        "3) Convert to Feet\n" +
                        "4) Quit the Program\n\n");
	}
	//calculates and returns kilometers
	public static double showKilometers(double meters)
	{
		return (meters * .001);
	}
	
        //Calculates and returns inches
	public static double showInches(double meters)
	{
		return (meters * 39.37);
	}
	
	//calculates and returns feet
	public static double showFeet(double meters)
	{
		return (meters * 3.281);
	}
}	
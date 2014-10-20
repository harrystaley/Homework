/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package a4;

/**
 *
 * @author staleyh
 */
import java.util.Scanner;
public class A4 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
          //Set variables
	  long rainfall;
          int totalrainfall = 0;
          int years;
          long totalmonths;
          long averagerainfall;
          
          Scanner KBInput=new Scanner(System.in);
                    //prompt and get the users input for the number of years
	   	  System.out.println("Enter the number of years ");
		  years=KBInput.nextInt();
                  while (years< 1)
		{
			//User Input error message and re-prompt for the number of years
                        System.out.println("Please enter a number of years greater than zero.");
			years=KBInput.nextInt();
		}
                              
                  for (int currentyear = 1; currentyear <= years; currentyear++)
			                   
			for (int month = 1; month <= 12; month++)
			{   
				//Prompt the user and get the ranfall for the current year
                                System.out.println("Enter the inches of rainfall for year " + currentyear + " month " + month +".");
				rainfall=KBInput.nextInt();
					while (rainfall<0)
					{
                                                //Error message for inches of rainfall and reprompt for input
                                                System.out.println("Rainfall cannot be less than zero.");
                                                System.out.println("Enter the inches of rainfall for year " + currentyear +" month " +month);
						rainfall=KBInput.nextInt();
                                        }
                                        //increment rainfall
                                        totalrainfall += rainfall;
                         }
	  
                  //Calculate total months
                  totalmonths = years*12;
                  //Calculate average rainfall
                  averagerainfall = totalrainfall / totalmonths;
                  //Display outputs1
                  System.out.println("The total number of months rainfall was collcted was " + totalmonths +".");
                  System.out.println("The total rainfall for all collction periods was " + totalrainfall + " inches.");
                  System.out.println("The average rainfall for all collction periods was " + averagerainfall + " inches.");
        }
  

}

    


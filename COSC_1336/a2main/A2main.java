/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package a2main;

/**
 *
 * @author staleyh
 */
public class A2main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Set Total Customers and convert to string for output//
        int TotalCust = 12467;
        String TotalCustStr = Integer.toString(TotalCust);
       // Calc One or More Customers and convert to string for output//
        Double OneorMore = TotalCust * 0.14;
        String OneorMoreStr = Double.toString(OneorMore);
      // Calc Citrus and convert to string for output//
        Double CitrusDrinks = OneorMore * 0.64;
        String CitrusDrinksStr = Double.toString(CitrusDrinks);
      // Display// 
      System.out.println("Out of " + TotalCustStr + " total custoemrs approximately " + OneorMoreStr + " drink one or more energry drinks a week.");
      System.out.println("Of those " + OneorMoreStr + " custoemrs who drink one or more " + "energy drinks per week approximately " + CitrusDrinksStr + " prefer citrus flavored.");
       
        
                
    }
    
}

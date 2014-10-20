/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3;
/**
 *
 * @author staleyh
 */

/**Import other Java utilities globally this my not be advised normally.
 **/
import java.util.*;

public class A3 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
   
    //envoke the scanner class to accept inputs.
    Scanner sc = new Scanner(System.in);
    
    //declare and set variables
    double A = 0;
    double B = 0;
    double C = 0;
    double discrim = 0;
    double D = 0;
    double X1 = 0;
    double X2 = 0;
    
    // Display the quadratic eqation
    System.out.println("the quadratic equation is AX^2+BX+C=0.");
    
    //prompt for the value of A
    System.out.println("Enter value for 'A'");
    String str_a = sc.nextLine();
    //Parse the string input from the user into a number for calculation
    A = Double.parseDouble(str_a);
    
    //prompt for the value of B
    System.out.println("Enter value for 'B'");
    String str_b = sc.nextLine();
    //Parse the string input from the user into a number for calculation
    B = Double.parseDouble(str_b);
    
    //prompt for the value of C
    System.out.println("Enter value for 'C'");
    String str_c = sc.nextLine();
    //Parse the string input from the user into a number for calculation
    C = Double.parseDouble(str_c);
    
    //Calculate and display the Discriminent
    discrim = (Math.pow(B, 2.0)) - (4 * A * C);
    String Str_discrim = Double.toString(discrim);
    System.out.println("The discreminent is " + Str_discrim );
    //Find the absolute value of the discriminant
    D = Math.sqrt(Math.abs(discrim));
    
    //Find out what and if there is a single root
    if (A !=0 & B !=0 & C != 0){ 
        if(discrim == 0){
            X1 = (-B + D) / (2* A);
            String root_1 = Double.toString(X1);
            System.out.println("There is one root at: " + root_1);
        }
        //Find the real roots
        if (discrim > 0){
            X1 = (-B + D) / (2 * A);
            X2 = (-B - D) / (2 * A);
            String root_1 = Double.toString(X1);
            String root_2 = Double.toString(X2);
            System.out.println("There are two real roots at: "  + root_1 + " and "  + root_2);
        }
        //Find the imaginary roots
        if (discrim < 0){

            X1 = (-B + D) / (2 * A);
            X2 = (-B - D) / (2 * A);
            String root_1 = Double.toString(X1);
            String root_2 = Double.toString(X2);
            System.out.println("There are two imaginary roots at: " + root_1+"i " + "and " + root_2+"i");
        }
    }
    else  {
        System.out.println("Since the values of A, B, and C are all 0 the the equation evaluates to 0 = 0");
        }
    }   
        
        
    }
    


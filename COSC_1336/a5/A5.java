/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package a5;


/**
 *
 * @author staleyh
 */

//Import Functions
import java.util.Scanner;
import java.io.*;
public class A5 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
 {
        // TODO code application logic here
        
        //Call and set input file variable
       Scanner FileInport= new Scanner(System.in);
		  
                    //Primpt for input file
                  System.out.print("Enter the path to the input file."+"\n");
		  
                  //Get input file path
                  String InputFileName;
                    InputFileName = FileInport.nextLine();
		  
                    //Set the destination of the output file
                    System.out.print("Enter the destination path and name of the output File."+"\n");
		  String OutputFileName;
                    OutputFileName = FileInport.nextLine();
		  //Set the input file name to 
		  File myFile;
                    myFile = new File(InputFileName);
                    Scanner inputFile;
                    inputFile = new Scanner(myFile);
                    //create the output file
                    PrintWriter outputFile;
                    outputFile = new PrintWriter(OutputFileName);
		   
                    //Cycle though the input file and change the case
		  while (inputFile.hasNextLine())
		  {
		  	String fileRead;
                        fileRead = inputFile.nextLine();
			
                        String upperFileinput;
                        upperFileinput = fileRead.toUpperCase();
			outputFile.println(upperFileinput);
  
		}
			//Close the all of the files
                        inputFile.close();
			outputFile.close();
            }
        }



        
        
    
    


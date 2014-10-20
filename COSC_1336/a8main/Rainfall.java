/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package a8main;

/*import java.util.Scanner;*/

/**
 *
 * @author staleyh
 */
public class Rainfall {
    

	// Calculate and return the total rainFall for the year.

	public double sumRain(double[] array){
		double sum = 0;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
			}
		return sum;
		}

	// Calculate and Return the average monthly rainFall for the year.
	public double averageRain(double[] array){
		double average = 0;
		average = sumRain(array)/array.length;
		return average;
	}

	// Calculate and return the month with the most rain.
	public double mostRain(double[] array){
		double most = 0;
		for (int i = 0; i < array.length; i++){
			if(array[i] > most){
				most = array[i];
			}
		}
		return most;
	}

	// Calculate and return the month with the least rain.
	public double leastRain(double[] array){
		double least = array[0];
		for(int i = 0; i < array.length; i++){
			if(array[i] < least){
				least = array[i];
			}
		}
		return least;
	}

}


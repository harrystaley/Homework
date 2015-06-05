/**************
* Programmer: 	Harry Staley
* Course: 	COSC 1337
* Semester:	Fall 2014
* Assignment:	17
* Due Date:	Nov 11, 2014
**************************/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*declare a constant for an array with the size of five */
#define MAX 5

/* declare prototypes */
void payAmount(int , int *, int *, int *, int *);
void updateTwoElements(int *, int, int);
void printArray1(int *, int);
void printArray2(int *, int);
void populateArray(int *, int);

int main()
{
	/* variable declarations */
	int amount, twenties, tens, fives, ones;
	int numbers [MAX], first, second;
	int *ptr;

	srand(time(NULL));

	/* prompt the user to enter a dollar amount as an integer and then read it in*/
	printf("Enter a dollaar amount (an integer): ");
	scanf("%d", &amount);

	/* invoke the function 'payAmount' to calculate the number of bills to return to the user
	pass 'amount' via pass-by-value, and all other variable via pass-by-reference (address)*/
	payAmount(amount, &twenties, &tens, &fives, &ones);

	/* print out the amount of bills */
	printf("\nYour equivalent amount of bills for %d dollars is:\n", amount);
	printf("$20 bills: %d\n", twenties);
	printf("$10 bills: %d\n", tens);
	printf("$5 bills: %d\n", fives);
	printf("$1 bills: %d\n", ones);

	/* just for fun assign the pointer 'ptr' to point to the variable
	'tens' print out its value. Then print out the address to which 'ptr'
	is pointint to and compare it to the address of 'tens'. */
	ptr = &tens;
	printf("Using a pointer, there are %d ten dollar bills\n", *ptr);
	printf("Printing the pointer's address to where it is pointing to %d and where 'tens' is located %d\n", ptr, &tens);

	/* invoke the function 'populateArray' and fill the array with random numbers */
	populateArray(numbers, MAX);

	/* invoke the 'printArray1' function to print out the array eleents in a normal fashion */
	printArray1(numbers, MAX);

	/* invoke the 'printArray2' function to print out the array eleents in a different fashion via pointers */
	printArray2(numbers, MAX);

	/* Randomly select two numbers that will represnet two subscripts for the array 'numbers' */
	first = rand() % MAX;
	second = rand() % MAX;

	/* invoke the funciton 'updateTwoElements' to modify the elements at position
	'first' and 'second' of array 'numbers' */
	updateTwoElements(numbers, first, second);

	/* print out the two elements of the array 'numbers' that were modified */
	printf("\nBack in function main\n");
	printf("Element %d is now %d\n", first, numbers[first]);
	printf("Element %d is now %d\n", second, numbers[second]);

	printf("\n\nThis program was written by Harry Staley");
	printf("\nEnd of program.\n");

    return 0; /* end program normally */
}/* end function Main*/

void updateTwoElements(int *numbers, int first, int second)
{
	printf("\nInside updateTwoElements\n");
	printf("Will be updateing elements via pointers.\n");

	*(numbers + first) = (rand() % 100) + 1;
	*(numbers + second) = (rand() % 100) + 1;

	printf("Changed element %d to %d\n", first, *(numbers + first));
	printf("Changed element %d to %d\n", second, *(numbers + second));

}/* end function updateTwoElements */

void printArray1(int numbers[], int n)
{
	int i;
	printf("\nInside printArray1\n");
	printf("Will be printing array in a normal fashion.\n");

	for (i = 0; i < n; i++)
	{
		printf("Element %d has: %d\n",i, numbers[i]);
	}/* end for loop */
}/* end printArray1 function */

void printArray2(int *numbers, int n)
{
	int i;
	printf("\nInside printArray2\n");
	printf("Will be printing array in a fashion using pointers.\n");

	for (i = 0; i < n; i++)
	{
		printf("Element %d has: %d\n",i, *numbers++);
	}/* end for loop */
}/* end printArray2 function */

void populateArray(int numbers[], int n)
{
	int i;
	for (i = 0; i < n; i++)
		{
			numbers[i] = (rand() % 100) + 1;
		} /* end for loop */
} /* end poplateArray function */

void payAmount(int dollars, int *twenties, int *tens, int *fives, int *ones)
{
	*twenties = dollars / 20;
	dollars = dollars % 20;

	*tens = dollars / 10;
	dollars = dollars % 10;

	*fives = dollars / 5;
	dollars = dollars % 5;

	*ones = dollars;

}/* end function payAmount */

/**************
* Programmer: 	Harry Staley
* Course: 	COSC 1337
* Semester:	Fall 2014
* Assignment:	18
* Due Date:	Nov 18, 2014
**************************/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

/* declare prototypes for our funcions */
void compareNames(char [], char []);
void convertToUpperCase(char [], int, int);
void substring(int, int, char [], char []);

int main()
{
    /* declare variables to be used in the program */
	int i, lenFirst, lenLast, num1, num2, temp;
	char firstName[10], lastName[12];
	char fullName1[30], fullName2[30];
	char middle[10], mInitial[2];
	char newString[30];

	srand(time(NULL));

	/* prompt and read in from the Keyboard the first, middle, and last name of the user */
	printf("Please enter your first name: ");
	scanf("%s", firstName);

	printf("Please enter your last name: ");
	scanf("%s", lastName);

	printf("Please enter your middle name.\n");
	printf("If you do not have a middle name enter 'X': ");
	scanf("%s", middle);

	/* create middle initial from the middle name */
	mInitial[0] = middle[0];
	mInitial[1] = '\0'; /* add in null char */

	/* obtain the length of the first and last name respectively */
	lenFirst = strlen(firstName);
	lenLast = strlen(lastName);
	printf("\nLength of first name is %d\n Length of last name is %d\n", lenFirst, lenLast);

	/* buid up the first name consisting of the first, middle initial, and last name, copy them to another string and print them out*/
	strcpy(fullName1, firstName);
	strcat(fullName1, " ");
	strcat(fullName1, mInitial);
	strcat(fullName1, " ");
	strcat(fullName1, lastName);
	strcpy(fullName2, fullName1);

	/* Invoke the function 'compareNames' to compare the two names */
	compareNames(fullName1, fullName2);

	/* convert first full anme to upper and print to screen*/
	convertToUpperCase(fullName1, lenFirst, lenLast);

	/* Invoke the function 'compareNames' to compare the two names */
	compareNames(fullName1, fullName2);

	/* generate three seperate substings by invoking the function 'substring' and print them out */
	for (i = 0; i < 3; i++)
	{
		/* get the beginning position 'num1' and end position 'num2' by invoking the random number generator 'rand' */
		num1 = rand() % (lenFirst + lenLast + 3);
		num2 = rand() % (lenFirst + lenLast + 3);

		/* num2 must be greater than num1 if not make it so */
		if (num2 < num1)
		{
			temp = num1;
			num1 = num2;
			num2 = temp;
		}/* end if num2 < num1 */

		/* invoke the function 'substring' to acquire a new substring and display it */
		substring(num1, num2, fullName1, newString);
		printf("\nOriginal string: %s\n", fullName1);
		printf("Substring of %d to %d is: %s\n",num1, num2, newString);


	}/* end for loop */


	printf("\n\nThis program was written by Harry Staley");
	printf("\nEnd of program.\n");


    return 0; /*end the program normally */
}/* end main function*/

void substring(int start,int end,char name[],char newstring[])
{
	int i, j;
	j = 0;

	/* begin substring from posistion 'start' and create it until you reach posistion 'end' */
	for (i = start; i <= end; i++)
	{
		newstring[j] = name[i];
		j++;
	}/* end for loop */

	newstring[j] = '\0'; /* add null char to terminate the string */
}/* end function substring */

void comvertToUpperCase(char name[], int lenFirst, int lenLast)
{
	int i;

	/* convert first full nae to uppercase and print */
	for (i = 0; i < (lenFirst + lenLast + 3); i++)
	{
		name[i] = toupper(name[i]);
	}/* end for loop */
	printf("\nNow the name has been changed to %s\n", name);
}/* end function convertToUpperCase */

void compareNames(char name1[], char name2[])
{
	printf("\nGoing to compare the following names");
	printf("\nname1: %s , and name2: %s\n", name1 ,name2);

	if (strcmp(name1, name2) == 0)
	{
		printf("\nBoth full names are the same!\n");
	}
	else if (strcmp(name1, name2) < 0)
	{
		printf("\nname1 is less than name2: %s and %s \n\n", name1, name2);
	}
	else
	{
		printf("\nname1 is greater than name2: %s and %s \n\n", name1, name2);

	}/* end if compare name1 to name2 */
}/* end function compareNames */

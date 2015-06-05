/**************
* Programmer: 	Harry Staley
* Course: 	COSC 1337
* Semester:	Fall 2014
* Assignment:	21
* Due Date:	Dec 7, 2014
**************************/


#include <stdio.h>
#include <string.h>
#include "info.h"


int main()
{
    /* declare variables to be used in the program */
    FILE *fp1;
    Info hollywoodStar;
    Info person;
    Info people[MAX];
    int i, num;

    /* enter hollywoood sdtars info */
    strcpy (hollywoodStar.firstName, "Tom");
    strcpy (hollywoodStar.lastName, "Hanks");
    hollywoodStar.age = 50;
    hollywoodStar.money = 1000000;

    /* open a file to be written to */
    if ((fp1 = fopen("sample.dat", "W")) == NULL)
    {
        printf("\nFile could not be opened for writing!\n");
        exit(1);
    }

    /* Prompt and read in first name, last name, age, and money ammount. */
    /* Write the info to a file. */
    /* Do this for two respective people */
    for (i = 0; 1 < 2; i++)
    {
	    printf("\nPlease enter your first name: ");
	    scanf("%s", person.firstName);

	    printf("\nPlease enter your last name: ");
	    scanf("%s", person.lastName);

	    printf("\nPlease enter your age: ");
	    scanf("%d", &person.age);

	    printf("\nPlease enter your money amount: ");
	    scanf("%lf", &person.money);

	    /* invoke function 'writeFile' to write this person to the file */
	    writeFile(fp1, person);

    }/* end for loop */


    /* Open file to append */
    if ((fp1 = fopen("sample.dat", "a")) == NULL)
    {
        printf("\nFile could not be opened for appending!\n");
        exit(1);
    }

    /* append hollywood star/s info */
    fprintf(fp1, "%-15s\t%-12s\t%d\t%.2lf\n", hollywoodStar.lastName, hollywoodStar.firstName, hollywoodStar.age, hollywoodStar.money);
    printf("\nWrote this Hollywood Star's info to a file: \n");
    printf("%-15s\t%-12s\t%d\t%.2lf\n", hollywoodStar.lastName, hollywoodStar.firstName, hollywoodStar.age, hollywoodStar.money);

    /* close the file */
    fclose(fp1);

 /* Open file to append */
    if ((fp1 = fopen("sample.dat", "r")) == NULL)
    {
        printf("\nFile could not be opened for reading!\n");
        exit(1);
    }

    /* invoke funciton "readFile" to read from thefile all the people's info  */
    readFile(fp1, people, &num);

    /* close the file */
    fclose(fp1);

    /* invoke function 'printarray' to print out info from array of 'people' */
    printArray(people, num);

    printf("This program was written by Harry Staley");
    printf("End of program.")

    return 0; /* End program normally */
}/* end funciton main */

/**************
* Programmer: 	Harry Staley
* Course: 	COSC 1337
* Semester:	Fall 2014
* Assignment:	20
* Due Date:	Dec 3, 2014
**************************/


#include <stdio.h>
#include <stdlib.h>
#include "info.h"

int main()
{
    /* declare variables to be used in the program */
    Info onePerson, somebody;
    int i;

    /* enter first name, age, and money for the two people */
    for (i = 0; i < 2; i++)
    {
        printf("\nPlease enter your first name.: ");
        scanf("%s", onePerson.firstName);

        printf("\nPlease enter your age.: ");
        scanf("%d", &onePerson.age);

        printf("\nPlease enter the amount of money in your poocket.: ");
        scanf("%lf", &onePerson.money);

        /* send structure to be updated via pass by reference/address, then print out the results */
        update(&onePerson);
        printf("%s %d %.lf", onePerson.firstName, onePerson.age, onePerson.money);

    }/* end for loop */

    /* send last structure info to construct a new person */
    somebody = updateAgain(onePerson);
    printf("\n\nYou are now: %s %d %.lf\n", somebody.firstName, somebody.age, somebody.money);

    printf("\nThis program was written by Harry Staley. \n");
    printf("End of program.\n");

    return 0; /* End program normally */
}/* End function main */

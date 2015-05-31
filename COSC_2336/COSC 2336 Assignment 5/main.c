/*************************************
 * Programmer: Harry Staley
 * Course: COSC 2336
 * Semester: Spring 2015
 * Assignment #: 5
 * Due Date: 3-4-2015
 *************************************/

 #include <stdio.h>
 #include <string.h>
 #include "link.h"

 int main()
 {
    /* declare variables to be used in program */
     char name[15];
     char oneChar;
     int strLength, done = 0, i, age;
     Node *newPerson;

     do
     {
        /* prompt and read in name and age */
        printf("\nPlease enter a name (or 'q' to quit):\n");
        scanf("%s", name);
        strLength = strlen(name);

        if (strLength == 1 && tlower(name[0] == 'q'))
        {
            done = 1; /* we are done! */
        } /* end if */
        else if (strLength == 0)
        {
            printf("\n\t***You must enter a name!***\n\n");
        } /* end else */
        else /* a valid name has been entered */
        {
            printf("Please enter an age:\n");
            scanf("%d", &age);

            /*Create a new node for this person */
            newPerson = (Node *) createNewNode(name, age);
            /* add this node to the linked list */
            add(newPerson);
        } /* end else statement */

        /* proceed if we are not done */
        if (!done)
        {
            printList();
        } /* end if */

     } while (!done);

     printf("\nThis program was created by Harry Staley.");
     printf("\nEnd of program");
     return 0; /*exit program normally */
 } /* end function main */
/***********************
 * Programmer: Harry Staley
 * Course: COSC 2336
 * Semester: Spring 2015
 * Assignment #: 7
 * Due Date: Mar 25, 2015
 ****************************/

 #include <studio.h>
 #include <string.h>
 #include "link2.h"

 int main()
 {
    /* declare variables to be used in program */
    char name[15];
    char inputChar, operation;
    int done = 0;
    int valid = 1, badOperation;

    /* invoke 'initLIst' to populate the linked list */
    initLIst();

    /*print out current linked list */
    printLIst();

    /* enter do-while to add/delete to/from the linked list */
    do
    {
        printf("\nPlease enter a letter (or 'q' to quit \n");
        inputChar = getc(stdin);
        getc(stdin);

        /* convert character to lower case */
        inputChar = tolower(inputChar);
        printf("You selected the character %c\n", inputChar);

        if (inputChar == 'q')
        {
            done = 1;
        }
        else
        (
            valid = validCharacter(inputChar);
            if(valid == 0)
            {
                /* Error! Invalid character was entered */
                printf("\n\t***You must entere a valid character***\n\n");
            } /* enf if */
            else
            {
                do
                {
                    printf("\nWould you like to add or delete this character? (a/d)\n");
                    operation = getc(stdin);
                    getc(stdin);
                    operation = tolower(operation);

                    /* add a node */
                    if (operation == 'a')
                    {
                        add(createNewNode(inputChar));
                        badOperation = 0;
                    }
                    /* delete a node */
                    else if (operation == 'd')
                    {
                        delete(inputChar);
                        badOperation = 0;
                    }
                    /* invalid input */
                    else
                    {
                        printf("\n\t***Invalid Operation. Please try again.****\n");
                        badOperation = 1;
                    }
                } while (badOperation);
                /* print out current linked list */
                printLIst();
            } /* end else statement */
        ) /* end outer else statement */
    } while (!done);

    printf("\nThis program was written by Harry Staley");
    printf("\nEnd of program!");

    return 0;
 } /* end function main
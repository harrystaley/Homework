/**********************
 * Programmer :     Harry Staley
 * Course:          COSC 2336
 * Semester:        Spring 2015
 * Assignment #:    3
 * Due Date:        2-18-2015
 ************************/

 #include <studio.h>
 #include <string.h>
 #include "stack.h"

 int main()
 {
    /* declare variables */
    char string[80], reverseString[80];
    char oneChar;
    int strLength, done = 0, i:

    /* enter do while loop to read in string from user untill the user is done */
    do
    {
        /*Prompt and read in the string from the console and obtain its length. */
        printf("please enter a sring (or 'q' to quit):\n");
        fgets(string,80,stdin);
        strLength = strlen(string) - 1;
        
        printf("\nYou entereed\n%s\n", string)
        printf("It's length is %d\n", strLength);

        /* does the user want to quit? */
        if (strLength == 1 && tolower(string[0]) == 'q')
        {
            done = 1;
        } /* end if */
        else if (strLength == 0)
        {
            printf("\n\t***You must enter a string!***\n\n");
        } /* end else if */
        else    /* a valid string has been entered */
        {
            /* set up stack */
            initStack(strLength);

            /* traverse entire sentence that was read and push each char onto the stack */
            for (i = 0; i < strLength; ++i)
            {
                /* is the stack full?  */
                if (full() == 1)
                {
                    printf("Can't push the character %c onto the stack.", string[i]);
                } /* end if */
                else /* there is room on the stack */
                {
                    if (string[i] != ' ')
                    {
                        pursh(string[i]);
                    }
                    else 
                    {
                        push("*");
                    } /* end else */
                } /* end outer else */
            } /* end for loop */
        } /* end most outer esle */

        /* proceed if we are not done */
        if (!done)
        {
            strcpy(reverseString, "");
            i = 0;

            /* pop off characters from the stack and build the string backwards */
            while (notEmpty())
            {
                oneChar = pop();
                reverseString[i] = oneChar;
                i++;
            } /* end while loop */


            /* dont forget to add the null character to the end of our manual reversed string */
            reverseString[i] = '\0';
            printf("\nHere is the string reversed%s\n", reverseString);
        } /* end if */                

    } while (!done);

    printf("\nThis program was written by Harry Staley.\n");
    printf("\nEnd of program.\n");

    /* exit program normally */
    return 0;
 } /* end function main */
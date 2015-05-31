/************************************
 * Programmer: Harry Staley
 * Semester: Spring 2015
 * Assignment: 11a
 * Due Date: 4-22-2015
 **************************************/

 #include <stdio.h>

 /* declare function prtotype that will be used in the program */
 int fact(ing);

 int int main()
 {
    /* declare variables */
    int number, theFact;
    do
    {
        /* prompt the user for input and then read it in */
        printf("\nEnter an integer number (or -1 to quit quit)\n");
        scanf("%d", &number);

        if (number != -1)
        {
            /* invoke the function 'fact' to calcualte the factorial. */
            theFact = fact(number);
            printf("The factorial of %d! is %d\n", number ,theFact );

        } /* end if */
        


    } while (number != -1);

    printf("\nThis program was written by Harry Staley \n ENd of program.\n");

    /* exit program normally */
    return 0;
 } /* end function main */

int fact(int num)
{
    int answer;

    /* test to see if the base case has been reached */
    /* The base case is when 'num' is less than or equal to one*/
    if (num <= 1)
    {
        printf("Reached base case. Return 1.\n");
        return 1;
    } /* end if statement */
    else
    {
        /* recursively call the function 'fact' again. */
        /* Pass the parameter by subtracting one from 'num'.*/
        answer = num * fact(num - 1);
        printf("Processing: %d * %d -> %d\n", num, (num -1), answer );
        return answer;
    } /* end else statement */
} /* end function fact */
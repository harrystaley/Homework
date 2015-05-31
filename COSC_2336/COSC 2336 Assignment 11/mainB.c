/************************************
 * Programmer: Harry Staley
 * Semester: Spring 2015
 * Assignment: 11b
 * Due Date: 4-22-2015
 **************************************/

#include <stdio.h>
#include <string.h>

 /* declare function prototype to be used in program */
 void decToBin(int, int);

 /* declare a string to hold the answer */
 char output[50];

 int int main()
 {
    /* decalre variables to be used in the program*/
    int decimalNumber, base;
    base = 2;

    do
    {
        /* prompt the user to enter an integer number in base 10 then read it in*/
        printf("\nEnter an integer number in base 10 (or 0 to quit)\n");
        scanf("%d", &decimalNumber);

        if (decimalNumber != 0)
        {  
        

        strcpy(output, "");
        printf("Decimal number: %d\n", decimalNumber);

        /* Invoke the method 'dec ToBin' to convert the decimal number to binary */
        decToBin(decimalNumber, base);
        printf("Binary number: ");
        printf("%s", output);

        } /* end if statement */

    } while (decimalNumber != 0);



    printf("\nThis program was written by Harry Staley \n ENd of program.\n");

     /* exit program normally */
     return 0;
 } /* end function main */

void decToBin(int num, int base)
{
    int answer;

    /* test to see if the base case has been reached. the base case is when num is zero or less*/
    if (num > 0)
    {
        /* recursively call decToBin the method again pass the first apramiter by dividing num by base and the second paramiter is always the baase.*/
        decToBin((num / base), base);
        if ((num % base) == 1)
        {
            strcat(output, "1");
        }
        else
        {
            strcat(output, "0");
        }
        printf("Current Answer: %s\n", output);
    } /* end if statement */
    else
    {
        /* we have reached the base case */
        printf("\nReached the base case.\n");
        return;
    } /* end else statement */

} /* end function decToBin */
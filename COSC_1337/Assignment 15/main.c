/**************
* Programmer: 	Harry Staley
* Course: 	COSC 1337
* Semester:	Fall 2014
* Assignment:	15
* Due Date:	Nov 5 , 2014
*****************/


#include <stdio.h>
#define N 5 /* identifier/constant for array sizze */

/* prototpe for our functions  */
int addthem(int,int);
void modifyThem(int,int);
int modifyArray(int[],int);

int main()
{
    /* declare variables to be used */
    int i,x,y,answer;
    int numbers[N] = {10,15,3,5,2};

    /* prompt user to enter two numbers and read tehm into the array */
    printf("Pease enter two numbers:\n");
    scanf("%d %d", &x, &y);

    printf("\nbefore invoking 'addThem'. X is %d, y is %d\n",x,y);

    /* Invoke the function 'addThem' to add X and Y, then return answer */
    answer = addThem(x,y);

    printf("After invoking 'addThem'. %d plus %d is %d\n",x,y,answer);

/*************************************/

    printf("\n\nBefore invoking 'modifyThem'. x is %d and y is %d\n", x,y);

    /* test to see if you can modify X and y in the function modifyThem */
    modifyThem(x,y);

    printf("After invoking 'modifyThem'. x is %d and y is %d\n",x,y);

/*************************************/

    for (i = 0; i < N; i++)
    {
        printf("index %d of array has %d\n",i,numbers[i]);
    } /* end for loop */

    /* invoke the function 'modifyArray' to modify each element in the arrray and return back its summation */
    answer = modifyArray(numbers, N);

    printf("\nAfter invoking 'modifyArray' the numbers in the array are:\n");


    for (i = 0 ; i < N; i++)
    {
        printf("index %d of array has %d\n",i,numbers[i]);
    } /* end of loop */

    printf("\nSummation of modified array %d\n", answer);

    printf("\nThis program was written by Harry Staley.");
    printf("End of program.");

    return 0; /* end program normally */
}/* end function main */

int addThem(int a,int b)
{
    int localAnswer;
    localAnswer = a + b;
    return localAnswer;
}/* end function addThem */

void modifyThem(int a,int b)
{
    a = a + 10;
    b = b + 7;
    printf("Inside funciton 'modifyThem'. x is %d y is %d\n",a,b );
}/* end function modifyThem */

int modifyArray(int numbers[],int n)
{
    int i, sum;
    sum = 0;

    for (i = 0; i < n; i++)
    {
        numbers[i] = numbers[i] * 2;
        sum = sum + numbers[i];
    } /* end for loop */

    return sum;
}

/*******************************************************
* Programer:     Harry Staley
* Course:        COSC 2336 Section 001  
* Semester:      Spring 2015    
* Assignment:    9
* Due Date:      April 8, 2015
* ********************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "queue.h"
int main ()
{
    /* declare variables to be */
    /* used in program */
    char name [20];
    char operation [8];
    int strLength, done1 = 0, done2 = 0;
    double bill;
    QueueInfo element;

initQueue ();

do
{
    /*prompt the user to enter their name */
    /*then read it in the obtain its */
    /* length */
    printf("\nPlease enter a name for 'q' to quit): \n ");
    scanf("%s", name);
    strLength = strlen (name);

    if(strLength == 1 && 
        name[0]=='q')
 {
    done1 = 1; /*we are done! */
 }       
else if (strLength == 0)
{
        /* Error! No string was entered */
    printf("\n\t*** You must enter a name!***\n\n");
}
else
{
    printf ("Please enter the bill:\n");
    scanf("%lf", &bill);

    strcpy (element.name, name);
    element.bill =  bill;

    done2 = 0;

do
{
/* prompt the user to whether they wish */
/* to enqueue or dequeue shopper */    

    printf("\nWhat do you wish to do? (enqueue/dequeue)?\n");
    scanf("%s", operation);

if (tolower(operation[0]) == 'e')
{
    if (fullShoppers() == 1) /* queue is full */
     {
        printf("\nCan't enqueue the customer. Queue"
            "is fuill!\n");
     }
    else   /* queue is not full, can enqueue shopper */
    {
        enqueue(element);
    }
    done2 = 1;
     
}  /* end if for enqueue */
else if (tolower(operation[0]) =='d')
{
  if(emptyShoppers() == 1)
{
printf("\nCan't dequeue a customer.  Queue" 
        "is empty!\n");
}
else
{
    element = dequeue();
}
done2 = 1;
}/* end else-if for dequeue*/
else
{
    printf("\n\t***Error!  Invalid operation.  "
            "Please try again.\n");
}

} while(!done2);
} /*end outer else statement*/
  /*print out current contents of queue */
if(!done1)
{
    printQueue();
}
}    while (!done1);

   printf("\nThis program was written by Harry Staley.");
   printf("\nEnd of program.\n");

 /* exit program normally */
    return 0;
} /* end function main */

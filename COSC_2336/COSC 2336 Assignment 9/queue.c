#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "queue.h"
#define Q_SIZE   3  /* defined for queue size */

QueueInfo customer[Q_SIZE];
int queueLength, customerCounter;
int rearCustomer, frontCustomer;

void initQueue()
{
    customerCounter = 0;
    rearCustomer = 0;
    frontCustomer = 0;
    queueLength = Q_SIZE;
}  /* end function initQueue  */

int fullShoppers()
{
    if   (customerCounter == queueLength)
    {
        return 1;  /* queue is full! */
    }
    else
    {  
        return 0; /* queue is NOT full! */  
    }
}    /* end function fullShoppers */

int emptyShoppers()
{
    if (customerCounter == 0)
    {
        return 1; /* queue is empty */
    }
    else
    {
        return 0; /* queue is NOT empty! */
    }
}  /* end funtion emptyShoppers */

void enqueue (QueueInfo element)
{
    /* place this shopper in the rear */
    /* of the  queue */
    customer[rearCustomer] = element;

    printf("\nEnqueued %s, %.2lf\n", customer[rearCustomer].name,customer[rearCustomer].bill);

    /*adjust rear pointer of the queue */
    /* for the bext future customer */
    rearCustomer = (rearCustomer + 1) % Q_SIZE;

    /* update the number of elements */
    /* that are currently in the queue */
    customerCounter++;

} /* end function enqueue */

QueueInfo dequeue ()
{
    QueueInfo element;
    /* dequeue customer at the */
    /* front of the queue */
    element = customer[frontCustomer];

    printf("\nDequeue %s, %.21f", element.name, element.bill);

    /* adjust front pointer of the queue */
    /* for the next future customer */
    frontCustomer = (frontCustomer+1) % Q_SIZE;

    /*update the number of elements */
    /* that are currently in the queue */
    customerCounter--;   

    return element;

} /* end function dequeue */
   
void printQueue()
{
    QueueInfo dequeuePerson;
    QueueInfo holdShoppers[Q_SIZE];
    int i = 0, j;

    printf("\nHere is your current shopper's queue:\n");

    /*dequeue shoppes in queue and store */
    /* them in to a temprary queue and then */
    /*print out each shopper's name and bill */
    while (emptyShoppers() == 0)
    {
        dequeuePerson = dequeue();
        holdShoppers[i] = dequeuePerson;
        i++;

        printf("\n%s and %.2lf",dequeuePerson.name,dequeuePerson.bill);
    }   /* end while loop */

    printf("\n\n");

    /* put the shoppers back into */
    /* the queue (i.e. enqueue them again) */
    for (j = 0; j< i; j++)
    {
        enqueue(holdShoppers[j]);
    } /* end for the loop */
} /* end function printQueue */

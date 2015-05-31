#ifndef QUEUE_H_INCLUDED
#define QUEUE_H_INCLUDED

typedef struct 
{ 
    char name[20];
    double bill;
}   QueueInfo;

/* declare prototype to be */
/* used in program */
void initQueue ();
int fullShoppers();
int emptyShoppers();
void enqueue(QueueInfo);
QueueInfo dequeue();
void printQueue();

#endif

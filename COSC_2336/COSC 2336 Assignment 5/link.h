#ifndef LINK_H_INCLUDED
#define LINK_H_INCLUDED

typedef struct list
{
    char name[15];
    int age;
    struct list *next; /* points to next node */
}   Node;
    /* declare prototypes for functions to be used in program */
void add(Node *);
Node * createNewNode(char[], int);
void printLIst();

#endif
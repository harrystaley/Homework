#ifndef INFO_H_INCLUDED
#define INFO_H_INCLUDED
#endif // INFO_H_INCLUDED

#include <stdio.h>
    /* declare constant to be used */
    # define MAX 5

typedef struct
{
    char firstName[12];
    char lastName[15];
    int age;
    double money;

} Info;

    /* declare prototypes for functions to be used in the program */
void writeFile(FILE *, Info);
void reatFile(FILE *, Info[], int *);
void printArray(Info[], int);

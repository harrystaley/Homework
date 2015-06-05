#ifndef INFO_H_INCLUDED
#define INFO_H_INCLUDED

/* define typedef struct to hold information abouta a person */
typedef struct
{
    char firstName[20];
    int age;
    double money;
} Info;

/* declare prototypes to be used */
void update(Info *);
Info updateAgain (Info);

#endif // INFO_H_INCLUDED

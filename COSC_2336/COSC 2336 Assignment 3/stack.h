#ifndef STACK_H_INCLUDED
#define STACK_H_INCLUDED

typedef struct
{
    char oneChar;
}   Info;

void initStack(int);
int full();
int notEmpty();
void push(char);
char pop();

#endif
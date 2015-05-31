#include <stdio.h>
#include <stack.h>

/* declare variables */
info stack[80];
int stackCounter, stackLength;

void initStack(int strLength)
{
    stackCounter = 0;
    stackLength = strLength;
} /* end of function initStack */

int full()
{
    if (stackCounter == stackLength)
    {
        return 0; /* stack is full */
    }
    else
    {
        return 1; /* stack is not full */
    }
} /* end function full */

int notEmpty()
{
    if (stackCounter != 0)
    {    
        return 1; /* stack is not empty */
    }
    else
    {
        return 0; /* stack is empty */
    }
} /* end function empty */

int push(char element)
{
    stack[stackCounter].oneChar = element;
    stackCounter++;
    printf("pushed %c\n", element);
} /* end function push */

int pop()
{
    char oneItem;
    --stackCounter;
    oneItem = stack[stackCounter].oneChar;
    printf("Popped:  %c\n", oneItem);
    return oneItem;
} /* end function pop */
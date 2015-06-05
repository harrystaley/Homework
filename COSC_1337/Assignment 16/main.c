/**************
* Programmer: 	Harry Staley
* Course: 	COSC 1337
* Semester:	Fall 2014
* Assignment:	16
* Due Date:	Nov 5 , 2014
/**************************************************************/



#include <stdio.h>

#include<stdlib.h>

enum  Outcome  {  CONTINUE, WIN, LOSE  };
int rollDice(void);

int main()
{
    /* declare variables to be used*/
    enum Outcome gameStatus;
    int sum, myPoint, i, roll, length = 0 ;
    int wins [22] = {0} ;
    int losses [22]= {0} ;
    int winSum = 0, loseSum = 0 ;

    srand( time  (NULL));

    for (i = 1; i <=1000; i++)
    {

    sum = rollDice();
    roll = 1;

    /* test if game won or lost on firs roll*/

    switch (sum)
    {
    case 7:
    case 11: gameStatus = WIN;
        break;
    case 2:
    case 3:
    case 12: gameStatus = LOSE;
        break;
    default:    gameStatus =  CONTINUE;
                myPoint = sum;
        break;
    }  /* end switch statement*/

   /* continue while game not won or lost*/
    while (CONTINUE == gameStatus)
    {
    sum = rollDice();
     roll ++;

    /* win on next roll? */
    if (sum == myPoint)
    {
        gameStatus = WIN;
    }
    else  /* lose on next roll?*/
    {
        if (sum==7)
        {
            gameStatus = LOSE;
        }/*end else statement*/
    }  /*  end while loop*/

    if (roll > 21)
    {
    roll = 21;
    }
        /* determine how many rolls were taken */
        /* and increment corresponding counter */
        /* in wins or losses array*/
        if (WIN == gameStatus)
        {
        ++wins[roll];
        winSum++;
        } /* end if statement */
        else
        {
            ++ losses [roll];
            loseSum++;
        }  /* end else statement*/
    }  /* end for loop */

    printf  ("Games won or lose after the 20th roll\n are displayed as the 21st roll. \n");

    /* display number of games won and lost */

    for (i = 1; i <= 21; i++)
    {
        printf("%d games won and %d games lost on roll %d.\n",wins[i], losses[i], i);
    } /* end for loop*/

    /* calculate chances of winning */

    printf ("\nThe chances of winning are %d%d = %. 1 f%%\n",  winSum, winSum + loseSum,100.0 * winSum/ (winSum + loseSum));

    /* calculate average length of game */

    for (i = 1; i <=21 ; i++)
    {
    length += wins[i] * i + losses[i] * i;
    }/* end for loop*/

    printf("The average game length is %.21f rolls./n",length / 1000.0);

    printf("\n\nThis program was written by Harry Staley.\n");
    printf("End of program.\n");

    return 0; /* end program normally*/
    }
}  /* end function main */


int  rollDice ()
{

int die1, die2, sum;

die1 = (rand() % 6)+1 ;
die2=(rand()%6)+1;
sum=die1 +die2;

} /* end function rollDice */









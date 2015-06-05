/**************
* Programmer: 	Harry Staley
* Course: 	COSC 1337
* Semester:	Fall 2014
* Assignment:	14
* Due Date:	April 2, 2014
*****************/

#include <stdio.h>

#define PI 3.14159 /* identifier/constant for the variable PI*/

int main(void)
{

    /* decalre variables to be used in teh program*/
    double volume, radius;

    /* prompt the user for the radius then read it in */
    printf("Enter the radius of the spehre: ");
    scanf("%lf", &radius);

    /* calculate the volume of the sphere and display on screen. */
    volume = (4.0/3.0) * PI * radius * radius * radius;
    printf("\nThe volume of the sphere with a %.2lf meter radius is: %.4lf cubic meters.", radius, volume );

    printf("\nThis program was written by Harry Staley");
	printf("\nEnd of program.");

	return 0; /* end program normally */


} /* End of main function */

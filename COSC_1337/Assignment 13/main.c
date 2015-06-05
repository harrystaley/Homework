/**************
* Programmer: 	Harry Staley
* Course: 	COSC 1337
* Semester:	Fall 2014
* Assignment:	13
* Due Date:	April 2, 2014
*****************/

#include <stdio.h>

int main(void)
{
	/* Declare variables to be used in the program */
	int itemNumber, month, day, year;
	double unitPrice;


	/* Prompt the user to enter the item number */
	printf("Enter the item number: ")
	scanf("%d", &itemNumber);

	/* Prompt the user to enter the unit price and then read it in */
	printf("Enter the unit price: ");
	scanf("%lf", &unitPrice);

	/* prompt the user to enter the purchase date and read it in */
	printf("Enter the purchase date mm/dd/yyyy: ");
	scanf("%d/%d/%d", &month, &day, &year);

	/* print out the product information in a nice format*/
	printf("\n\nItem\t\tUnit\t\tPurchase\n");
	printf("\t\tPrice\t\tDate\n\n");
	printf("%d\t\t$%7.2lf\t%d/%d/%d\n",
		itemNumber, unitPrice, month, day, year);

	printf("\nThis program was written by Harry Staley")
	printf("\nEnd of program.")

	return 0; /* end program normally */

} /* End of Funcatdion Main */


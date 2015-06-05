#include "info.h"

void writeFile(FILE *fp1, Info person)
{
    fprintf(fp1, "%-15s\t%-12s\t%d\t%.2lf\n", person.lastName, person.firstName, person.age, person.money);
    printf("\nWrote this person's info to a file: \n");
    printf("%-15s\t%-12s\t%d\t$%.2lf\n", person.lastName, person.firstName, person.age, person.money);

    /* close file */
    close(fp1);
}/* end function writeFile */

void readFile(FILE *fp1, Info people[], int *num)
{
    char line[80];
    int i = 0;
    *num =0;

    printf("\nGoing to read people info from file and store them into an array.\n");

    while (fgets(line, 80, fp1) != NULL)
    {
        sscanf(line, "%s%s%d%lf", people[i].lastName, people[i].firstName, &people[i].age, &people[i].money);

        /* update subscript */
        i++;

        /* track the number of people being read from the file and passed into the array 'people' */
        (*num)++;

    }/* end while loop */
}/* end function readFile */

void printArray(Info people[], int num)
{
    int i;
    printf("\nGoing to print people info that was read from the file and stored in an array.\n");

    /* print a header for the data to display on sreen */
    printf("\nLast Name\tFirst Name\tAge\tMoney");

    for (i = 0; i < num; i++)
    {
        printf("%-15s\t%-12s\t%d\t$%.2lf\n", people[i].lastName, people[i].firstName, &people[i].age, &people[i].money);
    }/* end for loop */
}/* end of funciton printArray */

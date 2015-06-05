#include "info.h"

void update(Info *onePerson)
{
    /* update the 'age' and 'money' fields of this Info person */
    onePerson->age = onePerson->age + 3;
    onePerson->money = onePerson->money + 2;

}/* end function update */

Info updateAgain(Info onePerson)
{
    Info anotherPerson;
    char name[20];

    /* copy the field 'firstName' of this info person to the local variable 'name' */
    strcpy(name, onePerson.firstName);

    /* update 'name' appropriately */
    switch (onePerson.age % 2)
    {
        case 0: strcat(name, " Rich "); break;
        case 1: strcat(name, " Moderate "); break;
        default: strcat(name, " X ");
    }/* end switch statement */

    /* update new info for 'anotherPerson' by copying 'name' to the field 'firstName' of 'anotherPerson' while updating 'age' and 'money' fields */
    strcpy(anotherPerson.firstName, name);
    anotherPerson.age =onePerson.age + 10;
    anotherPerson.money = onePerson.money + 500.0;

    /* return this newly created Info person 'anotherPerson' */
    return anotherPerson;

}/* end function updateAgain */

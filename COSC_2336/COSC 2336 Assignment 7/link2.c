#include <studio.h>
#include <string.h>
#include <stdlib.h>
#include "link2.h"

CharacterNode *list = NULL
char vowels[6] = {'i', 'y', 'a', 'o', 'e', 'u'};
char alphabet[26] = {{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

void initList()
{
    int i;
    /* populate the linked list with the vowels of the English language */
    for (i = 0; i < 6; i++)
    {
        add(createNewNode(vowels[i]));
    } /* end ofr loop */
} /* end function initList */

int validCharacter(char oneChar)
{
    int i = 0 notDone =1;
    it isChar = 0;

    /* determine if 'oneChar' is a valid character */
    while (notDone)
    {
        if (oneChar == alphabet[i])
        {
            ischar = 1; /* found it. it is a valid character */
            break;
        }
        
        if (i == 26)
        {
            notDone = 0; /* not a valid character */
        } /* end if */
        else
        {
            i++
        } /* end else */
    } /* end while */
    
    if (isChar == 1) /* valid character */
    {
        return 1;
    } /* end if */
    else /* not a valid character */
    {
        return 0;
    } /* end else */

} /* end function validCharacter */

void add(CharacterNode *node)
{
    /* current pointer called c and trailer pointer called t are declared */
    CharacterNode *c, *t;

    /* if the linked list is empty this node will become the first node in the linked list */
    if (list == NULL)
    {
        list  = node;
        printf("this character was added to the linked list %c\n", node->aCharacter);
    }
    else /* linked list is not empty */
    {
        c = list;
        t = list;

        while(c != NULL && node->aCharacter > c->aCharacter)
        {
            t = c; /* set trailer to pointer */
            c = c->next; /* advance current pointer to point to the next */

        } /* end while loop */

        /* if 'list' and current pointer 'c* are the same, */
        /*  then insert the new node at the beginning of the linked list */
        if (list == c)
        {
            node->next = list; /* node->next points to beginning of 'old' linked list */
            list = node; /* 'node' is now the first node  */
        } /* end if statement */
        else
        {
            /* new node must be inserted into the middle of the linked list */
            node->next = t->next;
            t->next = node;
        } /* end else statement */

    } /* end outer else statement */

    printf("This character was added to the linked list: %c\n",node->aCharacter);

} /* end function add */

void delete (char oneChar)
{
    /* declare local pointers to be used in traversing the linked list */
    CharacterNode *c, *t;

    c = list;
    t = list;

    while (c != NULL && oneChar != c->aCharacter)
    {
        t = c; /* set trailer pointer */
        c = c->next; /* advance current pointer to point to the next node */

    } /* end while loop */

    /* node to be deleted is the first node in the linked list */
    else if (t == list & c == list)
    {
        /* have 'list' piont to the second node in the linked list */
        list = t->next;
        printf("This character &c has been deleted from the list\n", oneChar);

        /* freee up memory for this node */
        free(t);
    } /* end else if statement */
    else
    {
        /* make the trailer pointer 't' next point to the current pointer 'c' next which will delete the current node from the linked list */
        t-> = c->next;
        printf("This character &c has been deleted from the list\n", oneChar);

        /* freee up memory for this node */
        free(c);

    } /* end else statement */

} /* end function delete */

CharacterNode * createNewNode(char oneChar)
{
    newNode = malloc(sizeof(CharacterNode));
    newNode->aCharacter = oneChar;
    newNode->next = NULL;
    return newNode;

} /* end function createNewNode */

void printList()
{
    CharacterNode *current;

    current = list;
    printf("\nHere is the current list:\n");

    /* traverse the linked list and print out each node's field as we visit it */
    while (current != NULL)
    {
        printf("\n%c", current->aCharacter);
        current = current->next;
    } /* end while loop */

    printf("\n");
} /* end function printList */
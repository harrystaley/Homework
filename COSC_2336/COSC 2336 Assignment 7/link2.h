#indef LINK2_H_INCLUDED
#define LINK2_H_INCLUDED

typedef struct list
{
    char aCharacter;
    struct list *next; /* points to the next node */
} CharacterNode;

void initList()
int validCharacter(char);
void add(CharacterNode *);
void delete(char);
CharacterNode * createNewNode(char);
void printList();

#endif // LINK2_H_INCLUDED
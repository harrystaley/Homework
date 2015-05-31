public class CharacterLIst {
    // declare instance field
    private CharacterNode list;

    private class CharacterNode
    {
        // declare for a single characters node
        public Character aCharacter;

        // declare the next pointer for that characters node
        public CharacterNode(Character newCharacter)
        {
            aCharacter = newCharacter;
            next = null;
        } //end constructor CharacterNode

        public string thisChar()
        {
            return aCharacter.thisChar2()
        } // end method thisChar
    } // end class CharacterNode

    public CharacterLIst()
    {
        // no linked list exists at this time
        list = null;
    } //end method CharacterLIst

    public void add(Character newCharacter)
    {
        CharacterNode c, t;
        CharacterNode = new CharacterNode(newCharacter);

        // if the linked list is empty this new node will be the first inode in the linked list
        if (list == null)
        {
            list = node;
            system.out.println("This character was added to the linked list: " + node.aCharacter);
        }
        else // linked list is not empty
        {
            c = list;
            t = list;
            while (c !=null && node.thisChar().compareTo(c.thisChar()) > 0)
            {
                t = c; // set trailer pointer
                c = c.next; // advance current pointer to point to the next node
            } // end while loop

            // if list and current pointer c are the same then insert the new node at the beginning of the linked list.
            if (list == c)
            {   // node.next opints to the beginning of the old linked list
                node.next = list;

                // node is now the new first node in the linked list
                list = node;
            }
            else
            {
                // new node must be inserted into the middle of the list
                node.next = t.next;
                t.next = node;

            } // end else

            system.out.println("This character was added to the linked list: " + node.aCharacter);
        } // end outer else
    } // end method add

    public void delete(String deleteCharacter)
    {
        CharacterNode c, t;

        c = list;
        t = list;

        while (c != null && deleteCharacter.compareTo(c.thisChar()) != 0)
        {
            // trailer t will be kept behind the current pointer c
            t = c;
            // advance the current pointer c to point to the next node in the linked list
            c = c.next;
        } // end while loop

        // character does not exist
        if (c == null)
        {
            JOptionPane.ShowMessageDialog(null, "Sorry but the character does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
        } // end if statement
        

        // the node to be deleted is the first node in the linked list
        else if (t == list && c == list)
        {
            list = t.next;
            system.out.println("This character " + deleteCharacter + " has been deleted from the linked list.");

        } // end else if statement
        // the character to be deleted was in the middle of the linked list
        else
        {
            t.next = c.next;
            system.out.println("This character " + deleteCharacter +" has been deleted from the linked list")
        } // end else
    } // end method delete

    public String buildLIst()
    {
        String result;
        CharacterNode C;

        c = list;
        result = "Here is your current list:\n\n";


        // travers ethe entire linked list and build up the ifno part of each node as a string when we visit each node
        while (c != null)
        {
            result = result + c.aCharacter + "\n";
            c = c.next;
        } // end while loop

        return result;
    } // end method buildList

} // end method CharacterLIst
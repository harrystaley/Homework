public class PeopleList 
{
    //declare 'list' to be a pointer that will point to the beginning of the linked list.
    private PersonNode list;

    private class PersonNode
    {
        //info part of a node
        public Person aPerson;
        //points to the next node in the linked list.
        public PersonNode next;

        public PersonNode(Person newPerson)
        {
            //crate info part of node
            aPerson = newPerson;

            //currently 'next' does not point to anything
            next = null;
        } //end constructor personNode
    }   //end class PersonNode

    public PeopleList()
    {
        //establish an empty linked list
        list = null;
    } //end constructor PeopleLIst

    public void add(Person newPerson)
    {
        //instantiate a new node, pass into the oject about that person
        personNode node = new personNode(newPerson);

        //create a pointer that will be able to point to any node in the linked list.
        PersonNode current;

        //if the linked list is empty this node will become the first node in the linked list.
        if (list == null)
        {
            list = node;
            System.out.println("This person was added to the linked list: " + node.aPerson);
        } //end if statement
        else
        { //linked list has at least one node in it
            //point to the beginning of the linked list to being traversing the linked list.
            current = list;
            //traverse the entire list untill you reach the end.
            while (current.next != null)
            {
                current = current.next;
            } //end while loop

            //make new node to be the last node in the linked list.
            current.next = node;
            System.out.println("This person was added to the linked list: " + node.aPerson);
        } //end else
    } //end add method

    public String printLIst()
    {
        String result;
        PersonNode current;

        result = "Here is your current linked list:\n\n";

        //assign 'current' to point to the begining of the list.
        current = list;

        while (current != null)
        {
            //build info about this node
            result = result + current.aPerson + "\n";
            //move on to the next node in the linked list
            current = current.next;
        } //end while
        //return the string for the entire list
        return result;
    } //end method printLIst
} //end class PeopleList
public class person {
    //declare instance fields to be used by program
    private String name;
    private int age;

    public Person(String newName, int newAge)
    {
        name = newName;
        age = newAge;
    } //end constructor person

    public String toString()
    {
        return "Name: " + name + ", Age: " + age;
    } //end class person

} //end class person
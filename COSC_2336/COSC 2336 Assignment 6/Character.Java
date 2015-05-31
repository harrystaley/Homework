public class Character {
    // declare instance field
    private String oneChar;

    public Character (String newChar)
    {
        oneChar = newChar;
    } // end constructor

    public String thisChar2()
    {
        return oneChar;
    } // end method thisChar2

    public String toString()
    {
        return "Character: " + oneChar;
    } // end method toString

} //end class Character
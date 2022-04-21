/**
 * Command class used to process both words for later use in other classes.
 */
public class Command
{
    //Attributes
    private String aCommandWord;
    private String aSecondWord;
    
    
    //Constructors
    /**
     * Builds the Object from "this" class.
     * @param String : First word of the Command component, String : Second word of the Command component.
     */
    public Command(final String pCommandWord, final String pSecondWord){
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }   //Command()
    
    
    //Get Methodes (Related to this Class)
    /**
     * Returns the "Command Word" of "this" Object (Command).
     * @param None.
     * @return String : The first word of the Command component.
     */
    public String getCommandWord(){
        return this.aCommandWord;
    }   //getCommandWord()
    
    /**
     * Returns the "Second Word" of "this" Object (Command).
     * @param None.
     * @return String : The second word of the Command component.
     */
    public String getSecondWord(){
        return this.aSecondWord;
    }   //getSecondWord()
    
    
    //Custom Methodes (Related to this Class)
    /**
     * Checks if the "Command Word" is "null".
     * @param None.
     * @return boolean : true is command is empty (null) else false.
     */
    public boolean isUnknown(){
        return (this.aCommandWord == null);
    }   //isUnknown()
    
    /**
     * Checks if the "Second Word" has a Second Word in it's component.
     * @param None.
     * @return boolean : true is the Command component has a second word else false.
     */
    public boolean hasSecondWord(){
        return (this.aSecondWord != null);
    }   //hasSecondWord()
} // Command

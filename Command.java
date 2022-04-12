/**
 * Command class used to process both words for later use in other classes.
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
     * Builds the Object from "this" class.
     */
    public Command(final String pCommandWord, final String pSecondWord){
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }   //Command()
    
    /**
     * Returns the "Command Word" of "this" Object (Command).
     */
    public String getCommandWord(){
        return this.aCommandWord;
    }   //getCommandWord()
    
    /**
     * Returns the "Second Word" of "this" Object (Command).
     */
    public String getSecondWord(){
        return this.aSecondWord;
    }   //getSecondWord()
    
    /**
     * Checks if the "Command Word" is "null".
     */
    public boolean isUnknown(){
        return (this.aCommandWord == null);
    }   //isUnknown()
    
    /**
     * Checks if the "Second Word" is "null".
     */
    public boolean hasSecondWord(){
        return (this.aSecondWord != null);
    }   //hasSecondWord()
} // Command

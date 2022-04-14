import java.util.HashMap;
import java.util.Set;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2019.09.25
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    private HashMap<String, String> aValidCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<String, String>();
        
        this.aValidCommands.put("go","Moves the player from room to room, using north, east, south, west, above and below.");
        this.aValidCommands.put("help","Gives the player a list of all available commands.");
        this.aValidCommands.put("quit","Ends the game instance.");
        this.aValidCommands.put("look","Gives the player a description of the room, it's viable exits and items inside the room.");
        this.aValidCommands.put("use","Makes the player use an item.");
        this.aValidCommands.put("back","Makes the player return to the previous room they were in until there is no room to return to. You can add a number after the command to go back multiple times.");
        this.aValidCommands.put("merp","Easter Egg ig :D");
    } // CommandWords()

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand( final String pString )
    {
        Set<String> keys = this.aValidCommands.keySet(); //Get all keys from the HashMap
        for (String vCommand : keys){ //"for" each key of the HashMap
            if (vCommand.equals(pString.toLowerCase())){
                return true;
            }
        } // for
        // if we get here, the string was not found in the commands :
        return false;
    } // isCommand()
    
    /**
     * Returns a list of all available commands. (String)
     */
    public HashMap getCommandHashMap()
    {
        return this.aValidCommands;
    }
    
    /**
     * Returns information on the command put in parameters.
     */
    public String getCommandInfo(final String pCommandIndexName){
        return this.aValidCommands.get(pCommandIndexName);
    }
} // CommandWords

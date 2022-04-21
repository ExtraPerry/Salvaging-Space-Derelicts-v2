import java.util.HashMap;
import java.util.Set;

/**
 * This class is part of the "Salvaging Space Derelicts" application. 
 * Based off of "World of Zuul" which is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game and a description of the commands.
 * It is used to recognise commands as they are typed in and get information about the command.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau [Modified by P.Gervais]
 * @version 2008.03.30 + 2019.09.25 [Modified]
 */
public class CommandWords
{
    //Attributes.
    private HashMap<String, String> aValidCommands;

    
    //Constructors.
    /**
     * Constructor - initialise the command words.
     * @param None.
     */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<String, String>();
        
        this.addValidCommand("go","Moves the player from room to room, using north, east, south, west, above and below.");
        this.addValidCommand("help","Gives the player a list of all available commands.");
        this.addValidCommand("quit","Ends the game instance.");
        this.addValidCommand("look","Gives the player a description of the room, it's viable exits and items inside the room.");
        this.addValidCommand("use","Makes the player use an item.");
        this.addValidCommand("back","Makes the player return to the previous room they were in until there is no room to return to. You can add a number after the command to go back multiple times.");
        this.addValidCommand("take","Take an item from the room the player is in and put it in the player's inventory.");
        this.addValidCommand("drop","Drop an item from the player's and put's in in the room's inventory the player is currently in.");
        this.addValidCommand("inventory","Gives out a detailed list of specified inventory. [Player or Room]");
        this.addValidCommand("test","Used to test various components of the entire game and make sure they all work properly.");
        this.addValidCommand("merp","Easter Egg ig :D");
    } // CommandWords()

    
    //Methode related to the constructor. (Will decide what commands are added in the permissions list and their description.
    /**
     * Used to add a command to the permitted list and give it a description.
     * @param String : Word that will be the command, String : Description of the command that is added.
     * @return void.
     */
    private void addValidCommand(final String pWord, final String pDescription){
        this.aValidCommands.put(pWord, pDescription);
    }
    
    
    //Get Methode (Related to this Class).
    /**
     * Returns information on the command put in parameters.
     * @param String : The command in question.
     * @return String : Description of the command.
     */
    public String getCommandInfo(final String pCommandIndexName){
        return this.aValidCommands.get(pCommandIndexName);
    }
    
    /**
     * Returns a list of all available commands. (String)
     * @param None.
     * @return HashMap : Full HashMap of all the commands and their descripti.
     */
    public HashMap getCommandHashMap()
    {
        return this.aValidCommands;
    }
    
    
    //Custom Methode (Related to this Class).
    /**
     * Check whether a given String is a valid command word. 
     * @param String.
     * @return boolean : true if a given string is a valid command, false if it isn't.
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
} // CommandWords

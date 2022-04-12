import java.util.HashMap;
import java.util.Set;

/**
 * Room Class used to instanciate different rooms.
 */
public class Room
{
    private String aDescription; //The description of the room (a.k.a it's name used when returning information to the player)
    private HashMap<String, Room> aExits; //The rooms exits and thus the rooms it'll link to
    private String aImageURL; //Is meant to store the Image that'll represent the Room's file location.
    
    /**
     * Builds the Object from "this" class. 
     * (Only taking in the description as the "Exits" must be "null" at first, but will also not set an Image for the Room).
     */
    public Room(final String pDescription, final String pImageURL){
        this.aDescription = pDescription; //Set description
        this.aExits = new HashMap<String, Room>(); //init the HashMap
        this.aImageURL = pImageURL; //Sets the ImageURL
    }   //Room()
    
    /**
     * Returns the Description of "this" Object (Room).
     */
    public String getDescription(){
        return this.aDescription;
    }   //getDescription()
    
    /**
     * Used to set the Exits of "this" Object (Room).
     */
    public void setExit(final String pDirection, final Room pRoom){
        this.aExits.put(pDirection, pRoom); //Sets the rooms exit based on direction and the room it should link to
    }   //setExits()
    
    /**
     * Returns the wanted exit using a string in parameters.
     */
    public Room getExit(final String pDirection){
        return this.aExits.get(pDirection);
    }
    
    /**
     * Returns available exits of the room. (String)
     */
    public String getExitString(){
        String vOutput = ""; //Init String
        
        Set<String> keys = this.aExits.keySet(); //Get all keys from the HashMap
        for (String vExit : keys){ //"for" each key of the HashMap
            if (vOutput != ""){ //If the String is not empty then add a comma for the next word (i.e => word1 + " ," + word_etc)
                vOutput += ", "; //Adds the comma and spacing to the String
            }
            vOutput += vExit.substring(0,1).toUpperCase() + vExit.substring(1).toLowerCase(); //Adds the Exit direction to the String (formats it so that the first letter is upper case and the rest is lower case)
        }
        
        return vOutput + "."; //Returns the String
    }   //getExit()

    /**
     * Returns a long description of the Room.
     */
    public String getLongDescription(){
        return "You are at : " + this.getDescription() + " | Viable paths are : " + this.getExitString();
    }
    
    /**
     * Return the File Path of the Rooms Image.
     */
    public String getImageFilePath(){
        return this.aImageURL;
    }
} // Room

import java.util.HashMap;
import java.util.Set;

/**
 * The Room Class is used to create an instance (Object) of all rooms in the game.
 * It is used to store & manage all related information about a room.
 * 
 * @author Gervaise Pierre
 * @version Main Branch
 */
public class Room
{
    //Attributes. 
    private String aName;
    private HashMap<String, Room> aExits;
    private Inventory aInventory;
    private String aImageUrlFilePath;
    private Room aPreviousRoom;
    
    
    //Constructors.
    /**
     * Set custom Name and Image. Exits is empty by default. Inventory is empty by default. Previous room is null by default.
     * @param String : Name of the room, String : Image URL path meant to represent the room (can be set to null if there are no images for the room).
    */
    public Room(final String pName, final String pImageUrlFilePath){
        this.setName(pName); 
        this.aExits = new HashMap<String, Room>(); //init the HashMap.
        this.aInventory = new Inventory(); 
        this.setImageUrlFilePath(pImageUrlFilePath); 
        this.setPreviousRoom(null);
    }   //Room()
    
    
    //Set Methodes. (Related to this Class)
    /**
     * Used to change the name of the room.
     * @param String : Name of the room.
     * @return void.
     */
    private void setName(final String pName){
        this.aName = pName;
    }   //setName()
    
    /**
     * Used to set an Exit of this room.
     * @param String : Direction in which the exit will be, Room : The room in which the exit will lead.
     * @return void.
     */
    public void setExit(final String pDirection, final Room pRoom){
        this.aExits.put(pDirection, pRoom); 
    }   //setExits()
    
    /**
     * Used to change the image url file path of the room.
     * @param String : Image URL path meant to represent the room (can be set to null if there are no images for the room).
     * @return void.
     */
    private void setImageUrlFilePath(final String pImageUrlFilePath){
        this.aImageUrlFilePath = pImageUrlFilePath;
    }   //setImageURL()
    
    /**
     * Used to set the previous room this room was entered from.
     * @param Room : Room from which the player came from while going into this room.
     * @return void.
     */
    public void setPreviousRoom(Room pPreviousRoom){
        this.aPreviousRoom = pPreviousRoom;
    }   //setPreviousRoom()
    
    
    //Get Methodes. (Related to this Class)
    /**
     * Used to fetch the room's name.
     * @param None.
     * @return String : The name of the room.
     */
    public String getName(){
        return this.aName;
    }   //getDescription()
    
    /**
     * Used to fetch the next room based on the room's exit.
     * @param String : Direction of the exit.
     * @return Room : Room to which the exit leads to (null means the specified direction has no exit).
     */
    public Room getExit(final String pDirection){
        return this.aExits.get(pDirection);
    }   //getExit()
    
    /**
     * Used to fetch the room's inventory.
     * @param None.
     * @return Inventory : Inventory of the room.
     */
    private Inventory getInventory(){
        return this.aInventory;
    }   //getInventory()
    
    /**
     * Used to fetch the room's image file path representing this room.
     * @param None.
     * @return String : Image URL path meant to represent the room (if null then there are no images for the room)..
     */
    public String getImageFilePath(){
        return this.aImageUrlFilePath;
    }
    
    /**
     * Used to fetch the previous room this room was entered from.
     * @param None.
     * @return Room : The room from which the player came from while entering this room.
     */
    public Room getPreviousRoom(){
        return this.aPreviousRoom;
    }   //getPreviousRoom()
    
    
    //Custom Methodes. (Related to this Class)
    /**
     * Used to create a long description of the room.
     * @param None.
     * @return String : Description of this room (Name | Viable exit(s) | Inventory Description).
     */
    public String getDescription(){
        return "You are at : " + this.getName() + " | " + this.getViableExitDescription() + "\n" + this.getInventoryDescription();
    }   //getLongDescription()
    
    /**
     * Used to create a String describing all viable exits of the room.
     * @param None.
     * @return String : All viable exits that the room has.
     */
    private String getViableExitDescription(){
        String vOutput = ""; //Init String
        Set<String> keys = this.aExits.keySet(); //Get all keys from the HashMap
        for (String vExit : keys){ //"for" each key of the HashMap
            if (vOutput != ""){ //If the String is not empty then add a comma for the next word (i.e => word1 + " ," + word_etc)
                vOutput += ", "; //Adds the comma and spacing to the String
            }
            vOutput += vExit.substring(0,1).toUpperCase() + vExit.substring(1).toLowerCase(); //Adds the Exit direction to the String (formats it so that the first letter is upper case and the rest is lower case)
        }
        return "Viable paths are : " + vOutput + "."; //Returns the String
    }   //getExitString()
    
    
    //Custom Methodes. (Related to Sub-Class ==> aInventory)
    /**
     * Used to fetch an Item (Object) from the player's inventory.
     * @param String : Name of the item.
     * @return Item : Specified item.
     */
    public Item getItemFromInventory(final String pItemName){
        return this.aInventory.getItem(pItemName);
    }   //getItemFromInventory()
    
    /**
     * Used to check if the room inventory has specified item in it.
     * @param String : Name of the item.
     * @return boolean : true if room's inventory has the specified item else false.
     */
    public boolean hasItemInInventory(final String pItemName){
        return this.getInventory().hasItem(pItemName);
    }   //hasItemInInventory()
    
    /**
     * Used to add an item to the player's inventory.
     * @param Item : Item that should be added to the room's inventory.
     * @return void.
     */
    public void addItemToInventory(final Item pItem){
        this.aInventory.addItem(pItem);
    }   //addItemToInventory()
    
    /**
     * Used to remove an item from the player's inventory.
     * @param Item : Item that should be removed from the room's inventory.
     * @return void.
     */
    public void removeItemFromInventory(final Item pItem){
        this.aInventory.removeItem(pItem);
    }   //removeItemFromInventory()
    
    /**
     * Used to create a String describing all items inside of the room's inventory.
     * Also adds total price value of room's inventory.
     * @param None.
     * @return String : Description of the room's inventory.
     */
    private String getInventoryDescription(){
        String vList = aInventory.toString();
        if(vList != ""){
            String vOutput = "Item in Room : " + vList + ".";
            if(vList.contains(",")){
                return "" + vOutput.substring(0,4) + "s" + vOutput.substring(4);
            }else{
                return vOutput;
            }
        }else{
            return "There are no Items inside this Room.";
        }
    }   //getInventoryItemList()
    
    /**
     * returns full listing description of all items inside the player's inventory with great detail.
     * @param None.
     * @return String : Detailed list of all items in the room's inventory.
     */
    public String getInventoryListDescription(){
        return this.aInventory.getInventoryListDescription();
    }   //getInventoryListDescription()
} // Room

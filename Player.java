/**
 * The Player Class is used to create an instance (Object) of the player.
 * It is used to store & manage all related information about the player.
 * 
 * @author Gervaise Pierre
 * @version Main Branch
 */
public class Player
{
    //Attributes.
    private String aName; //The player's name used to indentify them.
    private Room aCurrentRoom; //The room the player is currently in.
    private Inventory aInventory; //The players Inventory;
    private int aMaxVolume; //The max volume the player's inventory will have.
    private int aOxygenLevel; //The oxygen level of the player that determines how much time he has left.
    
    
    //Constructors.
    /**
     * Set custom Name and starting Room. Inventory is empty by default. MaxVolume is 1000L. OxygenLevel is 100%.
     */
    public Player(final String pName, final Room pStartingCurrentRoom)
    {
        this.setName(pName);
        this.setCurrentRoom(pStartingCurrentRoom);
        this.aInventory = new Inventory();
        this.setMaxVolume(1000);
        this.setOxygenLevel(100);
    }   //Player()
    
    
    //Set Methodes. (Related to this Class)
    /**
     * Used to change the players name.
     */
    private void setName(final String pName){
        this.aName = pName;
    }   //setName()
    
    /**
     * Used to change the player's current room.
     */
    private void setCurrentRoom(final Room pCurrentRoom){
        this.aCurrentRoom = pCurrentRoom;
    }   //setCurrentRoom()
    
    /**
     * Used to change the player's max volume (inventory capacity).
     */
    private void setMaxVolume(final int pMaxVolume){
        this.aMaxVolume = pMaxVolume;
    }   //setMaxVolume()
    
    /**
     * Used to change the player's oxygen level.
     */
    private void setOxygenLevel(final int pOxygenLevel){
        this.aOxygenLevel = pOxygenLevel;
    }   //setOxygenLevel()
    
    
    //Get Methodes. (Related to this Class)
    /**
     * Used to fetch the player's name.
     */
    public String getName(){
        return this.aName;
    }   //getName()
    
    /**
     * Used to fetch the player's current room.
     */
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }   //getCurrentRoom()
    
    /**
     * Used to fetch the player's inventory.
     */
    private Inventory getInventory(){
        return this.aInventory;
    }   //getInventory()
    
    /**
     * Used to fetch the player's max volume (inventory capacity).
     */
    public int getMaxVolume(){
        return this.aMaxVolume;
    }   //getMaxVolume()
    
    /**
     * Used to fetch the player's oxygen level.
     */
    public int getOxygenLevel(){
        return this.aOxygenLevel;
    }   //getOxygenLevel()
    
    
    //Custom Methodes. (Related to this Class)
    /**
     * Checks if the item put in parameters will fit in the player's inventory.
     */
    public boolean hasSpaceInInventoryFor(final Item pItem){
        return (this.getInventory().getTotalVolume() + pItem.getVolume()) <= this.getMaxVolume();
    }   //hasSpaceInInventory()
    
    /**
     * Used to move the player's current room.
     */
    public void moveToNextRoom(final String pDirection){
        if(this.hasNextRoom(pDirection)){
            Room vNextRoom = this.getNextRoom(pDirection);
            vNextRoom.setPreviousRoom(this.getCurrentRoom());
            this.setCurrentRoom(vNextRoom);
        }
    }   //setCurrentRoom()
    
    /**
     * Used to move the player to the room they came from based on their current room.
     */
    public void moveToPreviousRoom(final int pStack){
        for(int i = 0 ; i < pStack ; i++){
            if(this.hasPreviousRoom()){
                this.setCurrentRoom(this.getPreviousRoom());
            }else{
                break;
            }
        }
    }   //moveToPreviousRoom()
    
    
    //Custom Methodes. (Related to Sub-Class ==> aCurrentRoom)
    /**
     * Used to fetch the next room of the current room the player is in based on direction.
     */
    private Room getNextRoom(final String pDirection){
        return this.getCurrentRoom().getExit(pDirection);
    }
    
    /**
     * Used to check if there is a next room based on direction from current room of the player.
     */
    public boolean hasNextRoom(final String pDirection){
        return this.getNextRoom(pDirection) != null;
    }
    
    /**
     * Used to check if the current room has a previous room.
     */
    public boolean hasPreviousRoom(){
        return this.getPreviousRoom() != null;
    }   //hasPreviousRoom()
    
    /**
     * Used to fetch the previous room the player was in based on the current room.
     */
    private Room getPreviousRoom(){
        return this.getCurrentRoom().getPreviousRoom();
    }   //getPreviousRoom()
    
    /**
     * Used to Fetch the description of the current room the player is in.
     */
    public String getCurrentRoomDescription(){
        return this.getCurrentRoom().getDescription();
    }
    
    
    //Custom Methodes. (Related to Sub-Class ==> aInventory)
    /**
     * Used to fetch an Item (Object) from the player's inventory.
     */
    public Item getItemFromInventory(final String pItemName){
        return this.getInventory().getItem(pItemName);
    }   //getItemFromInventory()
    
    /**
     * Used to check if player's inventory has specified item in it.
     */
    public boolean hasItemInInventory(final String pItemName){
        return this.getInventory().hasItem(pItemName);
    }   //hasItemInInventory()
    
    /**
     * Used to add an item to the player's inventory.
     */
    public void addItemToInventory(final Item pItem){
        if(this.hasSpaceInInventoryFor(pItem)){
            this.aInventory.addItem(pItem);
        }
    }   //addItemToInventory()
    
    /**
     * Used to remove an item from the player's inventory.
     */
    public void removeItemFromInventory(final Item pItem){
        this.aInventory.removeItem(pItem);
    }   //removeItemFromInventory()
    
    /**
     * Used to fetch the total price of all the items in the player's inventory.
     */
    public int getInventoryTotalPrice(){
        return this.aInventory.getTotalPrice();
    }   //getInventoryTotalPrice()
    
    /**
     * Used to get a description of what is inside the player's inventory. ("ItemList + " : " + TotalPrice").
     */
    public String getInventoryString(){
        return this.aInventory.toString();
    }
    
    /**
     * returns full listing description of all items inside the player's inventory with great detail.
     */
    public String getInventoryListDescription(){
        return this.aInventory.getInventoryListDescription();
    }   //getInventoryListDescription()
}

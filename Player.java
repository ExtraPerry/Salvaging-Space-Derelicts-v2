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
     * @param String : Player name, Room : Starting Room.
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
     * @param String : Player name.
     * @return void.
     */
    private void setName(final String pName){
        this.aName = pName;
    }   //setName()
    
    /**
     * Used to change the player's current room.
     * @param Room : Room in which the player is now affected to.
     * @return void.
     */
    private void setCurrentRoom(final Room pCurrentRoom){
        this.aCurrentRoom = pCurrentRoom;
    }   //setCurrentRoom()
    
    /**
     * Used to change the player's max volume (inventory capacity).
     * @param int : Max volume that the player can carry.
     * @return void.
     */
    private void setMaxVolume(final int pMaxVolume){
        this.aMaxVolume = pMaxVolume;
    }   //setMaxVolume()
    
    /**
     * Used to change the player's oxygen level.
     * @param int : Oxygen level of the player.
     * @return void.
     */
    private void setOxygenLevel(final int pOxygenLevel){
        this.aOxygenLevel = pOxygenLevel;
    }   //setOxygenLevel()
    
    
    //Get Methodes. (Related to this Class)
    /**
     * Used to fetch the player's name.
     * @param None.
     * @return String : Name of the player.
     */
    public String getName(){
        return this.aName;
    }   //getName()
    
    /**
     * Used to fetch the player's current room.
     * @param None.
     * @return Room : Room where the player is currently located.
     */
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }   //getCurrentRoom()
    
    /**
     * Used to fetch the player's inventory.
     * @param None.
     * @return Inventory : Inventory of the player.
     */
    private Inventory getInventory(){
        return this.aInventory;
    }   //getInventory()
    
    /**
     * Used to fetch the player's max volume (inventory capacity).
     * @param None.
     * @return int : Max capacity that the player can carry.
     */
    public int getMaxVolume(){
        return this.aMaxVolume;
    }   //getMaxVolume()
    
    /**
     * Used to fetch the player's oxygen level.
     * @param None.
     * @return int : Oxygen level of the player.
     */
    public int getOxygenLevel(){
        return this.aOxygenLevel;
    }   //getOxygenLevel()
    
    
    //Custom Methodes. (Related to this Class)
    /**
     * Checks if the item put in parameters will fit in the player's inventory.
     * @param Item : Specified item.
     * @return : true if player has item in inventory else false.
     */
    public boolean hasSpaceInInventoryFor(final Item pItem){
        return (this.getInventory().getTotalVolume() + pItem.getVolume()) <= this.getMaxVolume();
    }   //hasSpaceInInventory()
    
    /**
     * Used to move the player's current room.
     * @param String : Direction in which the player should move.
     * @return void.
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
     * @param int : Amount of times the player should move back the way they came.
     * @return void.
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
     * @param String : Direction in which you wish to get the next room based on the players current room.
     * @return Room : Room from the specified direction (null if there is no exit).
     */
    private Room getNextRoom(final String pDirection){
        return this.getCurrentRoom().getExit(pDirection);
    }
    
    /**
     * Used to check if there is a next room based on direction from current room of the player.
     * @param String : Direction in which we want to check is there is another room.
     * @return boolean : true if there is a room in specified direction else false.
     */
    public boolean hasNextRoom(final String pDirection){
        return this.getNextRoom(pDirection) != null;
    }
    
    /**
     * Used to check if the current room has a previous room.
     * @param None.
     * @return boolean : true if there is a previous room where the player came from else false.
     */
    public boolean hasPreviousRoom(){
        return this.getPreviousRoom() != null;
    }   //hasPreviousRoom()
    
    /**
     * Used to fetch the previous room the player was in based on the current room.
     * @param None.
     * @return Room : Room from which the player came into the current room.
     */
    private Room getPreviousRoom(){
        return this.getCurrentRoom().getPreviousRoom();
    }   //getPreviousRoom()
    
    /**
     * Used to Fetch the description of the current room the player is in.
     * @param None.
     * @return String : Description of the current room.
     */
    public String getCurrentRoomDescription(){
        return this.getCurrentRoom().getDescription();
    }
    
    
    //Custom Methodes. (Related to Sub-Class ==> aInventory)
    /**
     * Used to fetch an Item (Object) from the player's inventory.
     * @param String : Specified name of the item.
     * @return Item : Item from players inventory by specified name.
     */
    public Item getItemFromInventory(final String pItemName){
        return this.getInventory().getItem(pItemName);
    }   //getItemFromInventory()
    
    /**
     * Used to check if player's inventory has specified item in it.
     * @param String : Specified name of the item.
     * @return boolean : true if player's inventory has specified item else false.
     */
    public boolean hasItemInInventory(final String pItemName){
        return this.getInventory().hasItem(pItemName);
    }   //hasItemInInventory()
    
    /**
     * Used to add an item to the player's inventory.
     * @param Item : Item that should be added to the player's inventory.
     * @return void.
     */
    public void addItemToInventory(final Item pItem){
        if(this.hasSpaceInInventoryFor(pItem)){
            this.aInventory.addItem(pItem);
        }
    }   //addItemToInventory()
    
    /**
     * Used to remove an item from the player's inventory.
     * @param Item : Item that should be removed from the player's inventory.
     * @return void.
     */
    public void removeItemFromInventory(final Item pItem){
        this.aInventory.removeItem(pItem);
    }   //removeItemFromInventory()
    
    /**
     * Used to fetch the total price of all the items in the player's inventory.
     * @param None.
     * @return int : Total price of all items inside of the player inventory
     */
    public int getInventoryTotalPrice(){
        return this.aInventory.getTotalPrice();
    }   //getInventoryTotalPrice()
    
    /**
     * Used to get a description of what is inside the player's inventory. ("ItemList + " : " + TotalPrice").
     * @param None.
     * @return String : list of all items in the player's inventory.
     */
    public String getInventoryString(){
        return this.aInventory.toString();
    }
    
    /**
     * returns full listing description of all items inside the player's inventory with great detail.
     * @param None.
     * @return String : Detailed list of all items inside the player's inventory.
     */
    public String getInventoryListDescription(){
        return this.aInventory.getInventoryListDescription();
    }   //getInventoryListDescription()
}

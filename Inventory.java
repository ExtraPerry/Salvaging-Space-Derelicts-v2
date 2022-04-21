import java.util.ArrayList;

/**
 * The Inventory Class is used to create an instance (Object) of an inventory.
 * It is used to store multiple Item Objects together and their total price.
 * 
 * @author Gervaise Pierre
 * @version Main Branch
 */
public class Inventory
{
    //Attributes
    private ArrayList<Item> aItemList;
    private int aTotalPrice;
    private int aTotalVolume;
    
    
    //Constructors.
    /**
     * Creates an Inventory Object. Item list is empty. Total price is set to 0. Total volume is set to 0.
     * @param None.
     */
    public Inventory()
    {
        this.aItemList = new ArrayList<Item>();
        this.setTotalPrice(0);
        this.setTotalVolume(0);
    }   //Inventory()
    
    
    //Set Methodes. (Related to this Class)
    /**
     * Used to change the total price of the inventory.
     * @param int : Inventory's total Price of all Items contained inside of it.
     * @return void.
     */
    private void setTotalPrice(final int pTotalPrice){
        this.aTotalPrice = pTotalPrice;
    }   //setTotalPrice()
    
    /**
     * Used to change the total volume of the inventory.
     * @param int : Inventory's total Volume of all Items contained inside of it.
     * @return void.
     */
    private void setTotalVolume(final int pTotalVolume){
        this.aTotalVolume = pTotalVolume;
    }   //setTotalVolume()
    
    
    //Get Methodes. (Related to this Class)
    /**
     * Used to fetch the total price of the inventory.
     * @param None.
     * @return int : Inventory's total Price of all Items contained inside of it.
     */
    public int getTotalPrice(){
        return this.aTotalPrice;
    }   //getTotalPrice()
    
    /**
     * Used to fetch the total volume of the inventory.
     * @param None.
     * @return int : Inventory's total Volume of all Items contained inside of it.
     */
    public int getTotalVolume(){
        return this.aTotalVolume;
    }   //getTotalVolume()
    
    /**
     * Used to fetch an Item from the inventory.
     * @param String : Item's Name.
     * @return Item : Item that is contained inside of the inventory.
     */
    public Item getItem(final String pItemName){
        for(Item vElement : this.aItemList){
            if(vElement.getName().toLowerCase().equals(pItemName.toLowerCase())){
                System.out.println("True");
                return vElement;
            }
        }
        return null;
    }   //getItem()
    
    
    //Custom Methodes. (Related to this Class)
    /**
     * Used to check if the inventory has Item in the inventory.
     * @param String : Item's Name.
     * @return boolean : True if item is inside of the inventory else false.
     */
    public boolean hasItem(final String pItemName){
        return this.getItem(pItemName) != null;
    }   //hasItem()
    
    /**
     * Used to add an item to the inventory.
     * @param Item : Item that will be added to the inventory.
     * @return void.
     */
    public void addItem(final Item pItem){
        this.aItemList.add(pItem);
        this.setTotalPrice(this.getTotalPrice() + pItem.getPrice());
        this.setTotalVolume(this.getTotalVolume() + pItem.getVolume());
    }   //addItem()
    
    /**
     * Used to remove an item from the inventory.
     * @param Item : Item that will be removed from the inventory..
     * @return void.
     */
    public void removeItem(final Item pItem){
        String pItemName = pItem.getName();
        if(this.hasItem(pItemName)){
            this.setTotalPrice(this.getTotalPrice() - getItem(pItemName).getPrice());
            this.setTotalVolume(this.getTotalVolume() - getItem(pItemName).getVolume());
            this.aItemList.remove(pItem);
        }
    }   //removeItem()
    
    /**
     * Returns a simple list of all the items names in the inventory for use of Display.
     * @param None.
     * @return String : List of all items inside of the inventory.
     */
    private String getItemListString(){
        String vOutput = "";
        for(Item vElement : this.aItemList){
            if(vOutput != ""){
                vOutput += ", ";
            }
            vOutput += vElement.getName();
        }
        return vOutput;
    }   //getItemListString()
    
    /**
     * Returns a table of all items inside the inventory.
     * @param None.
     * @return String[] : List of all items inside of the inventory as a Table.
     */
    private String[] getItemListTable(){
        return this.getItemListString().split(", ");
    }   //getItemListTable()
    
    /**
     * Returns a detailed listing of all items inside of the inventory.
     * @param None.
     * @return String : Detailed list of all items inside of the inventory.
     */
    public String getInventoryListDescription(){
        if(this.aItemList.isEmpty()){
            return "- Inventory is Empty.";
        }else{
            String vOutput = "";
            for(Item vElement : this.aItemList){
                if(vOutput != ""){
                    vOutput += "\n";
                }
                int vPrice = vElement.getPrice();
                String vCred = "";
                if(vPrice == 1){
                    vCred = "credit";
                }else{
                    vCred = "credits";
                }
                vOutput += "- " + vElement.getName() + " : " + vPrice + " " + vCred + " | " + vElement.getVolume() + " L.";
            }
            return vOutput;
        }
    }   //getInventoryListDescription()
    
    
    //Overrides. (Related to this Class)
    /**
     * Custom override of .toString(). ("ItemList + " : " + TotalPrice").
     * @param None.
     * @return String : Basic information on the inventory.
     */
    @Override public String toString()
    {
        if(this.getItemListString() != ""){
            String vEndPart = "";
            if(this.getTotalPrice() == 1){
                vEndPart = " credit";
            }else{
                vEndPart = " credits";
            }
            return "" + this.getItemListString() + " [" + this.getTotalPrice() + vEndPart + "]";
        }else{
            return "";
        }
    }
}

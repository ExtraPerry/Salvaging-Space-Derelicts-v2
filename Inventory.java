import java.util.ArrayList;

/**
 * The Inventory Class is used to create an instance (Object) of an inventory.
 * It is used to store multiple Item Objects together and their total price.
 */
public class Inventory
{
    //Attributes
    private ArrayList<Item> aItemList;
    private int aTotalPrice;
    
    
    //Constructors.
    /**
     * Creates an Inventory Object. Item list is empty. Total price is set to 0.
     */
    public Inventory()
    {
        this.aItemList = new ArrayList<Item>();
        this.setTotalPrice(0);
    }   //Inventory()
    
    
    //Set Methodes. (Related to this Class)
    /**
     * Used to change the total price of the inventory.
     */
    private void setTotalPrice(final int pTotalPrice){
        this.aTotalPrice = 0;
    }   //setTotalPrice()
    
    
    //Get Methodes. (Related to this Class)
    /**
     * Used to fetch the total price of the inventory.
     */
    public int getTotalPrice(){
        return this.aTotalPrice;
    }   //getTotalPrice()
    
    /**
     * Used to fetch an Item from the inventory.
     */
    public Item getItem(final String pItemName){
        for(Item vElement : this.aItemList){
            if(vElement.getName() == pItemName){
                return vElement;
            }
        }
        return null;
    }   //getItem()
    
    
    //Custom Methodes. (Related to this Class)
    /**
     * Used to check if the inventory has Item in the inventory.
     */
    private boolean hasItem(final String pItemName){
        return this.getItem(pItemName) != null;
    }   //hasItem()
    
    /**
     * Used to add an item to the inventory.
     */
    public void addItem(final Item pItem){
        this.aItemList.add(pItem);
        this.setTotalPrice(this.getTotalPrice() + pItem.getPrice());
    }   //addItem()
    
    /**
     * Used to remove an item from the inventory.
     */
    public void removeItem(final String pItemName){
        if(this.hasItem(pItemName)){
            this.setTotalPrice(this.getTotalPrice() - getItem(pItemName).getPrice());
        }
        this.aItemList.remove(pItemName);
    }   //removeItem()
    
    /**
     * Returns a simple list of all the items names in the inventory for use of Display.
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
    
    
    //Overrides. (Related to this Class)
    /**
     * Custom override of .toString(). ("ItemList + " : " + TotalPrice").
     */
    @Override public String toString()
    {
        String vEndPart = "";
        if(this.getTotalPrice() == 1){
            vEndPart = " credit";
        }else{
            vEndPart = " credits";
        }
        return "" + this.getItemListString() + " : " + this.aTotalPrice + vEndPart;
    }
}

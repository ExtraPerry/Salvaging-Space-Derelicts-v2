import java.util.ArrayList;

/**
 * Write a description of class Inventory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Inventory
{
    private ArrayList<Item> aItemList;
    private int aTotalPrice;
    
    public Inventory()
    {
        this.aItemList = new ArrayList<Item>();
        this.aTotalPrice = 0;
    }
    
    public Item getItem(final String pItemName){
        for(Item vElement : this.aItemList){
            if(vElement.getName() == pItemName){
                return vElement;
            }
        }
        return null;
    }
    
    public boolean hasItem(final String pItemName){
        return this.getItem(pItemName) != null;
    }
    
    public void addItem(final Item pItem){
        this.aItemList.add(pItem);
        this.aTotalPrice += pItem.getPrice();
    }
    
    public void removeItem(final String pItemName){
        if(this.getItem(pItemName) != null){
            this.aTotalPrice -= this.getItem(pItemName).getPrice();
        }
        this.aItemList.remove(pItemName);
    }
    
    @Override public String toString()
    {
        return "" + this.aItemList + " : " + this.aTotalPrice + "";
    }
    
    /**
     * Returns a simple list of all the Items Names in the inventory for use of Display.
     */
    public String getItemListString(){
        String vOutput = "";
        for(Item vElement : this.aItemList){
            if(vOutput != ""){
                vOutput += ", ";
            }
            vOutput += vElement.getName();
        }
        return vOutput;
    }
}

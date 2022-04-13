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
    
    public void addItem(final String pItemName, final int pItemPrice){
        Item vItem = new Item(pItemName, pItemPrice);
        this.aItemList.add(vItem);
        this.aTotalPrice += pItemPrice;
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
}

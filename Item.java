
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    private String aName;
    private int aPrice;
    
    public Item(final String pName, final int pPrice)
    {
        this.aName = pName;
        this.aPrice = pPrice;
    }
    
    public String getName(){
        return this.aName;
    }
    
    public int getPrice(){
        return this.aPrice;
    }
}

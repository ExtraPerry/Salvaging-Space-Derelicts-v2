
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
    private int aVolume;
    private String aItemDescription;
    
    
    public Item(final String pName, final int pPrice, final int pVolume, final String pItemDescription)
    {
        this.aName = pName;
        this.aPrice = pPrice;
        this.aItemDescription = pItemDescription;
        this.aVolume = pVolume;
    }
    
    public String getName(){
        return this.aName;
    }
    
    public int getPrice(){
        return this.aPrice;
    }
    
    public int getVolume(){
        return this.aVolume;
    }
    
    public String getItemDescription(){
        return this.aItemDescription;
    }
    
    public String getLongItemDescription(){
        String vOutput = this.getItemDescription() + "\n" + "Price: " + this.getPrice();
        if(this.aPrice == 1){
            vOutput += " credit";
        }else{
            vOutput += " credits";
        }
        vOutput += ", Volume: " + this.getVolume() + " L.";
        return vOutput;
    }
}

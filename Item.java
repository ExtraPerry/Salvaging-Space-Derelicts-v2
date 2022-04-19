
/**
 * The Item Class is used to create an instance (Object) of an item.
 * It is used to store information about an item such as it's name, price, volume and a description of it.
 *
 * @author Gervaise Pierre
 * @version Main Branch
 */
public class Item
{
    //Attributes
    private String aName;
    private int aPrice;
    private int aVolume;
    private String aItemDescription;
    
    
    //Constructors
    public Item(final String pName, final int pPrice, final int pVolume, final String pItemDescription)
    {
        this.aName = pName;
        this.aPrice = pPrice;
        this.aItemDescription = pItemDescription;
        this.aVolume = pVolume;
    }
    
    
    //Get Methodes. (Related to this Class)
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
    
    
    //Custom Methodes. (Related to this Class)
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

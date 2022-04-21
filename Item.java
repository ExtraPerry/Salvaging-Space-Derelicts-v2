
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
    /**
     * Used to create an Item for the game.
     * @param String : Name, int : Price, int : Volume, String : Description.
     */
    public Item(final String pName, final int pPrice, final int pVolume, final String pItemDescription)
    {
        this.aName = pName;
        this.aPrice = pPrice;
        this.aItemDescription = pItemDescription;
        this.aVolume = pVolume;
    }
    
    
    //Get Methodes. (Related to this Class)
    /**
     * Used to fetch the name of the Item.
     * @param None.
     * @return String : Item's Name.
     */
    public String getName(){
        return this.aName;
    }
    
    /**
     * Used to fetch the price of the Item.
     * @param None.
     * @return int : Item's Price.
     */
    public int getPrice(){
        return this.aPrice;
    }
    
    /**
     * Used to fetch the volume of the Item.
     * @param None.
     * @return int : Item's Volume.
     */
    public int getVolume(){
        return this.aVolume;
    }
    
    /**
     * Used to fetch the description of the Item.
     * @param None.
     * @return String : Item's Description.
     */
    public String getItemDescription(){
        return this.aItemDescription;
    }
    
    
    //Custom Methodes. (Related to this Class)
    /**
     * Used to get a detailed description of the Item.
     * @param None.
     * @return String : Item's detailed Description.
     */
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

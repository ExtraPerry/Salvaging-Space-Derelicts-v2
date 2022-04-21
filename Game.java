
/**
 * Class used to setup the initial links between all elements of the game.
 *
 * @author Gervaise Pierre
 * @version Main Branch
 */
public class Game
{
    //Attributes
    private GameEngine aGameInstance;
    private UserInterfaceController aUI;
    
    
    //Constructors
    /**
     * Creates the game on which the player will play.
     * @param None.
     */
    public Game()
    {
        this.aGameInstance = new GameEngine();
        this.aUI = new UserInterfaceController(this.aGameInstance);
        this.aGameInstance.setUI(this.aUI);
    }
}

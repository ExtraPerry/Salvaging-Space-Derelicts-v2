
/**
 * Write a description of class Game here.
 *
 * @author Gervaise Pierre
 * @version Main Branch
 */
public class Game
{
    private GameEngine aGameInstance;
    private UserInterfaceController aUI;
    
    
    public Game()
    {
        this.aGameInstance = new GameEngine();
        this.aUI = new UserInterfaceController(this.aGameInstance);
        this.aGameInstance.setUI(this.aUI);
    }
}

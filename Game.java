
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    private GameEngine aGameInstance;
    private UserInterfaceController aUI;
    
    
    public Game()
    {
        this.aGameInstance = new GameEngine();
        this.aUI = new UserInterfaceController(this.aGameInstance);
        
        this.aGameInstance.play();
    }
}

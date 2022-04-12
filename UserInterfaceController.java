import javax.swing.JFrame;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Write a description of class UIcontroller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserInterfaceController
{
    private GameEngine aEngine;
    private JFrame aGameWindow;
    private JTextField aEntryField;
    private JButton aEnterButton;
    private JTextArea aLog;
    
    
    public UserInterfaceController( final GameEngine pEngine)
    {
        this.aEngine = pEngine;
        this.createGUI();
    }   //UserInterfaceController()
    
    public void createGUI()
    {
        this.aGameWindow = new JFrame("Salvaging Space Derelicts"); //Create the game window itself.
        
        URL vIconURL = this.getClass().getClassLoader().getResource("Images/MerpOpen.png");
        if (vIconURL != null){
            ImageIcon vIcon = new ImageIcon(vIconURL); //Fetches the relavent file information as an IconImage.
            this.aGameWindow.setIconImage(vIcon.getImage()); //Change from the default icon to the wanted icon (game window). & Converts the IconImage into an Image.
        }
        
        
        this.aLog = new JTextArea(); //Create a text area that'll serve as a log of all previous commands the player has used.
        this.aLog.setEditable(false); //The text area should not be editable by the player. It is a read only component of the GUI.
        JScrollPane vScrollLog = new JScrollPane(this.aLog); //Insert the text area into a scrollable area.
        
        
        
        this.aGameWindow.setVisible( true ); //Set the game window to visible so it appears to the user (player).
    }
}

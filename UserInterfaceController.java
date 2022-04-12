import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JTextField;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.net.URL;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * Write a description of class UIcontroller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserInterfaceController implements ActionListener
{
    private GameEngine aEngine;
    
    private JFrame aGameWindow;
    private JTextArea aLog;
    private JTextField aEntryField;
    private JLabel aImage;
    
    /**
     * Constructor for the GUI.
     */
    public UserInterfaceController( final GameEngine pEngine)
    {
        this.aEngine = pEngine;
        this.createGUI();
    }   //UserInterfaceController()
    
    /**
     * Function used to initialise the GUI.
     */
    private void createGUI(){
        //Creates the Application Window.//
        this.aGameWindow = new JFrame("Salvaging Space Derelicts"); //Create the game window itself.
        
        //Creates the Icon of the application.//
        URL vIconURL = this.getClass().getClassLoader().getResource("Images/ProgrammerArt/MerpOpen.png");
        if (vIconURL != null){
            ImageIcon vIcon = new ImageIcon(vIconURL); //Fetches the relavent file information as an IconImage.
            this.aGameWindow.setIconImage(vIcon.getImage()); //Change from the default icon to the wanted icon (game window). & Converts the IconImage into an Image.
        }
        
        //Creates the entry bar in which the player will write text to initiate commands.
        this.aEntryField = new JTextField(32);//The int used to init the Field defines how many columbs it'll have.
        
        //Creates the log of all commands used by the player.//
        this.aLog = new JTextArea(); //Create a text area that'll serve as a log of all previous commands the player has used.
        this.aLog.setEditable(false); //The text area should not be editable by the player. It is a read only component of the GUI.
        JScrollPane vScrollLog = new JScrollPane(this.aLog); //Insert the text area into a scrollable area.
        
        vScrollLog.setPreferredSize( new Dimension(400, 400) );
        vScrollLog.setMinimumSize( new Dimension(200,200) );
        
        //Creates the alocated are for the image to be displayed in.
        this.aImage = new JLabel();
        
        //Setup the custom panel layout.
        JPanel vPanel = new JPanel();
        vPanel.setLayout(new BorderLayout()); //NORTH,EAST ,SOUTH,WEST ,CENTER.
        vPanel.add(vScrollLog, BorderLayout.CENTER);
        vPanel.add(this.aImage, BorderLayout.EAST);
        vPanel.add(this.aEntryField, BorderLayout.SOUTH);
        
        //Add the custom panel layout to the main Frame.
        this.aGameWindow.getContentPane().add(vPanel, BorderLayout.CENTER);
        
        //Action Listeners
        this.aEntryField.addActionListener(this); //Listens to any text sent in the Text Field.
        this.aGameWindow.addWindowListener(new WindowAdapter() { //Makes sure that if the window is closed it'll end the game instance. (Well the entire program . . .)
            public void windowClosing(WindowEvent exception) { //Sub function withing the WindowListener that'll wait for the exception of the window being closed.
                System.exit(0); //The result of this trigger being activated will Exit the program (exit:0).
            }
        });
        
        //Finalise Frame init. (Render)
        this.aGameWindow.pack(); //Pack auto-resizes all components.
        this.aGameWindow.setVisible( true ); //Set the game window to visible so it appears to the user (player).
        this.aEntryField.requestFocus();
        
        //Start of the Game Here.
        this.setImage("Images/ProgrammerArt/TitleScreen.png");
    }
    
    /**
     * Set's specified image to be displayed on the GUI.
     */
    public void setImage(final String pImageFilePath){
        URL vImageURL = this.getClass().getClassLoader().getResource(pImageFilePath); //Turn String into a URL Path.
        if(vImageURL != null){ //Check if path is valid (if invalid = null).
            ImageIcon vImage = new ImageIcon(vImageURL); //Get image from URL path.
            this.aImage.setIcon(vImage); //Set Image.
            this.aGameWindow.pack(); //Auto-resize the components.
        }else{
            System.out.println("Error : Image not found ! (" + pImageFilePath + ")"); //Returns error message.
        }
    }
    
    /**
     * Function triggered by an Event that is detected by the ActionListener().
     */
    public void actionPerformed(final ActionEvent pEvent){
        //Action Performed once text is input from the TextField.
        //There is no need to check the type of event since the TextField only has one type (Text has been "Entered").
        this.getCommandAndProcess();
    }
    
    /**
     * Retrives the entered Text and sends it to the GameEngine to be processed.
     */
    private void getCommandAndProcess(){
        String vText = this.aEntryField.getText(); //Saves the Text written inside the TextField.
        this.aEntryField.setText(""); //Resets the TextField.
        this.aEngine.interpretUITextCommand(vText); //Send the text for processing by the GameEngine.
    }
    
    /**
     * Prints specified Text to the GUI's log.
     */
    public void print(final String pText){
        this.aLog.append(pText); //Add Text to the Log.
        this.aLog.setCaretPosition(this.aLog.getDocument().getLength()); //Move position to the bottom of the Log.
    }
    /**
     * Prints specified Text to the GUI's log, but also goes to the next line after.
     */
    public void println(final String pText){
        this.print("" + pText + "\n"); //Calls the print function, but adds a skip to next line at the end.
    }
    
    /**
     * Enables or Disables the GUI's TextField.
     */
    public void enableTextField(final boolean pTrueFalse){
        this.aEntryField.setEditable(pTrueFalse); //Makes the TextField editable or not by the User.
        if(!pTrueFalse){
            this.aEntryField.getCaret().setBlinkRate(0); //Stops the cursor from blinking any longer.
            this.aEntryField.removeActionListener(this); //Stops the EntryField's Listener from reacting to any kind of input.
        }
    }
}

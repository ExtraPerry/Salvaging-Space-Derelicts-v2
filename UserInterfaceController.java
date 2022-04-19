import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.net.URL;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * GUI class designed for the player in order to interface with the game.
 * 
 * @author Gervaise Pierre
 * @version Main Branch
 */
public class UserInterfaceController implements ActionListener
{
    private GameEngine aEngine;
    
    private JFrame aGameWindow;
    private JTextField aEntryField;
    private JButton aEnterButton;
    private JTextArea aLog;
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
        URL vIconURL = this.getClass().getClassLoader().getResource("Images/ProgrammerArt_640x360px/MerpOpen.png"); //Set the URL String of where the image is stored as a URL variable.
        if (vIconURL != null){
            ImageIcon vIcon = new ImageIcon(vIconURL); //Fetches the relavent file information as an IconImage.
            this.aGameWindow.setIconImage(vIcon.getImage()); //Change from the default icon to the wanted icon (game window). & Converts the IconImage into an Image.
        }
        
        //Creates the entry bar in which the player will write text to initiate commands.
        this.aEntryField = new JTextField(32);//The int used to init the Field defines how many columbs it'll have.
        
        //Creates the Button.
        this.aEnterButton = new JButton("Enter");
        
        //Creates the log of all commands used by the player.//
        this.aLog = new JTextArea(); //Create a text area that'll serve as a log of all previous commands the player has used.
        this.aLog.setEditable(false); //The text area should not be editable by the player. It is a read only component of the GUI.
        JScrollPane vScrollLog = new JScrollPane(this.aLog); //Insert the text area into a scrollable area.
        
        vScrollLog.setPreferredSize( new Dimension(400, 400) ); //Set prefered size of the Scrollable log in the ideal case. (if there is to much space it'll default to this size).
        vScrollLog.setMinimumSize( new Dimension(200,200) ); //Set the minimum size of the Scrollable log in the worst case. (if there is not enough space it'll still keep this set size and should then just go off-screen).
        
        //Creates the alocated are for the image to be displayed in.
        this.aImage = new JLabel();
        
        //Sub-Sub-Panel (Setup the custom panel layout).
        JPanel vPanel1 = new JPanel(); //Creates a new panel. This will be a Sub-Panel.
        vPanel1.setLayout(new BorderLayout()); //NORTH,EAST ,SOUTH,WEST ,CENTER.
        vPanel1.add(this.aEntryField, BorderLayout.CENTER); //Places the EntryField on the Bottom of the + layout configuration.
        vPanel1.add(this.aEnterButton, BorderLayout.EAST); //Places the Button on the Right of the + layout configuration.
        
        //Sub-Panel (Setup the custom panel layout).
        JPanel vPanel2 = new JPanel(); //Creates a new panel. This will be a Sub-Panel.
        vPanel2.add(vScrollLog, BorderLayout.CENTER);  //Places the Scrollable Log in the center of the + layout configuration.
        vPanel2.add(vPanel1, BorderLayout.SOUTH); //Places the Sub-Sub-Panel on the Bottom of the + layout configuration.
        
        //Main-Panel (Setup the custom panel layout).
        JPanel vPanel3 = new JPanel(); //Creates a new panel. This will be the Main-Panel.
        vPanel3.setLayout(new BorderLayout()); //NORTH,EAST ,SOUTH,WEST ,CENTER.
        vPanel3.add(vPanel2, BorderLayout.CENTER); //Places the Sub-Panel in the center of the + layout configuration.
        vPanel3.add(this.aImage, BorderLayout.EAST); //Places the Image Display on the Right of the + layout configuration.
        
        //Add the custom panel layout to the main Frame.
        this.aGameWindow.getContentPane().add(vPanel3, BorderLayout.CENTER); 
        
        //Action Listeners
        this.aEntryField.addActionListener(this); //Listens for any text sent in the Text Field.
        this.aEnterButton.addActionListener(this); //Listens for a Button Press.
        this.aGameWindow.addWindowListener(new WindowAdapter() { //Makes sure that if the window is closed it'll end the game instance. (Well the entire program . . .)
            /**
             * Command run when the event of closing the window is detected.
             */
            public void windowClosing(WindowEvent pEvent) { //Sub function withing the WindowListener that'll wait for the exception of the window being closed.
                System.exit(0); //The result of this trigger being activated will Exit the program (exit:0).
            }
        });
        this.aGameWindow.addComponentListener(new ComponentAdapter() {
            /**
             * Command run when the event of changing the window's size is detected.
             */
            public void componentResized(ComponentEvent pEvent) {
                System.out.println("Window Event [GUI] : Size Change");//This should be used to change the size of any none automaticaly scalable elements inside the Game Window. (ex: Images). 
            }
        });
        
        //Finalise Frame init. (Render)
        this.aGameWindow.pack(); //Pack auto-resizes all components.
        this.aGameWindow.setVisible( true ); //Set the game window to visible so it appears to the user (player).
        this.aEntryField.requestFocus();
        
        //Start of the Game Here. So initial setup of any GUI elements that can be swaped later. (Like an image for example).
        this.setImage("Images/ProgrammerArt_640x360px/TitleScreen.png");
    }   //createGUI()
    
    /**
     * Function triggered by an Event that is detected by the ActionListener().
     */
    public void actionPerformed(final ActionEvent pEvent){
        //Action Performed once text is input from the TextField.
        //There is no need to check the type of event since the TextField only has one type (Text has been "Entered").
        switch(pEvent.getActionCommand()){
            case "Enter":
                System.out.println("Action Performed ==> Enter Button was clicked OR [Enter] was entered in the TextField.");
                this.getInputTextAndProcess();
                break;
            default:
                System.out.println("Action Performed ==> Keyboard Enter key was pressed while TextField was selected.");
                this.getInputTextAndProcess();
                break;
        }
    }   //actionPerformed()
    
    /**
     * Retrives the entered Text and sends it to the GameEngine to be processed.
     */
    private void getInputTextAndProcess(){
        String vText = this.aEntryField.getText(); //Saves the Text written inside the TextField.
        this.aEntryField.setText(""); //Resets the TextField.
        this.aEngine.interpretUITextCommand(vText); //Send the text for processing by the GameEngine.
    }   //getInputTextAndProcess()
    
    /**
     * Prints specified Text to the GUI's log.
     */
    public void print(final String pText){
        this.aLog.append(pText); //Add Text to the Log.
        this.aLog.setCaretPosition(this.aLog.getDocument().getLength()); //Move position to the bottom of the Log.
    }   //print()
    /**
     * Prints specified Text to the GUI's log, but also goes to the next line after.
     */
    public void println(final String pText){
        this.print("" + pText + "\n"); //Calls the print function, but adds a skip to next line at the end.
    }   //println()
    
    /**
     * Enables or Disables the GUI's TextField.
     */
    public void enableTextField(final boolean pTrueFalse){
        this.aEntryField.setEditable(pTrueFalse); //Makes the TextField editable or not by the User.
        if(!pTrueFalse){
            this.aEntryField.getCaret().setBlinkRate(0); //Stops the cursor from blinking any longer.
            this.aEntryField.removeActionListener(this); //Stops the EntryField's Listener from reacting to any kind of input.
        }
    }   //enableTextField()
    
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
    }   //setImage()
}

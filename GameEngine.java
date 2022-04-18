import java.util.HashMap;
import java.util.Set;

/**
 * The main game instance.
 */
public class GameEngine
{
    //Attributes.
    private Player aActivePlayer; //The player that is currently being used.
    private Parser aParser; //Player inputs.
    private HashMap<String, Room> aGameRooms; //All Rooms in the game.
    private UserInterfaceController aUI; //GUI.
    
    
    //Constructors.
    /**
     * Builds the Object from "this" class.
     */
    public GameEngine(){
        this.createRooms();
        this.setActivePlayer(new Player("Player 1", this.getRoomFromMemory("Airlock")));
        this.aParser = new Parser();
    }   //Game()
    
    //Methode related to the constructor. (This one will define what the game layout is like).
    /**
     * Used to create all of the "Rooms" inside of the game.
     * Used at game startup and is the map in itself.
     */
    private void createRooms(){
        //All rooms
        Room vAirlock = new Room("Airlock","Images/ProgrammerArt_640x360px/Airlock.png");
        Room vCargoBay = new Room("Cargo Bay","Images/ProgrammerArt_640x360px/CargoBay.png");
        Room vMainHall = new Room("Main Hall","Images/ProgrammerArt_640x360px/MainRoom.png");
        Room vSafe = new Room("Safe Room","Images/ProgrammerArt_640x360px/SafeRoom.png");
        Room vPilotDorm = new Room("Pilot Dorm","Images/ProgrammerArt_640x360px/PilotDorm.png");
        Room vBridge = new Room("Bridge","Images/ProgrammerArt_640x360px/Bridge.png");
        Room vEngineering = new Room("Engineering","Images/ProgrammerArt_640x360px/Engineering.png");
        Room vReactor = new Room("Reactor Room","Images/ProgrammerArt_640x360px/Reactor.png");
        Room vEngine1 = new Room("Engine Room 1","Images/ProgrammerArt_640x360px/EngineRoom1.png");;
        Room vEngine2 = new Room("Engine Room 2","Images/ProgrammerArt_640x360px/EngineRoom2.png");
        Room vEngine3 = new Room("Engine Room 3","Images/ProgrammerArt_640x360px/EngineRoom3.png");
        Room vEngine4 = new Room("Engine Room 4","Images/ProgrammerArt_640x360px/EngineRoom4.png");
        Room vDorms = new Room("Dorms","Images/ProgrammerArt_640x360px/Dorms.png");
        Room vMedical = new Room("Medical Room","Images/ProgrammerArt_640x360px/MedicalBay.png");
        Room vSports = new Room("Sports Room","Images/ProgrammerArt_640x360px/FreeArea.png");
        Room vCantine = new Room("Cafeteria","Images/ProgrammerArt_640x360px/Cafeteria.png");
        Room vKitching = new Room("Kitching","Images/ProgrammerArt_640x360px/Kitchen.png");
        Room vScienceAndMonitoring = new Room("Science and Monitoring","Images/ProgrammerArt_640x360px/ScienceAndMonitoring.png");
        Room vObservationDome = new Room("Observation Dome","Images/ProgrammerArt_640x360px/ObservationDome.png");
        
        
        //Airlock Exits
        vAirlock.setExit("south",vCargoBay);
        //Storage Exits
        vCargoBay.setExit("above",vMainHall);
        vCargoBay.setExit("north",vAirlock);
        //Main Hall Exits
        vMainHall.setExit("above",vObservationDome);
        vMainHall.setExit("below",vCargoBay);
        vMainHall.setExit("north",vSafe);
        vMainHall.setExit("east",vCantine);
        vMainHall.setExit("south",vEngineering);
        vMainHall.setExit("west",vDorms);
        //Safe Room Exits
        vSafe.setExit("north",vPilotDorm);
        vSafe.setExit("east",vScienceAndMonitoring);
        vSafe.setExit("south",vMainHall);
        vSafe.setExit("west",vSports);
        // Pilot Dorm Exits
        vPilotDorm.setExit("north",vBridge);
        vPilotDorm.setExit("south",vSafe);
        //Bridge Exits
        vBridge.setExit("south",vPilotDorm);
        //Engineering Exits
        vEngineering.setExit("below",vReactor);
        vEngineering.setExit("north",vMainHall);
        vEngineering.setExit("south",vEngine1);
        vEngineering.setExit("west",vMedical);
        //Reactor Exits
        vReactor.setExit("above",vEngineering);
        vReactor.setExit("south",vEngine2);
        //Engine1 Exits
        vEngine1.setExit("below",vEngine2);
        vEngine1.setExit("north",vEngineering);
        vEngine1.setExit("east",vEngine4);
        vEngine1.setExit("west",vEngine3);
        //Engine2 Exits
        vEngine2.setExit("above",vEngine1);
        vEngine2.setExit("north",vReactor);
        //Engine3 Exits
        vEngine3.setExit("east",vEngine1);
        //Engine4 Exits
        vEngine4.setExit("west",vEngine1);
        //Dorms Exits
        vDorms.setExit("north",vSports);
        vDorms.setExit("east",vMainHall);
        vDorms.setExit("south",vMedical);
        //Medical Exits
        vMedical.setExit("north",vDorms);
        vMedical.setExit("east",vEngineering);
        //Sports Exits
        vSports.setExit("east",vSafe);
        vSports.setExit("south",vDorms);
        //Cantine Exits
        vCantine.setExit("north",vScienceAndMonitoring);
        vCantine.setExit("south",vKitching);
        vCantine.setExit("west",vMainHall);
        //Kitching Exits
        vKitching.setExit("north",vCantine);
        //Science and Monitoring Exits
        vScienceAndMonitoring.setExit("south",vCantine);
        vScienceAndMonitoring.setExit("west",vSafe);
        //Observation Dome Exits
        vObservationDome.setExit("below",vMainHall);
        
        
        //Arilock Items.
        Item vDigitalPad = new Item("DigiPad", 50, 1, "Digi Pad containing some basic information about the ship");
        vAirlock.addItemToInventory(vDigitalPad);
        
        //Storage Items.
        Item vDamagedCrate = new Item("DamagedCrate", 750, 1, "A Damaged Crate, it's contents seem to be destroyed but maybe you could sell it as scraps.");
        vCargoBay.addItemToInventory(vDamagedCrate);
        Item vIntactCrate = new Item("IntactCrate", 7500, 1, "An Intact Crate, you are unable to open it but even so it'll sell well.");
        vCargoBay.addItemToInventory(vIntactCrate);
        
        
        //Init the HashMap first.
        this.aGameRooms = new HashMap<String, Room>();
        //Adding the temporary rooms to a global attribute for later use.
        this.aGameRooms.put(vAirlock.getName(),vAirlock);
        this.aGameRooms.put(vCargoBay.getName(),vCargoBay);
        this.aGameRooms.put(vMainHall.getName(),vMainHall);
        this.aGameRooms.put(vSafe.getName(),vSafe);
        this.aGameRooms.put(vPilotDorm.getName(),vPilotDorm);
        this.aGameRooms.put(vBridge.getName(),vBridge);
        this.aGameRooms.put(vEngineering.getName(),vEngineering);
        this.aGameRooms.put(vReactor.getName(),vReactor);
        this.aGameRooms.put(vEngine1.getName(),vEngine1);
        this.aGameRooms.put(vEngine2.getName(),vEngine2);
        this.aGameRooms.put(vEngine3.getName(),vEngine3);
        this.aGameRooms.put(vEngine4.getName(),vEngine4);
        this.aGameRooms.put(vDorms.getName(),vDorms);
        this.aGameRooms.put(vMedical.getName(),vMedical);
        this.aGameRooms.put(vSports.getName(),vSports);
        this.aGameRooms.put(vCantine.getName(),vCantine);
        this.aGameRooms.put(vKitching.getName(),vKitching);
        this.aGameRooms.put(vScienceAndMonitoring.getName(),vScienceAndMonitoring);
        this.aGameRooms.put(vObservationDome.getName(),vObservationDome);
    }   //createRooms()
    
    
    //Set Methodes. (Related to this Class)
    /**
     * Used to change the active player in the game.
     */
    private void setActivePlayer(Player pActivePlayer){
        this.aActivePlayer = pActivePlayer;
    }   //setActivePlayer()
    
    /**
     * Assigns the UI to the game engine in order to let it return feedback to the player.
     */
    public void setUI(UserInterfaceController pUI){
        this.aUI = pUI; //Sets UI.
        this.printWelcome(); //Welcome message
    }   //setUI()
    
    
    //Get Methodes. (Related to this Class)
    /**
     * Used to fetch the active player in the game.
     */
    private Player getActivePlayer(){
        return this.aActivePlayer;
    }   //getActivePlayer()
    
    /**
     * Used to Fetch a room stored in the game engin's memory (Hash Map).
     */
    private Room getRoomFromMemory(final String pRoomName){
        return this.aGameRooms.get(pRoomName);
    }   //getRoomFromMemory()
    
    //Custom Methodes. (Related to this Class)
    /**
     * Reads the text written by the player and translates it to a readable command format.
     * Then sends it to be processed and run if recongnised.
     */
    public void interpretUITextCommand(final String pText){
        this.aUI.println("> " + pText + ""); //Send to log the command that was read.
        boolean vExitCondition = this.processCommand(this.aParser.getCommand(pText)); //Translate & Process the command words.
        if(vExitCondition){
            this.endGame();
        }
    }   //interpretUITextCommand()
    
    /**
     * Command manager used after the commands are filtered through the Parser class.
     * Returns true (boolean) if the player wants to quit the game. In other words to end the instance.
     */
    private boolean processCommand(final Command pCommand){
        if (pCommand.getCommandWord() != null){
            switch(pCommand.getCommandWord().toLowerCase()){
                case "go":
                    goRoom(pCommand);
                    return false;
                case "help":
                    printHelp(pCommand);
                    return false;
                case "quit":
                    return quit(pCommand);
                case "look":
                    look();
                    return false;
                case "use":
                    use();
                    return false;
                case "back":
                    back(pCommand);
                    return false;
                case "take":
                    take(pCommand);
                    return false;
                case "drop":
                    drop(pCommand);
                    return false;
                case "inventory":
                    inventory(pCommand);
                    return false;
                case "test":
                    test();
                    return false;
                case "merp":
                    this.aUI.println("The Sergal goes Merp and the Cheese Wedge be Yellow !");
                    return false;
            }
        }
        this.aUI.println("I don't know what you mean...");
        return false;
    }   //processCommand()
    
    /**
     * Sends the player to the next selected room by "Command"'s order.
     * Param = Command.
     * return = void.
     */
    private void goRoom(final Command pCommand){
        if (pCommand.hasSecondWord()){ //Checks if the go command has a second word
            String vDirection = pCommand.getSecondWord().toLowerCase();
            if(this.getActivePlayer().hasNextRoom(vDirection)){
                this.aActivePlayer.moveToNextRoom(vDirection);
                this.updateLocation();
            }else{
                this.aUI.println("Unknown Direction"); //Tells the player that the direction is incorrect.
            }
        }else{
            this.aUI.println("Go where ?"); //If the go command has no second word asks the player where to go.
        }
    }   //goRoom()
    
    /**
     * Help command. //Needs to be able to adapt to all the commands available :D
     */
    private void printHelp(final Command pCommand){
        if(pCommand.hasSecondWord()){
            String vSecondWord = pCommand.getSecondWord().toLowerCase();
            if(this.aParser.getCommandDescription(pCommand.getSecondWord().toLowerCase()) != null){
                this.aUI.print("The command called \"" + this.formatWord(vSecondWord) + "\" is for : ");
                this.aUI.println(this.aParser.getCommandDescription(vSecondWord));
            }else{
                this.aUI.println("" + this.formatWord(vSecondWord) + " is not an existing command.");
            }
        }else{
            this.aUI.println("Your command words are:");
            String[] vValidCommandList = this.aParser.getValidCommands();
            String vOutput = "";
            for(int i=0 ; i<vValidCommandList.length ; i++){
                if(vOutput != ""){
                    vOutput += ", ";
                }
                vOutput += vValidCommandList[i];
            }
            this.aUI.println("" + vOutput + ".");
        }
    }   //printHelp()
    
    /**
     * Quit command. Returns true (boolean) if the player wants to quit the game.
     */
    private boolean quit(final Command pCommand){
        if (pCommand.hasSecondWord()){ //Checks if quit has a second word
            this.aUI.println("Quit what ?"); //If quit has a second word ask what the player wants to quit.
            return false; //Don't quit the game (return => false)
        }
        return true; //Quit the game (return => true)
    }   //quit()
    
    /**
     * Look command. Tells the player info on their current location.
     */
    private void look(){
        this.printLocationInfo();
    }   //look()
    
    /**
     * Use command. Let's the player use an item.
     */
    private void use(){
        this.aUI.println("You used an item called thin air GG !");
    }   //use()
    
    /**
     * Back command that will send the player to the previous room or rooms.
     */
    private void back(final Command pCommand){
        int vStack;
        if(pCommand.hasSecondWord()){
            try{
                vStack = Integer.parseInt(pCommand.getSecondWord());
            }catch(NumberFormatException vException){
                String vSecondWord = pCommand.getSecondWord();
                this.aUI.println(this.formatWord(vSecondWord) + " is not a number.");
                return;
            }
            if(vStack == 0){
                this.aUI.println("0 is not a valid number.");
                return;
            }
            if(vStack < 0){
                this.aUI.println("You cannot input a negative number.");
                return;
            }
        }else{
            vStack = 1;
        }
        if(this.getActivePlayer().hasPreviousRoom()){
            this.getActivePlayer().moveToPreviousRoom(vStack);
            this.updateLocation();
        }else{
            this.aUI.println("There are no rooms to go back to.");
        }
    }   //back()
    
    /**
     * Take command that will move an item from the room the player is in into the player's inventory.
     */
    private void take(final Command pCommand){
        if(pCommand.hasSecondWord()){
            String vItemNameCommand = pCommand.getSecondWord();
            Room vCurrentRoom = this.getActivePlayer().getCurrentRoom();
            if(vCurrentRoom.hasItemInInventory(vItemNameCommand)){
                Item vItem = vCurrentRoom.getItemFromInventory(vItemNameCommand);
                if(this.getActivePlayer().hasSpaceInInventoryFor(vItem)){
                    this.getActivePlayer().getCurrentRoom().removeItemFromInventory(vItem);
                    this.getActivePlayer().addItemToInventory(vItem);
                    this.aUI.println("You've taken " + vItem.getName() + " from " + vCurrentRoom.getName());
                }else{
                    this.aUI.println("Not enough place in inventory to pick up " + vItem.getName() + ".");
                }
            }else{
                this.aUI.println("Specified item (" + this.formatWord(vItemNameCommand) + ") cannot be found inside this room.");
            }
        }else{
            this.aUI.println("Take what Item ?");
        }
    }   //take()
    
    /**
     * Take command that will move an item from the room the player is in into the player's inventory.
     */
    private void drop(final Command pCommand){
        if(pCommand.hasSecondWord()){
            String vItemNameCommand = pCommand.getSecondWord();
            if(this.getActivePlayer().hasItemInInventory(vItemNameCommand)){
                Item vItem = this.getActivePlayer().getItemFromInventory(vItemNameCommand);
                Room vCurrentRoom = this.getActivePlayer().getCurrentRoom();
                this.getActivePlayer().removeItemFromInventory(vItem);
                vCurrentRoom.addItemToInventory(vItem);
                this.aUI.println("You've dropped " + vItem.getName() + " in " + vCurrentRoom.getName());
            }else{
                this.aUI.println("Specified item (" + this.formatWord(vItemNameCommand) + ") cannot be found inside player's inventory.");
            }
        }else{
            this.aUI.println("Drop what Item ?");
        }
    }   //take()
    
    /**
     * 
     */
    private void inventory(final Command pCommand){
        if(pCommand.hasSecondWord()){
            String vSecondWord = pCommand.getSecondWord().toLowerCase();
            switch(vSecondWord){
                case "player":
                    this.aUI.println(this.getActivePlayer().getInventoryListDescription());
                    break;
                case "room":
                    this.aUI.println(this.getActivePlayer().getCurrentRoom().getInventoryListDescription());
                    break;
                default:
                    this.aUI.println(this.formatWord(vSecondWord) + " is not a valid inventory. [Player] or [Room]");
                    break;
            }
        }else{
            this.aUI.println("Which inventory ? [Player] or [Room]");
        }
    }
    
    /**
     * Test command that'll use various commands to see if they work.
     */
    private void test(){
        //Reset Player position to the start.
        Room vStarterRoom = this.aGameRooms.get("Airlock");
    
        this.updateLocation();
        
        //Start of the testing routine.
        
    }   //test()
    
    /**
     * Updates the players position to the room sent in parameters.
     */
    private void updateLocation(){
        this.aUI.setImage(this.getActivePlayer().getCurrentRoom().getImageFilePath());
        this.printLocationInfo();
    }   //updateLocation()
    
    /**
     * Used to capitalise the first letter of a word and put the rest to lower case.
     */
    private String formatWord(final String pWord){
        return pWord.substring(0,1).toUpperCase() + pWord.substring(1).toLowerCase();
    }   //formatWord()
    
    /**
     * Gets the Exits from the room you are currently in. (Also a Command).
     * Returns a String.
     */
    private void printLocationInfo(){
        this.aUI.println(this.getActivePlayer().getCurrentRoomDescription()); //Tells the player a Long description about the room they are in.
    }   //printLocationInfo()

    /**
     * Start Up message of the game.
     */
    private void printWelcome(){
        this.aUI.println("Welcome to Salvaging Space Derelicts.");
        this.aUI.println("");
        this.aUI.println("As you fly though space looking for the next oportunity.");
        this.aUI.println("A wreck shows up on your scanner.");
        this.aUI.println("You jump on the occasion and enter the airlock starting your adventure.");
        this.aUI.println("");
        this.updateLocation();
    }   //printWelcome()
    
    /**
     * Used to end the Game.
     */
    private void endGame(){
        this.aUI.println("The End");
        this.aUI.enableTextField(false);
    }   //endProgram()
} // Game

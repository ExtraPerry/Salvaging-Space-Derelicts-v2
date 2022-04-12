import java.util.HashMap;
import java.util.Set;

/**
 * The main game instance.
 */
public class GameEngine
{
    private Room aCurrentRoom; //The room the player is currently in
    private Parser aParser; //Player inputs
    private HashMap<String, Room> aGameRooms;
    
    /**
     * Builds the Object from "this" class.
     */
    public GameEngine(){
        this.createRooms();
        this.aParser = new Parser();
    }   //Game()
    
    /**
     * Used to create all of the "Rooms" inside of the game.
     * Used at game startup and is the map in itself.
     */
    private void createRooms(){
        //All rooms
        Room vAirlock = new Room("Airlock");
        Room vStorage = new Room("Storage");
        Room vMainHall = new Room("Main Hall");
        Room vSafe = new Room("Safe Room");
        Room vPilotDorm = new Room("Pilot Dorm");
        Room vBridge = new Room("Bridge");
        Room vEngineering = new Room("Engineering");
        Room vReactor = new Room("Reactor Room");
        Room vEngine1 = new Room("Engine Room 1");
        Room vEngine2 = new Room("Engine Room 2");
        Room vEngine3 = new Room("Engine Room 3");
        Room vEngine4 = new Room("Engine Room 4");
        Room vDorms = new Room("Dorms");
        Room vMedical = new Room("Medical Room");
        Room vSports = new Room("Sports Room");
        Room vCantine = new Room("Cantine");
        Room vKitching = new Room("Kitching");
        Room vScienceAndMonitoring = new Room("Science and Monitoring");
        Room vObservationDome = new Room("Observation Dome");
        
        
        //Airlock Exits
        vAirlock.setExit("south",vStorage);
        //Storage Exits
        vStorage.setExit("above",vMainHall);
        vStorage.setExit("north",vAirlock);
        //Main Hall Exits
        vMainHall.setExit("above",vObservationDome);
        vMainHall.setExit("below",vStorage);
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
        
        this.aCurrentRoom = vAirlock;
        
        //Init the HashMap first.
        this.aGameRooms = new HashMap<String, Room>();
        //Adding the temporary rooms to a global attribute for later use.
        this.aGameRooms.put(vAirlock.getDescription(),vAirlock);
        this.aGameRooms.put(vStorage.getDescription(),vStorage);
        this.aGameRooms.put(vMainHall.getDescription(),vMainHall);
        this.aGameRooms.put(vSafe.getDescription(),vSafe);
        this.aGameRooms.put(vPilotDorm.getDescription(),vPilotDorm);
        this.aGameRooms.put(vBridge.getDescription(),vBridge);
        this.aGameRooms.put(vEngineering.getDescription(),vEngineering);
        this.aGameRooms.put(vReactor.getDescription(),vReactor);
        this.aGameRooms.put(vEngine1.getDescription(),vEngine1);
        this.aGameRooms.put(vEngine2.getDescription(),vEngine2);
        this.aGameRooms.put(vEngine3.getDescription(),vEngine3);
        this.aGameRooms.put(vEngine4.getDescription(),vEngine4);
        this.aGameRooms.put(vDorms.getDescription(),vDorms);
        this.aGameRooms.put(vMedical.getDescription(),vMedical);
        this.aGameRooms.put(vSports.getDescription(),vSports);
        this.aGameRooms.put(vCantine.getDescription(),vCantine);
        this.aGameRooms.put(vKitching.getDescription(),vKitching);
        this.aGameRooms.put(vScienceAndMonitoring.getDescription(),vScienceAndMonitoring);
        this.aGameRooms.put(vObservationDome.getDescription(),vObservationDome);
    }   //createRooms()
    
    /**
     * Starts the game. (in essence it is the games instance)
     */
    public void play(){
        this.printWelcome(); //Welcome message
        boolean vFinished = false; //boolean used to determine if the game should end (if true => game ends)
        while(vFinished == false){ //Game loop (ends when the game ends)
            vFinished = this.processCommand(aParser.getCommand()); //any command sent in the console is sent here (returns true if the game ends)
        }
        System.out.println("--- The End ---"); //End game message
    }   //play()
    
    /**
     * Sends the player to the next selected room by "Command"'s order.
     * Param = Command.
     * return = void.
     */
    private void goRoom(final Command pCommand){
        if (!(pCommand.hasSecondWord())){ //Checks if the go command has a second word
            System.out.println("Go where ?"); //If the go command has no second word asks the player where to go
            return;
        }
        
        Room vNextRoom = null; //Init the next room to be chosen
        
        vNextRoom = this.aCurrentRoom.getExit(pCommand.getSecondWord().toLowerCase()); //Get the room that the player wants to go to (null if direction is not available)
        
        if (vNextRoom == null){ //If direction is null then direction is Unknown
            System.out.println("Unknown Direction"); //Tells the player that the direction is incorrect
            return;
        }
        
        this.aCurrentRoom = vNextRoom; //Sends the player to the next room
        this.printLocationInfo(); //Tells the player info about the next room
    }   //goRoom()

    /**
     * Gets the Exits from the room you are currently in. (Also a Command).
     * Returns a String.
     */
    private void printLocationInfo()
    {
        System.out.println(aCurrentRoom.getLongDescription()); //Tells the player a Long description about the room they are in.
    }   //printLocationInfo()
    
    /**
     * Start Up message of the game.
     */
    private void printWelcome(){
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println("");
        System.out.println("You are outside the main entrance of the university");
        this.printLocationInfo();
    }   //printWelcome()
    
    /**
     * Help command. //Needs to be able to adapt to all the commands available :D
     */
    private void printHelp(final Command pCommand){
        if(pCommand.hasSecondWord()){
            String vSecondWord = pCommand.getSecondWord().toLowerCase();
            if(this.aParser.getCommandDescription(pCommand.getSecondWord().toLowerCase()) != null){
                System.out.print("The command called \"" + vSecondWord.substring(0,1).toUpperCase() + vSecondWord.substring(1).toLowerCase() + "\" is for : ");
                System.out.println(this.aParser.getCommandDescription(vSecondWord));
            }else{
                System.out.println("" + pCommand.getSecondWord().substring(0,1).toUpperCase() + vSecondWord.substring(1).toLowerCase() + " is not an existing command.");
            }
        }else{
            System.out.println("Your command words are:");
            String[] vValidCommandList = this.aParser.getValidCommands();
            String vOutput = "";
            for(int i=0 ; i<vValidCommandList.length ; i++){
                if(vOutput != ""){
                    vOutput += ", ";
                }
                vOutput += vValidCommandList[i];
            }
            System.out.println("" + vOutput + ".");
        }
    }
    
    /**
     * Quit command. Returns true (boolean) if the player wants to quit the game.
     */
    private boolean quit(final Command pCommand){
        if (pCommand.hasSecondWord()){ //Checks if quit has a second word
            System.out.println("Quit what ?"); //If quit has a second word ask what the player wants to quit.
            return false; //Don't quit the game (return => false)
        }
        return true; //Quit the game (return => true)
    }
    
    /**
     * Look command. Tells the player info on their current location.
     */
    private void look(){
        this.printLocationInfo();
    }
    
    /**
     * Use command. Let's the player use an item.
     */
    private void use(){
        System.out.println("You used an item called thin air GG !");
    }
    
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
                case "merp":
                    System.out.println("The Sergal goes Merp and the Cheese Wedge be Yellow !");
                    return false;
            }
        }
        System.out.println("I don't know what you mean...");
        return false;
    }
} // Game

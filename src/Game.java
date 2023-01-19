public class Game{
    private CommandWords commands;
    private Parser parser;
    private Room currentRoom;

    public Game(){
        createRooms();
        parser = new Parser();
        commands=new CommandWords();
    }

    private void createRooms(){
        Room bevrorenW, bos,veld,boerderij,boomstam,grot,ruines,struik,
        vijver,grasveld,bloemenveld,verwoestD;
        Item promoBoard,ashtray;

        //create the rooms
        bevrorenW= new Room("U look at the frozen water. This isn't what u want.\nThe need for survival files u with hope.....\n");
        bos = new Room("Its cold and dark, but u see bushes every where.\nThe large trees around u make u a bit scared...\n");
        veld=new Room("U arrive at a large field filled with glistering watermelons.\nThey look delicious..U want to eat one\n");
        boerderij=new Room("U can smell the horse shit getting stronger.\nIts a farm full of unicorns.. They look thirsty....\n");
        boomstam=new Room("All of a sudden u fall over.It hurts..\nU look behind u and see a giant tree trunk\n");
        grot=new Room("The sounds of the forest are getting quite..\nWithout any warning u find urself in front of a cave..\nIt looks scary....\n");
        ruines=new Room("U get airy feeling.The village u once used to know is destroyed..\nMaybe there are some treasurers to find in the rumble....\n");
        struik=new Room("inthegrot");
        vijver=new Room("inthegrot");
        grasveld=new Room("uknow");
        bloemenveld=new Room("inthegrot");
        verwoestD=new Room("inthegrot");

        bevrorenW.setExit("north",bos);

        bos.setExit("north",boerderij);
        bos.setExit("east",veld);

        veld.setExit("north",boomstam);
        veld.setExit("east",grot);
        grot.setExit("west",veld);

        boerderij.setExit("west",verwoestD);
        boerderij.setExit("east",boomstam);
        boerderij.setExit("south",bos);

        boomstam.setExit("north",ruines);
        boomstam.setExit("south",veld);

        verwoestD.setExit("east",boerderij);
        verwoestD.setExit("north",bloemenveld);

        bloemenveld.setExit("north",grasveld);
        bloemenveld.setExit("south",verwoestD);

        grasveld.setExit("east",vijver);
        vijver.setExit("east",struik);
        struik.setExit("south",ruines);


        currentRoom = bevrorenW; //startgamebevrorenW
    }

/**
 *Mainplayroutine.Loopsuntilendofplay.
 */
    public void play(){
        printWelcome();
        boolean finished=false;
        while(!finished){
        Command command = parser.getCommand();
        finished= processCommand(command);
        }
        System.out.println("Thank you for playing.Goodbye.");
    }

/**
 * Print out the opening message for th eplayer.
 */
    private void printWelcome(){
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game");
        System.out.println("Type 'help' if you need help");
        System.out.println("+-----------------------------------------------------------------------------+");
        System.out.println();
        printLocationInfo();
        System.out.println();
        System.out.println("What would u like to do?");
        }

        private void printLocationInfo(){
        System.out.println(currentRoom.getLongDescription());
        System.out.println();
    }

/**
 * Given a command,process(that is: execute)the command.
 */
private boolean processCommand(Command command)
{
    boolean wantToQuit = false;

    if(command.isUnknown()) {
        System.out.println("I don't know what you mean...");
        return false;
    }

    CommandWord commandWord = command.getCommandWord();
    switch (commandWord) {
        case HELP:
            printHelp();
            break;
        case GO:
            goRoom(command);
            break;
        case QUIT:
            wantToQuit = quit(command);
            break;
        default:
    }
    return wantToQuit;
}

    private void printHelp(){
        System.out.println("Urgoal");
        printLocationInfo();
        System.out.println("Yourcommandwordsare:"+parser.showCommands());
        System.out.println();
    }
    private void look(){
        System.out.println(currentRoom.getLongDescription());
    }
    private void eat(){
        System.out.println("Jehebtnugegetenenbentnietmeerhongerig\n");
    }
    private void back(){
        System.out.println("urgoingback");
    }
    private void goRoom(Command command){
        if(!command.hasSecondWord()){
            //ifthereisnosecondword,wedon'tknowwheretogo...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        //Trytoleavecurrentroom.
        Room nextRoom = currentRoom.getExit(direction);

        if(nextRoom==null){
            System.out.println("There is no door!");
        }else{
            currentRoom=nextRoom;
            printLocationInfo();
        }
    }
    private boolean quit(Command command){
        if(command.hasSecondWord()){
        System.out.println("Quit what?");
        return false;
        }else{
        return true;//signalthatwewanttoquit
        }
    }
    private void take(Command command){
        if(!command.hasSecondWord()){
            //ifthereisnosecondword,wedon'tknowwhattotake...
            System.out.println("Takewhat?");
            return;
        }
        String itemName = command.getSecondWord();
        if(player.take(itemName)){
            printLocationInfo();
        }else{
        System.out.println("There is no item here with the name" + itemName);
        }
        }

        public static void main(String[]args){
        Game game = new Game();
        game.play();
        }
}


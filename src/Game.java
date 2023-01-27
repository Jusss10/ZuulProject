import java.util.ArrayList;
import java.util.List;

public class Game{
    private Parser parser;
    private Room currentRoom;
    private Player player;

    public Game(){
        createRooms();
        parser = new Parser();
        player = new Player("Misty", currentRoom);
    }

    private void createRooms(){
        Room frozenWater, forest, field, farm, treeTrunk, cave, ruins, bush,
        river, lawn, flowerField, town;
        Item keyCave, flower, berries;

        //create items
        keyCave = new Item("keyCave","its amazing");
        flower = new Item("flower","Im sure that someone would love this");
        berries = new Item("berries","You are not sure you should eat them");

        //create the rooms
        frozenWater = new Room("""
                U look at the frozen water. This isn't what u want.
                The need for survival files u with hope.....
                """, null);
        forest = new Room("""
                Its cold and dark, but u see bushes every where.
                The large trees around u make u a bit scared...
                """, null);
        field = new Room("""
                U arrive at a large field filled with glistering watermelons.
                They look delicious..U want to eat one
                """, null);
        farm = new Room("""
                U can smell the horse shit getting stronger.
                Its a farm full of unicorns.. They look thirsty....
                """, null);
        treeTrunk = new Room("""
                All of a sudden u fall over.It hurts..
                U look behind u and see a giant tree trunk
                """, null);
        cave = new Room("""
                The sounds of the forest are getting quite..
                Without any warning u find urself in front of a cave..
                It looks scary....
                """, keyCave);
        ruins = new Room("""
                U get airy feeling.The village u once used to know is destroyed..
                Maybe there are some treasurers to find in the rumble....
                """, null);
        bush = new Room("""
                There are leaves everywhere where u can see and its kind of overwhelming.
                But u see delicious berries and wonder if u should eat one.
                """, null);
        river = new Room("""
                In the summer u love to come here but now.. The winter froze the lake.
                Now it is just a big reminder of your worst fear.
                """, null);
        lawn = new Room("""
                The lawn has just been mowed and it smells really bad..
                """, null);
        flowerField = new Room("""
                Normally your not a big flower person but in the winter you love the flower field..
                Its because its the only pop of color in the whole town.
                """, null);
        town = new Room("""
                There are not much people around...
                U wished this town was more populated.....
                """, null);

        frozenWater.setExit("north",forest);

        forest.setExit("north",farm);
        forest.setExit("east",field);

        field.setExit("north",treeTrunk);
        field.setExit("east",cave);
        cave.setExit("west",field);

        farm.setExit("west",town);
        farm.setExit("east",treeTrunk);
        farm.setExit("south",forest);

        treeTrunk.setExit("north",ruins);
        treeTrunk.setExit("south",field);

        town.setExit("east",farm);
        town.setExit("north",flowerField);

        //FlowerField
        flowerField.setExit("north",lawn);
        flowerField.setExit("south",town);
        flowerField.addItem(flower);

        lawn.setExit("east",river);
        river.setExit("east",bush);
        bush.setExit("south",ruins);
        bush.addItem(berries);

        currentRoom = frozenWater; //Where the game Starts
    }

    public void play(){
        printWelcome();
        boolean finished = false;
        while(!finished){
        Command command = parser.getCommand();
        finished= processCommand(command);
        }
        System.out.println("Thank you for playing.Goodbye.");
    }

    private void printWelcome(){
        System.out.println();
        System.out.println("Welcome to a cold winter day");
        System.out.println("You are a little water droplet who doesnt want to freeze");
        System.out.println("Type 'help' if you need help");
        System.out.println("+-----------------------------------------------------------------------------+");
        printLocationInfo();
        System.out.println();
        System.out.println("What would u like to do?");
        }

        private void printLocationInfo(){
        System.out.println(currentRoom.getLongDescription());
        System.out.println();
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

    CommandWord commandWord = command.getCommandWord();
    switch (commandWord) {
        case HELP -> printHelp();
        case GO -> goRoom(command);
        case EAT -> eat();
        case BACK -> back();
        case LOOK -> look();
        case QUIT -> wantToQuit = quit(command);
        default -> {
        }
    }
    return wantToQuit;
}

    private void printHelp(){
        System.out.println("Your goal is to find a way to stop becoming frozen");
        System.out.println("Don't forget u can use these command words:"+ parser.showCommands());
        System.out.println();
    }
    private void look(){
        System.out.println(currentRoom.getLongDescription());
    }
    private void eat(){
        System.out.println("You ate something and feel full\n");
    }

    private void back(){
        Room lastRoom = player.takeLastRoomFromHistory();
        if (lastRoom == null){
            System.out.println("You can't go back");
            return;
        }
        currentRoom = lastRoom;
        printLocationInfo();
    }

    private void goRoom(Command command){
        if(!command.hasSecondWord()){
            //if there is no second word,we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        //Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        if(nextRoom==null){
            System.out.println("There is no door!");
        }else{
            player.addRoomToHistory(currentRoom);
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }
    private boolean quit(Command command){
        if(command.hasSecondWord()){
        System.out.println("Quit what?");
        return false;
        }else{
        return true;//signal that we want to quit
        }
    }
    private void take(Command command){
        if(!command.hasSecondWord()){
            //if there is no second word,we don't know what to take...
            System.out.println("Take what?");
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


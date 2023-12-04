import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords{
    private final HashMap <String, CommandWord> validCommands = new HashMap<>(); //Creating HashMap


    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
        validCommands.put("go", CommandWord.GO);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("look", CommandWord.LOOK);
        validCommands.put("back", CommandWord.BACK);
        validCommands.put("eat", CommandWord.EAT);
    }

    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }

    public String showAll(){
        String show=" ";
        for(String command : validCommands.keySet()){
        show += command+" ";
        } return show;
    }

    public CommandWord getCommand(String aString){
        if(validCommands.containsKey(aString))return validCommands.get(aString);
        return CommandWord.UNKNOWN;
    }
}


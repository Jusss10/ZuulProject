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
    private HashMap<String,CommandWord> validCommands;
    public enum CommandWord{
        GO,QUIT,HELP,UNKNOWN
    }

/**
 *Constructor-initialisethecommandwords.
 */
    public CommandWords(){
        validCommands= new HashMap<String,CommandWord>();
        for(CommandWord command:CommandWord.values()){
        if(command!=CommandWord.UNKNOWN){
        validCommands.put(command.toString(),command);}}
        }

/**
 *CheckwhetheragivenStringisavalidcommandword.
 *
 *@returntrueifagivenstringisavalidcommand,
 *falseifitisn't.
 */

    public boolean isCommand(String aString){
        for(int i=0; i<validCommands.containsKey(aString);i++){
        if(validCommands[i].equals(aString))
        return true;}
        //ifwegethere,thestringwasnotfoundinthecommands
        return false;
    }

    public String showAll(){
        String show="";
        for(String command:validCommands){
        show += command+"";
        } return show;
    }

    public CommandWord getCommand(String aString){
        if(validCommands.containsKey(aString))return validCommands.get(aString);
        return CommandWord.UNKNOWN;
    }

    public String getCommandString(CommandWords commandWord){
        for(String commandString:validCommands.keySet()){
            if(validCommands.get(commandString).equals(commandWord)){
            return commandString;}
        }
        return null;
    }
}


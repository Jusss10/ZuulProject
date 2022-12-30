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
        validCommands=newHashMap<String,CommandWord>();
        for(CommandWordcommand:CommandWord.values()){
        if(command!=CommandWord.UNKNOWN){
        validCommands.put(command.toString(),command);}}
        }

/**
 *CheckwhetheragivenStringisavalidcommandword.
 *
 *@returntrueifagivenstringisavalidcommand,
 *falseifitisn't.
 */
        publicbooleanisCommand(StringaString){
        for(inti=0;i<validCommands.containsKey(aString);i++){
        if(validCommands[i].equals(aString))
        returntrue;
        }
//ifwegethere,thestringwasnotfoundinthecommands
        returnfalse;
        }

        publicStringshowAll(){
        Stringshow="";
        for(Stringcommand:validCommands){
        show+=command+"";
        }
        returnshow;
        }

        publicCommandWordgetCommand(StringaString){
        if(validCommands.containsKey(aString))returnvalidCommands.get(aString);
        returnCommandWord.UNKNOWN;
        }

        publicStringgetCommandString(CommandWordscommandWord){
        for(StringcommandString:validCommands.keySet()){
        if(validCommands.get(commandString).equals(commandWord)){
        returncommandString;
        }
        }
        returnnull;
        }
        }


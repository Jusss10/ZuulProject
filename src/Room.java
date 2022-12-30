import java.util.ArrayList;
import java.util.HashMap;


public class Room{
    private String description;
    private HashMap<String,Room> exits;
    private ArrayList<Item> items;

    public Room(String description){
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
    }

    public Room getExit(String direction){
        return exits.get(direction);
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void setExit(String direction,Room neighbor){
        exits.put(direction,neighbor);
    }
    public String getDescription(){
        return description;
    }
    public String getExitString(){
        String returnString="U look around and use an exit";
        for(String direction : exits.keySet()){
        returnString+= " "+ direction;
        }
        System.out.println("+-----------------------------------------------------------------------------+");
        return returnString;
        }
    public String getItemsString(){
        if(!items.isEmpty()){
        String returnString="containsitems:\n";
        for(Item item : items){returnString+=""+ item.getLongDescription()+"\n";}
            return returnString;
        }
        return"";
    }
    public String getLongDescription(){
        return description + getItemsString()+"\n"+getExitString();
    }
    public boolean hasItem(String itemName){
        return false;
    }
    public Item getItem(String itemName){
        return null;
    }
}


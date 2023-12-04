import java.util.ArrayList;
import java.util.HashMap;


public class Room{
    private String description;
    private HashMap<String,Room> exits;
    private ArrayList<Item> items;
    private Item key;

    public Room(String description, Item key){
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
        this.key = key;
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
        String returnString="You look around and see an exit";
        for(String direction : exits.keySet()){
        returnString+= " "+ direction;
        }
        System.out.println("+-----------------------------------------------------------------------------+");
        return returnString;
        }

    public String getLongDescription() {
        StringBuilder descriptionBuilder = new StringBuilder(description);

        if (!items.isEmpty()) {
            descriptionBuilder.append("\nAround you u see:\n");
            for (Item item : items) {
                descriptionBuilder.append("- ").append(item.getLongDescription()).append("\n");
            }
        }

        descriptionBuilder.append(getExitString());

        return descriptionBuilder.toString();
    }

    public boolean hasItem(String itemName){
        return false;
    }
    public Item getItem(String itemName){
        return null;
    }
}


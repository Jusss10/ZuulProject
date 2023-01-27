import java.util.ArrayList;

public class Player {
    private Item item;
    private Room currentRoom;
    private final String name;
    private ArrayList<Room> history;

    public Player(String name,Room room){
        this.currentRoom = room;
        this.name= name;
        history = new ArrayList<>();
    }

    public boolean take(String itemName){
        if(currentRoom.hasItem(itemName)){
            item= currentRoom.getItem(itemName);
            return true;
        }
        return false;
    }

    public Room takeLastRoomFromHistory(){
        if (history.size() == 0) return null;
        return history.remove(history.size() - 1);
    }

    public void addRoomToHistory(Room room){
        history.add(room);
    }
}

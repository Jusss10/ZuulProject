import java.util.ArrayList;

public class Player {
    private Item item;
    private Room currentRoom;
    private final String name;
    private ArrayList<Room> history;
    private Inventory inventory;

    public Player(String name,Room room){
        this.currentRoom = room;
        this.name= name;
        history = new ArrayList<>();
        inventory = new Inventory();
    }

    public boolean take(String itemName) {
        // Check if the current room has the specified item
        if (currentRoom.hasItem(itemName)) {
            // Get the item from the current room
            Item item = currentRoom.getItem(itemName);

            // Add the item to the player's inventory
            inventory.addItem(item);

            // Remove the item from the current room
            currentRoom.removeItem(item);

            // Return true indicating successful item retrieval
            return true;
        } else {
            // Return false indicating the item was not found in the room
            return false;
        }
    }


    public Room takeLastRoomFromHistory(){
        if (history.size() == 0) return null;
        return history.remove(history.size() - 1);
    }

    public void addRoomToHistory(Room room){
        history.add(room);
    }
}

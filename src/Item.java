public class Item{

    private String description;
    private String name;

    public Item(String name,String description){
        this.name = name;
        this.description = description;
    }

        public String getDescription(){
        return description;
        }

        public void setDescription(String description){
        this.description=description;
        }

    public String getLongDescription() {
        return name + " " + description + " with weight of:";
    }

}

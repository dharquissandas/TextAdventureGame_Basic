import java.util.ArrayList;

public class Player implements Entity {
    private static final int DEFAULT_HEALTH = 30;
    public GameGUI gameGUI;
    private ArrayList<Weapons> inventory;
    private int health;
    private String name;

    public Player(GameGUI gameGUI){
        inventory = new ArrayList<Weapons>();
        this.health = DEFAULT_HEALTH;
        this.gameGUI = gameGUI;
    }

    //Inventory
    public void listInventory(){
        for(int i = 0; (i < inventory.size()-1); i++){
            gameGUI.getDisplay().append((i+1)+". "+ inventory.get(i));
        }
    }

    public void listWeapons(){
        for(int i = 0; i < inventory.size() ; i++){
            gameGUI.getDisplay().append("\n"+inventory.get(i).getName()+ " | Strength: " + inventory.get(i).getStrength());
        }
    }

    public void addToInventory(Weapons e){
        inventory.add(0,e);
        String Weaponname = e.getName();
        if(!Weaponname.equals("claws")){
            gameGUI.getDisplay().append("\nYOU RECIEVED A " + Weaponname.toUpperCase());
        }
        else{
            gameGUI.getDisplay().append("\nYOU RECIEVED " + Weaponname.toUpperCase());
        }
    }

    public void addToInventoryDiscrete(Weapons e){
        inventory.add(0,e);
    }

    public Boolean doesWeaponExist(String itemname){
        boolean exists = false;
        for(int i = 0; (i < inventory.size()); i++){
            if(inventory.get(i).getName().equals(itemname)){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public void removeFromInventory(Weapons e){
        if(inventory.contains(e)){
            inventory.remove(e);
        }
    }

    //Player Actions
    public String getName() {
        return name;
    }

    public void die(){
        setHealth(0);
        gameGUI.getDisplay().append("\nYou died!");
        gameGUI.getDisplay().append("\nGAME OVER!");
        
    }

    public ArrayList<Weapons> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Weapons> inventory) {
        this.inventory = inventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}

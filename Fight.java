import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Fight {
    private Player player;
    private Enemies enemy;

    private JButton run;
    private JTextArea display;
    private JTextField userEntry;
    private int level;

    public Fight(Player p, Enemies e, int level, JTextArea display, JButton run, JTextField userEntry) {
        player = p;
        enemy = e;
        this.level = level;

        this.run = run;
        this.display = display;
        this.userEntry = userEntry;
    }

    public void fightScene(){
        if(level == 0){
            if(player.doesWeaponExist("Sword")){
                display.append("\nYou have killed Cayden using your sword");
                player.setHealth(player.getHealth() - enemy.attack());
                display.append("\nYour health is now " +player.getHealth());
            }
        }
        else if(level == 1){
            if(player.doesWeaponExist("Spear")){
                display.append("\nYou have killed Gremlin using your Spear");
                player.setHealth(player.getHealth() - enemy.attack());
                display.append("\nYour health is now " + player.getHealth());
            }
        }
        else if(level == 2){
            if(player.doesWeaponExist("Claws")){
                display.append("\nYou have killed Gremlin using your Spear");
                player.setHealth(player.getHealth() - enemy.attack());
                display.append("\nYour health is now " + player.getHealth());
            }
        }
    }    
}
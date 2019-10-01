import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Listener implements ActionListener {
    private JTextField userEntry;
    private JTextArea display;
    private JButton run;
    private JButton inventorybutton;
    private Player player;
    private int level;

    public Listener(JButton run, JButton inventorybutton, JTextArea display, JTextField userEntry, Player player, int level){
        this.display = display;
        this.run = run;
        this.inventorybutton = inventorybutton;
        this.userEntry = userEntry;
        this.player = player;
        this.level = level;
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        Object a = e.getSource();
        String action = userEntry.getText();

        if(level == 0){
            if (a == run){
                if(action.equals("cayden") || action.equals("Cayden")){
                    display.append("\n" + StoryElements.cayden());
                    Enemies cayden = new Warrior("cayden", 10, 5, "warrior");
                    Fight fight1 = new Fight(player, cayden, level, display, run, userEntry);
                    fight1.fightScene();
                    Weapons spear = new Spear(5,"Spear");
                    player.addToInventory(spear);
                    display.append("\n" + StoryElements.fightChoice());
                    level++;
                    userEntry.setText("");
                } 
                else if(action.equals("alatar") || action.equals("Alatar")){
                    display.append("\n" + StoryElements.alatar());
                    display.append("\nYou are too weak");
                    userEntry.setText("");
                    player.die();
                }
                else if(action.equals("gremlin")|| action.equals("Gremlin")){
                    display.append("\n" + StoryElements.gremlin());
                    display.append("\nYou are too weak");
                    userEntry.setText("");
                    player.die();
                }
                else if (action.equals("exit")) {
                    Save.outputFile(level, player.getHealth());
                    userEntry.setText("");
                    System.exit(0);
                }
            }
        } 

        if (level == 1) {
            if (a == run){
                if(action.equals("alatar")){
                    display.append("\n" + StoryElements.alatar());
                    display.append("\nYou are too weak");
                    userEntry.setText("");
                    player.die();
                }
                else if(action.equals("gremlin")){
                    display.append("\n" + StoryElements.gremlin());
                    Enemies gremlin = new Monster("gremlin", 10, 10, "monster");

                    Fight fight1 = new Fight(player, gremlin, level, display, run, userEntry);
                    fight1.fightScene();
                    Weapons claws = new Claws(8,"Claws");
                    player.addToInventory(claws);
                    display.append("\n" + StoryElements.fightChoice());
                    userEntry.setText("");
                    level++;
                }
                else if (action.equals("exit")) {
                    Save.outputFile(level, player.getHealth());
                    userEntry.setText("");
                    System.exit(0);
                }
            }
        }

        if (level == 2) {
            if (a == run){
                if(action.equals("alatar")){
                    display.append("\n" + StoryElements.alatar());
                    Enemies alatar = new Magician("alatar", 20, 10, "magician");
                    Fight fight1 = new Fight(player, alatar, level, display, run, userEntry);
                    fight1.fightScene();
                    display.append("After a heated battle that no ordinary human can sustain...");
                    display.append("\nYou Win!");
                    display.append("\nWe knew we could always count on you");
                    userEntry.setText("");
                }
                else if (action.equals("exit")) {
                    userEntry.setText("");
                    System.exit(0);
                }
            }
        }
    }
}
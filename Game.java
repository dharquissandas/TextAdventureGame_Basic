import java.io.File;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Game {
    public GameGUI gameGUI;
    public Player player;
    
    private JTextArea display;
    private JButton run;
    private JButton inventoryButton;
    private JTextField userEntry;

    public Game(){
        gameGUI = new GameGUI(player);
        player = new Player(gameGUI);
        display = gameGUI.getDisplay();
        run = gameGUI.getRun();
        userEntry = gameGUI.getUserEntry();
        inventoryButton = gameGUI.getInventoryButton();

        gameInit();
    }

    public void gameInit(){
        int level = 0;
        File savefile = new File("saveFile.txt");
        if(savefile.exists()){
            level = Save.inputFile(player);
            if(level == 0){
                Weapons sword = new Sword(2, "Sword");
                player.addToInventoryDiscrete(sword);
            }
            else if(level == 1){
                Weapons sword = new Sword(2, "Sword");
                Weapons spear = new Spear(5, "Spear");
                player.addToInventoryDiscrete(sword);
                player.addToInventoryDiscrete(spear);
            }
            else if(level == 2){
                Weapons sword = new Sword(2, "Sword");
                Weapons spear = new Spear(5, "Spear");
                Weapons claws = new Claws(8, "Claws");
                player.addToInventoryDiscrete(sword);
                player.addToInventoryDiscrete(spear);
                player.addToInventoryDiscrete(claws);
            }
        }
        else{
            display.setText(StoryElements.introScreen());
            Weapons sword = new Sword(2, "Sword");
            player.addToInventory(sword);
        }

        display.append(StoryElements.fightChoice());

        Listener l = new Listener(run, inventoryButton, display, userEntry, player, level);
        InventoryListener iv = new InventoryListener(inventoryButton, display, player);
        run.addActionListener(l);
        inventoryButton.addActionListener(iv);
    }
    
    public Player getPlayer() {
        return player;
    }


    
}   


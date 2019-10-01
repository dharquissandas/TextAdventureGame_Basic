import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class InventoryListener implements ActionListener {
    private JButton inventoryButton;
    private JTextArea display;
    private Player player;
    private QuickSort quickSort;

    public InventoryListener (JButton inventoryButton, JTextArea display, Player player){
        this.display = display;
        this.inventoryButton = inventoryButton;
        this.player = player;
        quickSort = new QuickSort();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object a = e.getSource();
        if(a == inventoryButton){


            // purely for testing purposes
            // Weapons z = new Sword(1, "1");
            // player.addToInventory(z);
            // Weapons y = new Sword(10, "10");
            // player.addToInventory(y);
            // Weapons x = new Sword(2, "2");
            // player.addToInventory(x);
            // Weapons w = new Sword(6, "6");
            // player.addToInventory(w);
            // Weapons v = new Sword(4, "4");
            // player.addToInventory(v);
            // purely for testing purposes



            quickSort.quickSort(player.getInventory());
            player.listWeapons();
        }
    }
}
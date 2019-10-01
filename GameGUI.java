import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameGUI extends JFrame {
    private JTextField userEntry;
    private JTextArea display;
    private JButton run;
    private JButton inventory;

    public GameGUI(Player player) {
        super("Adventure Game");
        setSize(792, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        setResizable(false);
        
        display = new JTextArea("", 20, 70);
        display.setEditable(false);
        userEntry = new JTextField("", 45);
        run = new JButton("Enter Command");
        inventory = new JButton("Inventory");

        JScrollPane scrollPane = new JScrollPane(display);
        JScrollBar sb = scrollPane.getVerticalScrollBar();
        sb.setValue(sb.getMaximum());
        
        setLocationRelativeTo(null);
        
        add(scrollPane, BorderLayout.CENTER);        
        add(userEntry);
        add(run);
        add(inventory);
    }

    // Getters
    public JTextField getUserEntry() {
        return userEntry;
    }

    public JTextArea getDisplay() {
        return display;
    }

    public JButton getRun() {
        return run;
    }

    public JButton getInventoryButton() {
        return inventory;
    }
}
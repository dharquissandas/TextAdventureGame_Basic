import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Save{
    public static void outputFile(int level, int health){
        try{
            PrintWriter savefile = new PrintWriter(new FileWriter("saveFile.txt"));
            savefile.println(level);
            savefile.println(health);
            savefile.close();
        }
        catch(IOException e){
            System.exit(0);
        }
    }

    public static int inputFile(Player player){
        int level =  0;
        int health = 0;
        try{    
            BufferedReader savefile = new BufferedReader(new FileReader("saveFile.txt"));
            String leveltext = savefile.readLine();
            String healthtext = savefile.readLine();
            level = Integer.parseInt(leveltext);
            health = Integer.parseInt(healthtext);
            player.setHealth(health);
            savefile.close();
        }
        catch(IOException e){
            System.exit(0);
        }

        return level;
    }
}
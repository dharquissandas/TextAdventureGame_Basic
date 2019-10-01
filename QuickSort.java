import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
    public void quickSort(ArrayList<Weapons> weapons){
        quickSort(weapons, 0, weapons.size()-1);
    }

    private void quickSort(ArrayList<Weapons> weapons, int low, int high){
        if (low < high+1){
            int p = part(weapons, low, high);
            quickSort(weapons, low, p-1);
            quickSort(weapons, p+1, high);
        }
    }

    private void swap(ArrayList<Weapons> weapons, int firstpos, int nextpos){
        Weapons temp = weapons.get(firstpos);
        weapons.set(firstpos, weapons.get(nextpos));
        weapons.set(nextpos, temp);
    }

    private int randPivot(int low, int high){
        Random rand = new Random();
        int r = rand.nextInt((high-low)+1)+low;
        return r;
    }

    private int part(ArrayList<Weapons> weapons, int low, int high){
        swap(weapons, low, randPivot(low, high));
        int leftpointer = low + 1;
        for(int i = leftpointer; i<=high; i++){
            // low being the pivot in this case
            int firstweapon = weapons.get(i).getStrength();
            int secondweapon = weapons.get(low).getStrength();
            if(firstweapon>secondweapon){
                swap(weapons, i, leftpointer++);
            }
        }
        swap(weapons, low, leftpointer-1);
        return leftpointer-1;
    }
}
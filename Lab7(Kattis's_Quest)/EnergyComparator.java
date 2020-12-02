//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph

import java.util.Comparator;
public class EnergyComparator implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2){
        if(i1 > i2){
            return 1;
        } else if(i1 < i2){
            return -1;
        } else{
            return 0;
        }
    }
}

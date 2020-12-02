//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph

import java.util.Comparator;

public class CanonComparator implements Comparator<Canon> {
    public int compare(Canon c1, Canon c2){
        if(c1.distance > c2.distance){
            return 1;
        } else if(c1.distance == c2.distance){
            return 0;
        } else{
            return -1;
        }
    }
}

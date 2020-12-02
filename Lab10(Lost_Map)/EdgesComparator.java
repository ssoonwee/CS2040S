//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph

import java.util.Comparator;
public class EdgesComparator implements Comparator<Edges>{
    public int compare(Edges e1, Edges e2){
        if(e1.cost > e2.cost){
            return 1;
        } else if(e1.cost == e2.cost){
            return 0;
        } else{
            return -1;
        }
    }
}

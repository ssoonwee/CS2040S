//Name: Song Soon Wee
//Student No.: A0200378L

import java.util.Comparator;
public class CoordinateCostComparator implements Comparator<Coordinate>{
    public int compare(Coordinate one, Coordinate two){
        if(one.cost > two.cost){
            return 1;
        } else if (one.cost == two.cost){
            return 0;
        } else {
            return -1;
        }
    }
}

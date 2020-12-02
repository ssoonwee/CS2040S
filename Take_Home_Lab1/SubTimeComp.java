//Name: Song Soon Wee
//Student No.: A0200378L

import java.util.Comparator;

public class SubTimeComp implements Comparator<Runner>{
    public int compare(Runner a, Runner b){
        if(a.getSubTime() > b.getSubTime()){
            return 1;
        } else if(a.getSubTime() == b.getSubTime()){
            return 0;
        } else{
            return -1;
        }
    }
}

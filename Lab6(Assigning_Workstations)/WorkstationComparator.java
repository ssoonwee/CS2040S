//Name: Song Soon Wee
//Student No.: A0200378L
//Collaboator: Neo Soon keat, Nicole Joseph
import java.util.Comparator;

public class WorkstationComparator implements Comparator<Workstation> {
    public int compare(Workstation w1, Workstation w2){
        if(w1.availToUseTime< w2.availToUseTime){
            return -1;
        } else if(w1.availToUseTime > w2.availToUseTime){
            return 1;
        } else{
            return 0;
        }
    }
}

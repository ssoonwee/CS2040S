//Name: Song Soon Wee
//Student No.: A0200378L
//Collaboator: Neo Soon keat, Nicole Joseph
import java.util.Comparator;

public class ResearcherComparator implements Comparator<Researcher> {
    public int compare(Researcher r1, Researcher r2){
        if(r1.startTime < r2.startTime){
            return -1;
        } else if(r1.startTime > r2.startTime){
            return 1;
        } else{
            return 0;
        }
    }
}

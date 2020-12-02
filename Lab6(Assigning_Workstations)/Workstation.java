//Name: Song Soon Wee
//Student No.: A0200378L
//Collaboator: Neo Soon keat, Nicole Joseph
public class Workstation {
    public int startTime;
    public int availToUseTime;
    public int expectedLockTime;
    public Workstation(int startTime, int usedTime, int bufferTime){
        this.startTime = startTime;
        this.availToUseTime = usedTime;
        this.expectedLockTime = bufferTime + usedTime;
    }
}

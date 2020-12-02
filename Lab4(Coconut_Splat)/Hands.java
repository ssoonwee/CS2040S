//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph

public class Hands {
    public int playerNo;
    public int state;
    public boolean isMerged;
    public Hands(int playerNo, int state, boolean isMerged){
        this.playerNo = playerNo;
        this.state = state;
        this.isMerged = isMerged;
    }

    public int getHandPlayer(){
        return this.playerNo;
    }

    public int getHandState(){
        return this.state;
    }

    public void setHandState(int state){
        this.state = state;
    }

    public void setMergeState(boolean isMerged){
        this.isMerged = isMerged;
    }
    public boolean getMerged(){
        return this.isMerged;
    }
}

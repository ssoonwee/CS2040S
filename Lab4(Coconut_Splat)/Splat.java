//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph

import java.util.ArrayDeque;
import java.util.Deque;

public class Splat {
    public static void main(String[] args){
        //State 4: Fist, State 3: Double hands, State 2: Single Hand, State 1: No Hand
        Kattio reader = new Kattio(System.in);
        Deque<Hands> handList = new ArrayDeque<Hands>();
        int syllabes = reader.getInt();
        int players = reader.getInt();
        for(int i = 1; i <= players; i++){
            handList.add(new Hands(i, 4, true));
        }
        while (handList.size() > 1) {
            int state = 0;
            int playerNo = 0;
            if(syllabes > 1){
                for(int i = 0; i < syllabes - 1; i++){
                    handList.addLast(handList.removeFirst()); //Push front to back3
                    if(i == syllabes - 2){
                        state = handList.peekFirst().getHandState();
                        playerNo = handList.peekFirst().getHandPlayer();
                    }
                }
            } else{
                state = handList.peekFirst().getHandState();
                playerNo = handList.peekFirst().getHandPlayer();
            }
            if(state == 4){ //4 -> 3
                handList.peekFirst().setHandState(3); //Set this current hand to state 3.
                handList.peekFirst().setMergeState(false);
                handList.addFirst(new Hands(playerNo, 3, false)); //Add an additional hand to the front of the queue
            } else if(state == 3){
                handList.peekFirst().setHandState(2); //Set 2 and then move it to the back.
                handList.addLast(handList.removeFirst());
            } else if(state == 2) {
                handList.removeFirst();
            }
        }
        System.out.println(handList.peekFirst().getHandPlayer());
    }
}

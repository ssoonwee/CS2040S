//Name: Song Soon Wee
//Student Number: A0200378L

import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Driver {
    public static void main(String [] args){
        Kattio reader = new Kattio(System.in);
        int noOps = reader.getInt(); //Get number of operations
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Teque newTeque = new Teque(noOps);
        for(int i = 0; i < noOps; i++){
            String funcCall = reader.getWord();
            int data = reader.getInt();
            if(funcCall.equals(new String("push_back"))){
                newTeque.pushBack(data);
            } else if (funcCall.equals(new String("push_front"))){
                newTeque.pushFront(data);
            } else if (funcCall.equals(new String("push_middle"))){
                newTeque.pushMiddle(data);
            } else{
                writer.println(newTeque.getIndex(data));
            }
        }
        writer.flush();
        writer.close();
    }
}
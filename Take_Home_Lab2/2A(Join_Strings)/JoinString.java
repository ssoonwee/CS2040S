//Name: Song Soon Wee
//Student Number: A0200378L

import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class JoinString{
    public static void main(String [] args){
        Kattio reader = new Kattio(System.in);
        int savedIndex = 0;
        int noString = reader.getInt();
        CustomDLL[] dllObj = new CustomDLL[noString];
        for(int i = 0; i<noString; i++){
            dllObj[i] = new CustomDLL(reader.getWord());
        }
        for(int j = 0; j < noString - 1; j++){
            int firstInd = reader.getInt();
            int secondInd = reader.getInt();
            dllObj[firstInd - 1].append(dllObj[secondInd - 1]);
            dllObj[secondInd - 1] = new CustomDLL(""); //Initialise to empty.
            savedIndex = firstInd - 1;
        }
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringBuilder sb = new StringBuilder();
        while(dllObj[savedIndex].current.next != null){
            sb.append(dllObj[savedIndex].current);
            dllObj[savedIndex].current = dllObj[savedIndex].current.next;
        }
        sb.append(dllObj[savedIndex].current);
        writer.println(sb.toString());
        writer.flush();
        writer.close();
    }
}
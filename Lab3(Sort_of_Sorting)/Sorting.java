//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.StringBuilder;

public class Sorting{
    public static void main(String args[]){
        Kattio reader = new Kattio(System.in);
        int input = 1;
        StringBuilder sb = new StringBuilder();
        while(input == 1){
            int noNames = reader.getInt();
            if(noNames == 0){
                break;
            }
            List<String> names = new ArrayList<String>();
            for(int i = 0; i < noNames; i++){
                names.add(reader.getWord());
            }
            names.sort(Comparator.comparing(s->s.substring(0,2)));
            for(int j = 0; j < noNames; j++){
                sb.append(names.get(j)).append("\n");
                if(j == noNames -1){
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());
        reader.close();
    }
}
//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedReader;
public class Driver {
    public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> mapper = new HashMap<>();
        int combins = Integer.parseInt(reader.readLine());
        for(int i = 0; i < combins; i++){
            String[] combinArr = reader.readLine().split(" "); //read each line that is separated by a split
            Arrays.sort(combinArr); //Sort array from smallest to biggest
            String joinedString = String.join("", combinArr);
            mapper.put(joinedString, mapper.getOrDefault(joinedString,0) + 1);
        }
        int highestSeen = 0;
        int total = 0;
        for(Integer count : mapper.values()) {
            if(count > highestSeen){
                highestSeen = count;
                total = 0 +  highestSeen;
            } else if(count == highestSeen){
                total = total + count;
            }
        }
        System.out.println(total);
    }
}

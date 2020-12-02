//Name: Song Soon Wee
//Student No.: A0200378L

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class RelayTeam {
    public static void main(String args[]) throws IOException{
        Kattio reader = new Kattio(System.in);
        List <Runner> subRunners = new ArrayList<Runner>(); 
        int noRunners = reader.getInt();
        double bestTime = 9999;
        for(int i = 0; i < noRunners; i++){
            String name = reader.getWord();
            double first_Time = reader.getDouble();
            double sub_Time = reader.getDouble();
            subRunners.add(i, new Runner(name, first_Time, sub_Time));
        }
        Collections.sort(subRunners, new SubTimeComp()); //Sort by SubTime
        List <Runner> finalResult = new ArrayList<Runner>(); 
        for(int i = 0; i < subRunners.size(); i++){ //Choose possible cases
            List <Runner> testResult = new ArrayList<Runner>();
            Runner firstRunner = subRunners.get(i);
            testResult.add(firstRunner);
            int count = 0;
            while(testResult.size() < 4){ //Compare other mid runners with first runner
                Runner nextRunner = subRunners.get(count);
                if(!nextRunner.equals(firstRunner)){
                    testResult.add(nextRunner);
                }
                count = count + 1;
            }
            double teamTime = 0;
            for(int j = 0; j < testResult.size(); j++){ //Add timings for all runners
                if(j == 0){
                    teamTime = teamTime + testResult.get(0).getFirstTime();
                } else{
                    teamTime = teamTime + testResult.get(j).getSubTime();
                }
            }
            if(teamTime < bestTime){ //Compare timings with best time and add the best to hall of fame. 
                bestTime = teamTime;
                for(int k = 0; k < 4; k++){
                    if(finalResult.size() < 4){
                        finalResult.add(testResult.get(k));
                    } else{
                        finalResult.set(k, testResult.get(k));
                    }
                }
            }
        }
        System.out.println(bestTime);
        for(int i = 0; i < 4; i++){
            System.out.println(finalResult.get(i).getName());
        }
    }
}
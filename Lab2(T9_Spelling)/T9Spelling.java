//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborators: Neo Soon Keat, Nicole Joseph

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.lang.StringBuilder;
import java.io.PrintWriter;

public class T9Spelling {
    public static void main(String arg[]) throws Exception{
        //Declare a reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Declare a Hashmap that maps respective key to values.
        HashMap<Integer, String> caseMap = new HashMap<Integer, String>();
        caseMap.put(2, "abc"); //96 < x < 100
        caseMap.put(3, "def"); //99 < x < 103
        caseMap.put(4, "ghi"); //102 < x < 106
        caseMap.put(5, "jkl");
        caseMap.put(6, "mno");
        caseMap.put(7, "pqrs");
        caseMap.put(8, "tuv");
        caseMap.put(9, "wxyz");
        caseMap.put(0, " ");
        int cases = 0;
        List <String> caseList = new ArrayList<String>(); 
        try{
            cases = Integer.parseInt(reader.readLine());
            for(int i = 0; i < cases; i++){
                caseList.add(reader.readLine());
            }
        } catch(IOException exep){
            exep.printStackTrace();
        } finally{
            for(int j = 0; j < cases; j++){
                String inputTest = new String(caseList.get(j));
                int testSize = inputTest.length();
                StringBuilder result = new StringBuilder();
                if(j > 0){
                    result.append("\n");
                }
                result.append("Case #").append(String.valueOf(j+1)).append(": ");
                int prevIndex = 0;
                for(int k = 0; k < testSize; k++){
                    char currChar = inputTest.charAt(k);
                    int currCharVal = currChar;
                    int count = 0; //Count number of times need to press
                    String testCase;
                    int index = 0;
                    if(currCharVal < 100 && currCharVal > 96){
                        testCase = caseMap.get(2);
                        index = 2;
                    } else if(currCharVal < 103 && currCharVal > 99){
                        testCase = caseMap.get(3);
                        index = 3;
                    } else if(currCharVal < 106 && currCharVal > 102) {
                        testCase = caseMap.get(4);
                        index = 4;
                    } else if(currCharVal < 109 && currCharVal > 105) {
                        testCase = caseMap.get(5);
                        index = 5;
                    } else if(currCharVal < 112 && currCharVal > 108) {
                        testCase = caseMap.get(6);
                        index = 6;
                    } else if(currCharVal < 116 && currCharVal > 111) {
                        testCase = caseMap.get(7);
                        index = 7;
                    } else if(currCharVal < 119 && currCharVal > 115) {
                        testCase = caseMap.get(8);
                        index = 8;
                    } else if(currCharVal < 123 && currCharVal > 118) {
                        testCase = caseMap.get(9);
                        index = 9;
                    } else {
                        testCase = caseMap.get(0);
                    }
                    if(k > 0){
                        if(index == prevIndex){
                            result.append(" ");
                        }
                    }
                    prevIndex = index; //Store this value for next loop reference to prev Index. 
                    for (int m = 0; m < testCase.length(); m++){ 
                        char currTestChar = testCase.charAt(m);
                        if(currTestChar == currChar){
                            count = m;
                            for(int n = 0; n <= count; n++){
                                result.append(String.valueOf(index));
                            }
                        } else{
                            continue;
                        }
                    }
                }
                try{
                    PrintWriter writer = new PrintWriter(System.out);
                    writer.print(result.toString());
                    writer.flush();
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }      
}

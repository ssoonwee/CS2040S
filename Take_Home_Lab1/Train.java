//Name: Song Soon Wee
//Student No.: A0200378L

import java.util.Scanner;

public class Train{
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int trainstops = sc.nextInt();
        int currCap = 0;
        boolean consistent = true;
        String [] result = new String [] {"possible", "impossible"};
        for(int i = 0; i < trainstops; i++){
            int tempLeft = sc.nextInt();
            int tempEnter = sc.nextInt();
            int tempStay = sc.nextInt();
            if (i == 0){ //When service starts, there should not be anyone leaving the train.
                if(tempLeft > 0){
                    consistent = false;
                }
                currCap = currCap + tempEnter;
                int extraSpace = capacity - currCap;
                    if(extraSpace < 0){
                        if(extraSpace != -tempStay){
                            consistent = false;
                        }
                    } else if(extraSpace > 0){
                        if(tempStay > 0){ //If there is extra space and someone waiting, it is wrong.
                            consistent = false;
                        }
                    }
            } else if (i == trainstops - 1){
                currCap = currCap + tempEnter;
                currCap = currCap - tempLeft;
                if(currCap != 0 || tempStay > 0){
                    consistent = false;
                } 
            } else{
                currCap = currCap + tempEnter;
                currCap = currCap - tempLeft;
                if(currCap > capacity || currCap < 0){
                    consistent = false;
                }
                int extraSpace = capacity - currCap;
                if(extraSpace < 0){
                    if(extraSpace != -tempStay){
                        consistent = false;
                    }
                } else if(extraSpace > 0){
                    if(tempStay > 0){ //If there is extra space and someone waiting, it is wrong.
                        consistent = false;
                    }
                }
            }
        }
        if(consistent){
            System.out.println(result[0]);
        } else{
            System.out.println(result[1]);
        }
        sc.close();
    }
}
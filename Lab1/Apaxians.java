import java.util.Scanner;

public class Apaxians {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String temp = new String(sc.next());
        String newString = new String();
        for(int i = 0; i < temp.length(); i++){
            char prevChar;
            if(i > 0){
                prevChar = temp.charAt(i-1);
                if(temp.charAt(i) == prevChar){
                    continue;
                } else{
                    newString = newString + temp.charAt(i);
                }
            } else{
                    newString = newString + temp.charAt(i);
            }
        }
        sc.close();
        System.out.println(newString);
    }
}
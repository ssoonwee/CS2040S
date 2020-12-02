import java.util.Scanner;

public class Fizzbuzz {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int firstDiv = sc.nextInt();
        int secondDiv = sc.nextInt();
        int maxLim = sc.nextInt();
        for(int i = 1; i <= maxLim; i++){
            if(i % firstDiv == 0 && i % secondDiv == 0){
                System.out.println("FizzBuzz");
            } else if(i % firstDiv == 0){
                System.out.println("Fizz");
            } else if(i % secondDiv == 0){
                System.out.println("Buzz");
            } else{
                System.out.println(i);
            }
        }
        sc.close();
    }
}
import java.util.Scanner;

public class Driver{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        int endX = scanner.nextInt();
        int endY = scanner.nextInt();
        int energy = scanner.nextInt();
        scanner.close();
        int diffX = Math.abs(startX - endX);
        int diffY = Math.abs(startY - endY);
        if(diffX + diffY > energy){
            System.out.println("N");
        } else{
            System.out.println("Y");
        }
    }
}
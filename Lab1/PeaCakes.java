//Name: Song Soon Wee
//Student Number: A0200378L
//Collaborators: Neo Soon Keat

import java.util.Scanner;

public class PeaCakes{
    public static void main(String args[]){
        String firstRest= new String("");
        Scanner sc = new Scanner(System.in);
        int noOfRest = sc.nextInt();
        boolean isFirstRestFound = false;
        for(int i = 0; i < noOfRest; i++){
            int items = sc.nextInt();
            sc.nextLine();
            String restName = sc.nextLine();
            boolean isPeaFound = false;
            boolean isPanCakeFound = false;
            for(int j = 0; j < items; j++){
                String menuItems = sc.nextLine();
                if(menuItems.equals(new String("pancakes"))){
                    isPanCakeFound = true;
                } else if(menuItems.equals(new String("pea soup"))){
                    isPeaFound = true;
                }
            }
            if (isPanCakeFound == true && isPeaFound == true){
                firstRest = restName;
                isFirstRestFound = true;
                System.out.println(firstRest);
                break;
            }
        }
        sc.close();
        if(!isFirstRestFound){
            System.out.println("Anywhere is fine I guess");
        }
        sc.close();
    }
}
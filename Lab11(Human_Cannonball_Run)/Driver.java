//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph

import java.util.PriorityQueue;

public class Driver{

    static double [] bestTime;
    static boolean []isVisited;
    static double runTime;
    static int canon;
    public static void main(String[] args){
        Kattio reader = new Kattio(System.in);
        double fromX = reader.getDouble();
        double fromY = reader.getDouble();
        double toX = reader.getDouble();
        double toY = reader.getDouble();
        canon = reader.getInt();
        double [][] cost = new double[canon+2][canon+2]; //Consist of all vertex inc start, cannons and end 
        double [][] cannonCord = new double[canon][2];
        bestTime = new double[canon + 2]; //Edges
        isVisited = new boolean[canon + 2];
        for(int i = 0; i < canon; i++){
            double xCord = reader.getDouble();
            double yCord = reader.getDouble();
            cannonCord[i][0] = xCord;
            cannonCord[i][1] = yCord;
            bestTime[i] = 1000000000;
            isVisited[i] = false;
        }
        bestTime[canon] = 1000000000;
        bestTime[canon + 1] = 1000000000;
        isVisited[canon] = false;
        isVisited[canon + 1] = false;
        //Computing Time from Source to resp cannon..., canon to cannon and then from resp cannon to dest..
        //Start will use vertex 0 while end will use vertex 1.
        for(int j = 0; j < canon; j++){
            double startToCanon = Math.hypot(Math.abs(fromX - cannonCord[j][0]), Math.abs(fromY - cannonCord[j][1])); //Cost from Source to can
            cost[j+2][0] = (Math.abs(startToCanon-50)/5) + 2; //Cannon to source signify rocket launch.
            cost[0][j+2] = startToCanon / 5; //Source to resp cannon signify running over.
            for(int k = 0; k < canon; k++) { //Cost from cannon to cannons. 
                double cannonToCannon =Math.hypot(Math.abs(cannonCord[k][0] - cannonCord[j][0]), Math.abs(cannonCord[k][1] - cannonCord[j][1]));
                cost[j+2][k+2] = Math.abs(cannonToCannon- 50) / 5 + 2;
                cost[k+2][j+2] = cost[j+2][k+2];
            }
            double canonToDest = Math.hypot(Math.abs(toX - cannonCord[j][0]), Math.abs(toY - cannonCord[j][1])); //Cost from Canon to Dest
            cost[j+2][1] = Math.abs(canonToDest-50)/5+2;
            cost[1][j+2] =  canonToDest / 5;
        }
        cost[0][1] = Math.hypot(Math.abs(toX - fromX), Math.abs(toY - fromY)) / 5; //Time taken to run from start to end...
        cost[1][0] = cost[0][canon + 1]; //Time taken from end to start... Same cost as both are running.
        search(cost);
        System.out.println(bestTime[1]);
    }

    public static void search(double[][] arr1){
        PriorityQueue<Canon> canonQueue = new PriorityQueue<>(new CanonComparator());
        canonQueue.add(new Canon(0, 0));
        while(!canonQueue.isEmpty()){
            Canon canonNode = canonQueue.poll();
            if(isVisited[canonNode.index] == true){
                continue;
            } else{
                for(int i = bestTime.length - 1; i > -1; i--){
                    double placeHolder = canonNode.distance + arr1[canonNode.index][i];
                    if (i != canonNode.index && isVisited[i] == false) {
                        if(placeHolder < bestTime[i]){
                            bestTime[i] = placeHolder;
                            canonQueue.add(new Canon(i, bestTime[i]));
                        } else{
                            continue;
                        }
                    }
                }
                isVisited[canonNode.index] = true;
            }
        }
    }
}
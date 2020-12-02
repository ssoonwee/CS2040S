//Name: Song Soon Wee
//Student No: A0200378L

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Runner{

    public static char[][] coordinates;
    public static int rows;
    public static int columns;
    public static int [][] groupRank;
    public static boolean [][] isVisited;
    public static final char BINARY = '0';
    public static final char DECIMAL = '1';
    public static void main(String []args) throws IOException{
        BufferedReader secReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String [] firstPhase = secReader.readLine().split(" ");
        rows = Integer.parseInt(firstPhase[0]);
        columns = Integer.parseInt(firstPhase[1]);
        coordinates = new char[rows][columns];
        groupRank = new int [rows][columns];
        isVisited = new boolean[rows][columns];
        int rank = 1;
        for(int i = 0; i < rows; i++){
            coordinates[i] = secReader.readLine().toCharArray(); //Get all coordinates
            for(int k = 0; k < columns; k++){
                groupRank[i][k] = 0;
                isVisited[i][k] = false;
            }
        }
        for(int j = 0; j < rows; j++){
            for(int k = 0; k < columns; k++){
                if(groupRank[j][k] == 0){
                    groupRank[j][k] = rank;
                    search(j,k, rank);
                    rank = rank + 1;
                }
            }
        }
        int queries = Integer.parseInt(secReader.readLine());
        int counter = 0;
        while(counter < queries){
            String [] coordValues = secReader.readLine().split(" ");
            int r1 = Integer.parseInt(coordValues[0]) - 1;
            int c1 = Integer.parseInt(coordValues[1]) - 1;
            int r2 = Integer.parseInt(coordValues[2]) - 1;
            int c2 = Integer.parseInt(coordValues[3]) - 1;
            if(groupRank[r1][c1] == groupRank[r2][c2]){
                if(coordinates[r1][c1] == BINARY){
                    writer.println("binary");
                } else{
                    writer.println("decimal");
                }
            } else{
                writer.println("neither");
            }
            counter++;
        }
        secReader.close();
        writer.flush();
        writer.close();
    }

    public static void search(int j, int k, int stepUp){
        Queue <Point> coordQueue = new ArrayDeque<>();
        coordQueue.add(new Point(j,k));
        int [] xDir = {1,-1,0,0};
        int [] yDir = {0,0,1,-1};
        while(!coordQueue.isEmpty()){
            Point curr = coordQueue.poll();
            int currX = curr.cordX;
            int currY = curr.cordY;
            if(isVisited[currX][currY] == true){
                continue;
            } else{
                isVisited[currX][currY] = true;
            }
            for(int i = 0; i < 4; i++){
                int nextX = currX + xDir[i];
                int nextY = currY + yDir[i];
                if(nextX < 0 || nextY < 0 || nextX >= rows || nextY >=columns){
                    continue; //Skip out of bounds
                } else if(coordinates[currX][currY] == coordinates[nextX][nextY]){
                    if(groupRank[nextX][nextY] < stepUp){
                        coordQueue.add(new Point(nextX, nextY));
                        groupRank[nextX][nextY] = stepUp;
                    } else {
                        continue;
                    }
                } else{
                    continue; //Conflicted zones... SKIP!
                }
            }
        }
    }
}
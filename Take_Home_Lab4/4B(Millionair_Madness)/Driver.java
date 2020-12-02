//Name: Song Soon Wee
//Student No.: A0200378L

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class Driver{

    public static int rows = 0;
    public static int columns = 0;
    public static int [][] coordHeight;
    public static int [][] distance;
    public static boolean [][] isVisited;
    
    public static void main(String []args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String [] firstPhase = reader.readLine().split(" ");
        rows = Integer.parseInt(firstPhase[0]);
        columns = Integer.parseInt(firstPhase[1]);
        coordHeight = new int[rows][columns];
        distance = new int[rows][columns];
        isVisited = new boolean[rows][columns];
        for(int i = 0; i < rows; i++){
            String [] secondPhase = reader.readLine().split(" ");
            for(int j = 0; j < columns; j++){
                if(i == 0 && j == 0){
                    distance[i][j] = 0;
                } else{
                    distance[i][j] = 1000000000; //MAXIMUM
                }
                coordHeight[i][j] = Integer.parseInt(secondPhase[j]);
                isVisited[i][j] = false;
            }
        }
        performSearch();
        writer.println(distance[rows-1][columns -1]);
        writer.flush();
        writer.close();
    }

    public static void performSearch(){
        PriorityQueue<Coordinate> cordQueue = new PriorityQueue<>(new CoordinateCostComparator());
        cordQueue.add(new Coordinate(0, 0, 0));
        int [] xDir = {1,-1,0,0};
        int [] yDir = {0,0,1,-1};

        while(!cordQueue.isEmpty()){
            Coordinate curr = cordQueue.poll();
            int currX = curr.x;
            int currY = curr.y;
            //Check if this node has been visited
            if(isVisited[currX][currY]){
                continue;
            } else{ //Check surrounding nodes
                isVisited[currX][currY] = true;
                for(int i = 0; i < 4; i++){
                    int nextX = currX + xDir[i];
                    int nextY = currY + yDir[i];
                    if(nextX < 0 || nextY < 0 || nextX >= rows || nextY >=columns){
                        continue; //Skip out of bounds
                    }
                    int diff = coordHeight[nextX][nextY] - coordHeight[currX][currY];
                    if(diff < distance[currX][currY]){
                        diff = distance[currX][currY];
                    }
                    if(distance[nextX][nextY] > diff){
                        cordQueue.add(new Coordinate(nextX,nextY, diff));
                        distance[nextX][nextY] = diff;
                    }
                }
            }
        }
    }
}
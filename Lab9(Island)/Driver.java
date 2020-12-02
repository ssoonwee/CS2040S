//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Driver{
    static boolean [][] visitedArea;
    static String [][] mapArray;
    static int rows = 0;
    static int columns = 0;
    public static void main(String [] args) throws IOException{
        BufferedReader secReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String [] data = secReader.readLine().split(" ");
        rows = Integer.parseInt(data[0]);
        columns = Integer.parseInt(data[1]);
        mapArray = new String[rows][columns];
        visitedArea = new boolean[rows][columns];
        Queue<Land> landOfQueues = new ArrayDeque<>();
        for(int i = 0; i < rows; i++){ //Store all coord into map array...
            String [] tokens = secReader.readLine().split("");
            for(int j = 0; j < columns; j++){
                mapArray[i][j] = tokens[j];
                if(tokens[j].equals("L")){
                    landOfQueues.add(new Land(i,j)); //Add these land to the land of queue
                }
                visitedArea[i][j] = false;
            }
        }
        secReader.close();
        int result = 0;
        while(!landOfQueues.isEmpty()){
            Land current = landOfQueues.poll();
            if(visitedArea[current.row][current.column] == true){
                continue; //Means it visited before, skip this...
            } else{
                searchResursively(current);
                result++;
            }
        }
        writer.println(result);
        writer.flush();
        writer.close();
    }

    public static void searchResursively(Land current){
        Queue<Land> newQueue = new ArrayDeque<>();
        newQueue.add(current);
        while(!newQueue.isEmpty()){
            Land curr = newQueue.poll();
            if(visitedArea[curr.row][curr.column] == true){
                continue;
            } else{
                visitedArea[curr.row][curr.column] = true;
            }
            int []xdir = {0,-1,0,1};
            int []ydir = {-1,0,1,0};
            for(int i = 0; i < 4; i++){
                int newDirX = curr.row + xdir[i];
                int newDirY = curr.column + ydir[i];
                if(newDirY < 0 || newDirX < 0 || newDirY >= columns || newDirX >= rows){
                    continue; //Invalid position
                } else if(mapArray[newDirX][newDirY].equals("W")){
                    visitedArea[newDirX][newDirY] = true;
                    continue; //Not a land or cloud terrain
                } else{
                    newQueue.add(new Land(newDirX, newDirY)); //Add in the queue to process next terrain...
                }
            }
        }
    }
}
//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Driver{
    public static void main(String []args){
        Kattio reader = new Kattio(System.in);
        StringBuilder weakLinks = new StringBuilder();
        StringBuilder strongLinks = new StringBuilder();
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        boolean isRunning = true;
        int noOfNodes = reader.getInt(); //First time input
        while(isRunning){
            if(noOfNodes == -1){
                break;
            }
            int counter = 0;
            int [][] adjMatrix = new int [noOfNodes][noOfNodes];
            while(counter < noOfNodes){
                int internalCounter = 0;
                while(internalCounter < noOfNodes){
                    adjMatrix[counter][internalCounter] = reader.getInt();
                    internalCounter++;
                }
                counter++;
            } //Get all node adj data
            boolean [] vertexLinks = new boolean[noOfNodes]; 
            for(int a = 0; a < noOfNodes; a++){
                vertexLinks[a] = true; //Treat all initially as a weak link..
                for(int b = 0; b < noOfNodes; b++){ //Detect for triangle cycle.
                    for(int c = 0; c < noOfNodes; c++){
                        if((adjMatrix[a][b] == 1 && adjMatrix[b][c] == 1 && adjMatrix[a][c] == 1)){
                            if(a != b && b!= c && c != a){
                                vertexLinks[a] = false;
                                vertexLinks[b] = false;
                                vertexLinks[c] = false; //Denote all are strong links..
                            } else{
                                continue;
                            }
                        } else{
                            continue;
                        }
                    }
                }
            }
            for(int i = 0; i < noOfNodes; i++){
                if(vertexLinks[i]){
                    weakLinks.append(i);
                    weakLinks.append(" ");
                }
            }
            noOfNodes = reader.getInt();
            if(noOfNodes == -1){
                break;
            } else{
                weakLinks.append("\n");
            }
        }
        writer.println(weakLinks);
        writer.println(strongLinks);
        writer.flush();
        writer.close();
    }
}
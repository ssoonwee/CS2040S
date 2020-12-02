//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph
//Mostly adapted from lecture code... 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Driver {
    public static void main(String args[]) throws IOException{
        BufferedReader secReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int villages = Integer.parseInt(secReader.readLine());
        ArrayList<Edges> edgesList = new ArrayList<Edges>();
        for(int i = 0; i < villages; i++){
            String [] paths = secReader.readLine().split(" ");
            for(int j = 0; j < villages; j++){
                if(j > i){
                    edgesList.add(new Edges(i, j, Integer.parseInt(paths[j])));
                }
            }
        }
        Collections.sort(edgesList, new EdgesComparator());
        ArrayList<Edges> resList = new ArrayList<Edges>();
        UnionFind UnionStruct = new UnionFind(villages);
        int i = 0;
        for(i = 0; i < edgesList.size(); i++){
            Edges e = edgesList.get(i);
            if(!UnionStruct.isSameSet(e.from, e.to)){
                UnionStruct.unionSet(e.from, e.to);
                resList.add(new Edges(e.from, e.to, e.cost));
            }
        }
        for(int j = 0; j < resList.size(); j++){
            Edges e = resList.get(j);
            int from = e.from + 1;
            int to = e.to + 1;
            writer.println(from + " " + to);
        }
        writer.flush();
        writer.close();
    }
}

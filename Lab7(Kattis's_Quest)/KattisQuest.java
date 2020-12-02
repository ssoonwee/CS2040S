//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph

import java.util.TreeMap;
import java.util.PriorityQueue;

public class KattisQuest {
    public static void main(String[] args){
        Kattio reader = new Kattio(System.in);
        int commands = reader.getInt();
        TreeMap<Integer, PriorityQueue<Integer>> treemap = new TreeMap<Integer, PriorityQueue<Integer>>(new EnergyComparator());
        for(int i = 0; i < commands; i++){
            String cmd = reader.getWord();
            if(cmd.equals(new String("add"))){ //Add command 
                int energy = reader.getInt();
                int gold = reader.getInt();
                if(gold>=100000){
                    gold = 100000; //Limit of 100000 golds 
                }
                if(treemap.containsKey(energy)){ //If the treemap contains the energy
                    PriorityQueue<Integer> queue = treemap.get(energy);
                    queue.add(gold); //Add gold into the queue..
                } else{
                    PriorityQueue<Integer> queue = new PriorityQueue<>(new GoldComparator());
                    queue.add(gold);
                    treemap.put(energy, queue); // 1 element in the queue  
                }
            } else{
                int totalEnergy = reader.getInt();
                long totalGold = 0;
                while(totalEnergy > 0){
                    if(treemap.floorKey(totalEnergy) == null){
                        break; //No such key exists
                    }
                    int currKey = treemap.floorKey(totalEnergy);
                    totalGold = totalGold + treemap.get(currKey).poll(); //Get the greatest energy from the tree map, and its greatest energy
                    if(treemap.get(currKey).isEmpty()){ //If queue is empty, remove this data from treemap
                        treemap.remove(currKey);
                    }
                    totalEnergy = totalEnergy - currKey;
                }
                System.out.println(totalGold);
            }
        }
    }
}

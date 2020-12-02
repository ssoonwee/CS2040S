//Name: Song Soon Wee
//Student No.: A0200378L

import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Driver {
    public static void main(String []args){
        Kattio reader = new Kattio(System.in);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        boolean isRunning = true;
        Trie newTrie = new Trie(); //New Trie Instance
        while(isRunning){
            int inputIns = reader.getInt();
            if(inputIns == 1){ //Add suggestion
                String name = reader.getWord();
                int gender = reader.getInt();
                newTrie.insert(name, gender);
                //System.out.println("Gender " + gender + "with name of" + name + "has been added to Trie.");
                continue;
            } else if(inputIns == 2){
                String removedName = reader.getWord();
                newTrie.remove(newTrie.root, removedName, 0);
                //System.out.println(removedName + "has been removed from the list");
                continue;
            } else if(inputIns == 3){
                String startChar = reader.getWord();
                String endChar = reader.getWord();
                int genderFilter = reader.getInt();
                int counter = newTrie.filterSearch(startChar, endChar, genderFilter);
                writer.println(counter);
            } else{
                isRunning = false;
            }
        }
        writer.flush();
        writer.close();
    }
}

//Name: Song Soon Wee
//Student No.: A0200378L

public class TrieNode {
    TrieNode [] children = new TrieNode[26];
    public boolean isWordEndForFemale;
    public boolean isWordEndForMale;
    public boolean isEmpty;
    public int gender;
    public int [] genderCounter;
    public long usageCount;
    public TrieNode(){ //When initialized. 
        genderCounter = new int[3]; //0 for both gender, 1 for male, 2 for female
        isWordEndForMale = false;
        isWordEndForFemale = false;
        for(int i = 0; i < 26; i++){
            children[i] = null; //Initially initialize all nodes to NULL.
            if(i < 2){
                genderCounter[i] = 0;
            }
        }
        isEmpty = true;
    }
}

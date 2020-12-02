//Name: Song Soon Wee
//Student No.: A0200378L

public class Trie {
    public static TrieNode root = new TrieNode(); //Root node where it shan't be assigned any alphabets
    public static int counter = 0;

    public void insert(String key, int genderNo){ //Seems like it is working... 
        if(root == null){
            root = new TrieNode(); //reinit if new root is null aft deletion 
        }
        int index = 0;
        TrieNode temp = root;
        temp.isEmpty = false; //Not empty anymore since we fill a node in.
        if(genderNo == 1){ //For ROOT NODE!
            temp.genderCounter[1] = temp.genderCounter[1] + 1;
        } else if(genderNo==2){
            temp.genderCounter[2] = temp.genderCounter[2] + 1;
        }
        temp.genderCounter[0] = temp.genderCounter[0] + 1; //Botg gebder
        for(int i = 0; i < key.length(); i++){
            index = (int)key.charAt(i) - 'A';
            if(temp.children[index] == null){
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
            if(genderNo == 1){
                temp.genderCounter[1] = temp.genderCounter[1] + 1;
            } else if(genderNo==2){
                temp.genderCounter[2] = temp.genderCounter[2] + 1;
            }
            temp.genderCounter[0] = temp.genderCounter[0] + 1;
        }
        if(genderNo == 1){
            temp.isWordEndForMale = true;
        } else if(genderNo == 2){
            temp.isWordEndForFemale = true;
        }
        temp.gender = genderNo; //Indicate the gender of this node... 
    }

    public int filterSearch(String startChar, String endChar, int genderNo){ 
        TrieNode temp = root; //Original top, will always be called back
        if(startChar.length() == 1 && endChar.length() == 1){ //For SINGLE CHAR SEARCHES
            int startIndex = (int)startChar.charAt(0) - 'A'; //Start Index for first char in array
            int endIndex = (int)endChar.charAt(0) - 'A';
            counter = 0; 
            for(int i = startIndex; i < endIndex; i++){
                TrieNode belowChild = temp.children[i]; //From ROOT, go through each children to see if they contains anything.
                if(belowChild == null){
                    continue; //Move on to next char if this is null
                }
                getAllWords(belowChild, 0, genderNo); //DO NOT UPDATE TEMP NODE AS NEED TO GO BACK FROM ROOT AGAIN!!
            }
        } else{ //For MULTI CHAR SEARCHES
            int end = searchStart(root,endChar,genderNo,0);
            int start = searchStart(root,startChar, genderNo, 0);
            return end - start;
        }
        return counter;
    }

    public TrieNode getAllWords(TrieNode node, int depth, int genderNo){
        if(node.isWordEndForFemale || node.isWordEndForMale){
            if(genderNo == 0){//No filter
                if(node.gender == 1 || node.gender == 2){ //If belongs to gender 1 or 2, count in. 
                    counter = counter + 1;
                }
            }
            if(node.gender == genderNo){ //Filtered based on Gender
                counter = counter + 1;
            }
            if(node.gender == 0 && genderNo != 0){ //If genderNo is not 0, but is for both gender, count them in too.
                counter = counter + 1; //Could be for both gender..
            }
        }
        for(int i = 0; i < 26; i++){
            if(node.children[i]!=null){
                node = getAllWords(node.children[i], depth + 1, genderNo);
            }
        }
        return node;
    }
    public int searchStart(TrieNode node, String tillChar, int genderNo, int charIndex){
        int total = 0;
        if(charIndex == tillChar.length()){
            return 0;
        }
        int endChar = (int)tillChar.charAt(charIndex); //Get the ASCII Value of this char
        int i;
        for(i = 0; i < 26; i++){ //Maybe change this to a for loop...
            TrieNode curr = node.children[i];
            int currChar = i + (int)'A'; 
            if(endChar > currChar && curr!=null){ //Compare such that they are all below and not NULL.
                if(genderNo == 0){
                    total = total + curr.genderCounter[0]; 
                } else if(genderNo == 1){
                    total = total + curr.genderCounter[1];
                } else if(genderNo == 2){
                    total = total + curr.genderCounter[2];
                }
            }
            if(endChar == currChar){
                break;
            }
        }
        if(node.children[i] == null){
            return total;
        }
        return total + searchStart(node.children[i], tillChar, genderNo, charIndex + 1);
    }

    public int remove(TrieNode node, String key, int depth){ //Seems like it is working..
        int retriGender;
        if(depth == key.length()){ //For last node of the name
            retriGender = node.gender;
            if(node.genderCounter[0] == 0){ //Indicates there are 0 decendants in this node
                node = null;
            } else{ //Otherwise, set this node wordEnd to NULL
                if(node.isWordEndForFemale == true){
                    node.isWordEndForFemale = false;
                } else if(node.isWordEndForMale == true){
                    node.isWordEndForMale = false;
                }
                node.gender = 999;
            }
            return retriGender; 
        }
        int index = (int)key.charAt(depth) - 'A';
        retriGender = remove(node.children[index], key, depth+1);
        //Get appropriate gender and subtract
        if(retriGender == 1){
            node.genderCounter[1] = node.genderCounter[1] - 1;
        } else if(retriGender == 2){
            node.genderCounter[2] = node.genderCounter[2] - 1; 
        }
        node.genderCounter[0] = node.genderCounter[0] - 1;
        if(node.genderCounter[0] == 0){
            node.children[index] = null;
            node = null;
        }
        return retriGender;
    }
}
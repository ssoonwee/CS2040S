//Name: Song Soon Wee
//Student Number: A0200378L

public class Teque {
    int frontdata [];
    int backdata [];
    int frontIndex;
    int frontLastIndex;
    int backIndex;
    int backLastIndex;
    int size;
    static int frontitemCount = 0;
    static int backitemCount = 0;

    public Teque(int size){ //Create a single node with NULL init for both prev and next
        frontdata = new int [2 * size];
        backdata = new int [2 * size];
        frontIndex = size; //Serves as a starting pointer for the front data array
        frontLastIndex = size;
        backIndex = size; //Serves as a starting pointer for the back data array
        backLastIndex = size; //Last of the back, nearer to mid. 
        this.size = size; //Indicate total size. 
    }

    public void pushFront(int newData){ //Append this with the next node.
        if(frontitemCount == 0){
            frontdata[size] = newData; //Start at centre for pushFront
            frontLastIndex = size; //Other end of the spectrum for maintaing equlibrium
            frontIndex = size - 1; //Next starting index
        } else{
            frontdata[frontIndex] = newData;
            frontIndex = frontIndex - 1; //From newest to oldest
        }
        frontitemCount++;
        rebalance();
    }

    public void pushMiddle(int newData){
        int index = (frontitemCount + backitemCount + 1) / 2; //size of index
        if(index >= frontitemCount){
            backLastIndex = backLastIndex - 1;
            backdata[backLastIndex] = newData;
            backitemCount++;
        } else{
            frontLastIndex = frontLastIndex + 1;
            frontdata[frontLastIndex] = newData;
            frontitemCount++;
        }
        rebalance();
    }

    public void rebalance(){
        if(backitemCount > frontitemCount){ //Shift to front item
            frontLastIndex = frontLastIndex + 1;
            frontdata[frontLastIndex] = backdata[backLastIndex];
            backLastIndex = backLastIndex + 1;
            backitemCount--;
            frontitemCount++;
            return;
        } else if(backitemCount + 1 < frontitemCount){
            backLastIndex = backLastIndex - 1;
            backdata[backLastIndex] = frontdata[frontLastIndex];
            frontLastIndex = frontLastIndex - 1;
            frontitemCount--; 
            backitemCount++;
            return;
        } else{
            //do nothing.
        }
    }

    public void pushBack(int newData){
        if(backitemCount == 0){
            backdata[size] = newData;
            backLastIndex = size;
            backIndex = size + 1;
        } else{
            backdata[backIndex] = newData;
            backIndex = backIndex + 1;
        }
        backitemCount++;
        rebalance();
    }

    public int getIndex(int index){
        if(index < frontitemCount){
            return frontdata[frontIndex + 1 + index];
        } else{
            int remainder = index - frontitemCount;
            return backdata[backLastIndex + remainder];
        }
    }
}
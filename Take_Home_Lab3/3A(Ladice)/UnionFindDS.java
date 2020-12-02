//Name: Song Soon Wee
//Student Number: A0200378L

public class UnionFindDS {
    public int [] parent;
    public int [] rank;
    public int [] itemStorage;
    public int [] size;

    public UnionFindDS(int N){
        this.parent = new int[N];
        this.rank = new int[N];
        this.itemStorage = new int[N];
        this.size = new int[N];
        for (int i= 0; i< N; i++) {
            this.parent[i] = i;
            this.rank[i] = 0;
            this.itemStorage[i] = 0; //No items stored currently. 
            this.size[i] = 1; //Currently 1 drawer in each of the set.
        }
    } 

    public boolean isSameParent(int i, int j){
        return findRoot(i) == findRoot(j);
    }

    public int findRoot(int i){
        if(this.parent[i]!=i){
            this.parent[i] = findRoot(this.parent[i]);
        }
        return this.parent[i];
    }

    public void unionSet(int i, int j){
        if(!isSameParent(i, j)){
            int x = findRoot(i);
            int y = findRoot(j);
            if(rank[x] > rank[y]){
                this.parent[y] = x;
                this.itemStorage[x] = this.itemStorage[x] + this.itemStorage[y];
                this.size[x] = this.size[x] + this.size[y]; //Since Y is merged to X, the size of X increases.
            } else{
                this.parent[x] = y;
                this.itemStorage[y] = this.itemStorage[x] + this.itemStorage[y];
                this.size[y] = this.size[y] + this.size[x]; //Since X is merged to Y, the size of Y increases.
                if(rank[x] == rank[y]){
                    this.rank[y] = this.rank[y] + 1;
                }
            }
        }
    }

    public boolean isItemStored(int i){
        int x = findRoot(i); //Find Root of this number
        int temp = itemStorage[x] + 1; //Check for available space if this is incremented. 
        if(temp <= size[x]){
            itemStorage[x] = temp;
            return true;
        } else{
            return false;
        }
    }
}

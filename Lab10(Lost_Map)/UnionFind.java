//Name: Song Soon Wee
//Student No.: A0200378L
//Collaborate: Neo Soon Keat, Nicole Joseph
//Taken from lecture notes

class UnionFind {
    public int[] p;
    public int[] rank;
    public int[] setSize;
    public int numSets;
  
    public UnionFind(int N) {
      p = new int[N];
      rank = new int[N];
      setSize = new int[N];
      numSets = N;
      for (int i = 0; i < N; i++) {
        p[i] = i;
        rank[i] = 0;
        setSize[i] = 1;
      }
    }
  
    public int findSet(int i) { 
      if (p[i] == i) return i;
      else {
        p[i] = findSet(p[i]);
        return p[i]; 
      } 
    }
  
    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
  
    public void unionSet(int i, int j) { 
      if (!isSameSet(i, j)) { 
        numSets--; 
        int x = findSet(i), y = findSet(j);
        // rank is used to keep the tree short
        if (rank[x] > rank[y]) { 
            p[y] = x; 
            setSize[x] = setSize[x] + setSize[y]; 
        }
        else { 
            p[x] = y; 
            setSize[y] = setSize[x] + setSize[y];
          if (rank[x] == rank[y]) 
            rank[y] = rank[y]+1; 
        } 
      } 
    }
  
    public int numDisjointSets() { return numSets; }
  
    public int sizeOfSet(int i) { return setSize[findSet(i)]; }
  }
package UnionFind;

public class UnionFind {
    int[] id;
    int[] rank;
    int sum = 0;
    public UnionFind(int n) {
        this.id = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int i) {
        while(i != id[i]) {
            i = id[id[i]];
        }
        return i;
    }

    public void union(int i, int j) {
        int rooti = find(i);
        int rootj = find(j);
        if(rooti == rootj) {
            return;
        }
        if(rank[rooti] > rank[rootj]) {
            id[rootj] = rooti;
            rank[rooti] += rank[rootj];
        }else {
            id[rooti] = rootj;
            rank[rootj]  += rank[rooti];
        }
        sum++;
    }
}

class Solution {
    int[] parent;
    int[] rank;

    public void DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]); // Path Compression
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py)
            return false; // Already connected

        // Union by Rank
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }

        return true;
    }
    public int countComponents(int n, int[][] edges) {
        DSU(n) ;
        int count = n;

        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                count--;
            }
        }

        return count;
     }
}

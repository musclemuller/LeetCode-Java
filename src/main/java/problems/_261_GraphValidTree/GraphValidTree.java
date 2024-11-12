package problems._261_GraphValidTree;

import Helper.UnionFound;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        UnionFound uf = new UnionFound(n);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (uf.connected(a, b)) {
                return false;
            } 
            uf.union(a, b);
        }
        return uf.count() == 1;
    }

    public static void main(String[] args) {
        GraphValidTree s = new GraphValidTree();
        int n = 5;
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(s.validTree(n, edges));
    }
}

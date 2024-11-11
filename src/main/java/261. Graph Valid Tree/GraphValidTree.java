// You have a graph of n nodes labeled from 0 to n - 1. 
// You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
// Return true if the edges of the given graph make up a valid tree, and false otherwise.

// Example 1:
// Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
// Output: true
// Example 2:
// Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
// Output: false
 
// Constraints:
// 1 <= n <= 2000
// 0 <= edges.length <= 5000
// edges[i].length == 2
// 0 <= ai, bi < n
// ai != bi
// There are no self-loops or repeated edges.



import Helper.UnionFound;

// todo: good editorial to read on leetcode
// Advanced Graph Theory + Union Find
// Complexity Analysis

// Let E be the number of edges, and N be the number of nodes.

// α(N) is the Inverse Ackermann Function.

// Time Complexity : O(N⋅α(N)).

// When E != N−1, we simply return false. Therefore, the worst case is when E=N−1. Because E is proportional to N, we'll say E=N to simplify the analysis.

// We are putting each of the N edges into the UnionFind data structure, using the union(...) method. 
// The union(...) method itself has no loops or recursion, so the entire cost of calling it is dependent on the cost of the find(...) method that it calls.

// find(...)'s cost is dependent on how far the node it was searching for is from the root. 
// Using the naïve implementation of union find, this depth could be N. If this was the case for all of the calls, we'd have a final cost of O(N^2).

// However, remember those optimizations we did? Those keep the tree depths very shallow. It turns out that find(...) amortizes to O(α(N)), where α is the Inverse Ackermann Function. 
// The incredible thing about this function is that it grows so slowly that N will never go higher than 4 in the universe as we know it! 
// So while in "practice" it is effectively O(1), in "theory" it is not.

// Actually proving this upper bound on the depth is a very advanced proof, which I'd certainly hope you'd never need to do in an interview! 
// If you're interested though, I recommend looking in a good algorithm's text book or paper.
// Anyway, this gives us a total of N⋅O(α(N))=O(N⋅α(N)).

// Space Complexity : O(N).
// The UnionFind data structure requires O(N) space to store the arrays it uses.

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

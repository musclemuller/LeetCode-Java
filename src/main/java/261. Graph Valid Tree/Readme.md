# [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/description/)

You have a graph of `n` nodes labeled from `0` to `n - 1`.  
You are given an integer `n` and a list of `edges` where `edges[i] = [ai, bi]` indicates that there is an undirected edge between nodes `ai` and `bi` in the graph.

Return `true` if the edges of the given graph make up a valid tree, and `false` otherwise.

---

### Example 1

**Input**: `n = 5`, `edges = [[0,1],[0,2],[0,3],[1,4]]`  
**Output**: `true`  

---

### Example 2

**Input**: `n = 5`, `edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]`  
**Output**: `false`  

---

### Constraints

- `1 <= n <= 2000`
- `0 <= edges.length <= 5000`
- `edges[i].length == 2`
- `0 <= ai, bi < n`
- `ai != bi`
- There are no self-loops or repeated edges.

---

### Approach: Advanced Graph Theory + Union-Find

#### Complexity Analysis

Let `E` be the number of edges and `N` be the number of nodes.

- **Time Complexity**: `O(N ⋅ α(N))`
  - If `E != N - 1`, we can immediately return `false` since a valid tree with `N` nodes must have exactly `N - 1` edges.
  - In the case where `E = N - 1`, we need to check each edge with the Union-Find data structure.
  - Using the optimized Union-Find with path compression and union by rank, the `find` operation has an amortized time complexity of `O(α(N))`, where `α` is the Inverse Ackermann function. This function grows extremely slowly, so in practice, it is effectively `O(1)`.
  - The overall time complexity is thus `O(N ⋅ α(N))`.

- **Space Complexity**: `O(N)`
  - The Union-Find data structure requires `O(N)` space to store arrays for representing parent and rank information.

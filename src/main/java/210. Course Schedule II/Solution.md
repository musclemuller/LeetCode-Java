# [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/description/)

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`.  
You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you must take course `bi` first if you want to take course `ai`.

For example, the pair `[0, 1]` indicates that to take course `0`, you must first take course `1`.

Return the ordering of courses you should take to finish all courses. If there are multiple valid answers, return any of them.  
If it is impossible to finish all courses, return an empty array.

---

### Example 1

**Input**: `numCourses = 2`, `prerequisites = [[1,0]]`  
**Output**: `[0,1]`  
**Explanation**: There are a total of 2 courses to take. To take course `1`, you must first complete course `0`. The correct course order is `[0,1]`.

---

### Example 2

**Input**: `numCourses = 4`, `prerequisites = [[1,0],[2,0],[3,1],[3,2]]`  
**Output**: `[0,2,1,3]`  
**Explanation**: There are 4 courses. To take course `3`, you need to complete both courses `1` and `2`, which can only be taken after finishing course `0`. A correct course order is `[0,1,2,3]` or `[0,2,1,3]`.

---

### Example 3

**Input**: `numCourses = 1`, `prerequisites = []`  
**Output**: `[0]`  

---

### Constraints

- `1 <= numCourses <= 2000`
- `0 <= prerequisites.length <= numCourses * (numCourses - 1)`
- `prerequisites[i].length == 2`
- `0 <= ai, bi < numCourses`
- `ai != bi`
- All pairs `[ai, bi]` are distinct.

---

### Approach: Using Node Indegree

#### Complexity Analysis

- **Time Complexity**: `O(V + E)`
  - `V` represents the number of vertices (courses), and `E` represents the number of edges (prerequisites).
  - Each node is processed once when it is popped from the zero in-degree queue, contributing `O(V)`.
  - For each vertex, we iterate over its adjacency list, covering all edges in total, contributing `O(E)`.

- **Space Complexity**: `O(V + E)`
  - The in-degree array takes `O(V)` space.
  - An intermediate queue data structure holds all nodes with zero in-degree, taking up to `O(V)` space in the worst case if all nodes initially have zero in-degree.
  - Additionally, the adjacency list representation of the graph uses `O(E)` space.

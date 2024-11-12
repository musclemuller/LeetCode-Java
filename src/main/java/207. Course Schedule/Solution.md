[Course Schedule - LeetCode](https://leetcode.com/problems/course-schedule/description/)

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`.  
You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you must take course `bi` first if you want to take course `ai`.

For example, the pair `[0, 1]` indicates that to take course `0`, you must first take course `1`.

Return `true` if you can finish all courses. Otherwise, return `false`.

---

### Example 1

**Input**: `numCourses = 2`, `prerequisites = [[1,0]]`  
**Output**: `true`  
**Explanation**: There are a total of 2 courses to take. To take course `1`, you must have finished course `0`. Thus, it is possible to complete all courses.

---

### Example 2

**Input**: `numCourses = 2`, `prerequisites = [[1,0],[0,1]]`  
**Output**: `false`  
**Explanation**: There are a total of 2 courses to take. To take course `1`, you must have finished course `0`, and to take course `0`, you must have finished course `1`. This forms a cycle, making it impossible to complete all courses.

---

### Constraints

- `1 <= numCourses <= 2000`
- `0 <= prerequisites.length <= 5000`
- `prerequisites[i].length == 2`
- `0 <= ai, bi < numCourses`
- All pairs `prerequisites[i]` are unique.

---

### Approach: Topological Sort Using Kahn's Algorithm

- **Time Complexity**: `O(m + n)`
  - Initializing the adjacency list takes `O(m)` time, as we process all edges.
  - The indegree array setup takes `O(n)` time.
  - Each queue operation takes `O(1)`, with each node pushed once, leading to `O(n)` operations for `n` nodes.
  - We iterate over the neighbors of each node once, covering all `m` edges in `O(m)` time.

- **Space Complexity**: `O(m + n)`
  - The adjacency list takes `O(m)` space.
  - The indegree array takes `O(n)` space.
  - The queue can hold up to `n` elements in the worst case, thus occupying `O(n)` space.

// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.

// Example 2:
// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 
// Constraints:
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.

package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Topological Sort Using Kahn's Algorithm
// Time complexity: O(m+n)
// Initializing the adj list takes O(m) time as we go through all the edges. The indegree array take O(n) time.
// Each queue operation takes O(1) time, and a single node will be pushed once, leading to O(n) operations for n nodes. We iterate over the neighbors of each node that is popped out of the queue iterating over all the edges once. Since there are total of m edges, it would take O(m) time to iterate over the edges.
// Space complexity: O(m+n)
// The adj arrays takes O(m) space. The indegree array takes O(n) space.
// The queue can have no more than n elements in the worst-case scenario. It would take up O(n) space in that case.
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites, indegrees);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            if (graph[cur] != null) {
                for (int next : graph[cur]) {
                    indegrees[next]--;
                    if (indegrees[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        if (count != numCourses) {
            return false;
        }
        return true;
    }

    List<Integer>[] buildGraph(int n, int[][] prerequisites, int[] indegrees) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            int from = p[1];
            int to = p[0];
            graph[from].add(to);
            indegrees[to]++;
        }

        return graph;
    }

    public static void main(String[] args) {
        CourseSchedule s = new CourseSchedule();
        int[][] prerequisites1 = new int[][]{{1, 0}};
        if (s.canFinish(2, prerequisites1) != true) {
            System.err.println("Assertion failed: Test failed");
        }
    }
}

// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. 
// If it is impossible to finish all courses, return an empty array.
// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: [0,1]
// Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
// Example 2:
// Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
// Output: [0,2,1,3]
// Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
// Both courses 1 and 2 should be taken after you finished course 0.
// So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
// Example 3:
// Input: numCourses = 1, prerequisites = []
// Output: [0]
// Constraints:
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= numCourses * (numCourses - 1)
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// ai != bi
// All the pairs [ai, bi] are distinct.



import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Using Node Indegree
// Complexity Analysis
// Time Complexity: 
// O(V+E) where V represents the number of vertices and E represents the number of edges. 
// We pop each node exactly once from the zero in-degree queue and that gives us V. 
// Also, for each vertex, we iterate over its adjacency list and in totality, we iterate over all the edges in the graph which gives us E. 
// Hence, O(V+E)

// Space Complexity: 
// O(V+E). The in-degree array requires O(V) space. We use an intermediate queue data structure to keep all the nodes with 0 in-degree. 
// In the worst case, there won't be any prerequisite relationship and the queue will contain all the vertices initially since all of them will have 0 in-degree. 
// That gives us O(V). Additionally, we also use the adjacency list to represent our graph initially. 
// The space occupied is defined by the number of edges because for each node as the key, we have all its adjacent nodes in the form of a list as the value. 
// Hence, O(E). So, the overall space complexity is O(V+E).
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] indegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            indegrees[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        int[] res = new int[numCourses];

        while (!q.isEmpty()) {
            int cur = q.poll();
            res[count] = cur;
            count++;
            for (int next : graph[cur]) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (count != numCourses) {
            return new int[]{};
        }

        return res;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    public static void main(String[] args) {
        CourseScheduleII s = new CourseScheduleII();
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.println(Arrays.toString(s.findOrder(2, prerequisites)));
    }
}

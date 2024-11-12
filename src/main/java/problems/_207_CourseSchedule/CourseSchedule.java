package problems._207_CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
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

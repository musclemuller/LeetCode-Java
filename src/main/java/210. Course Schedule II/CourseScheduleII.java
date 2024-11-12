import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

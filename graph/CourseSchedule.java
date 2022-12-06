package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The problem is from LeetCode 207
 */
public class CourseSchedule {
    private boolean[] onPath;
    private boolean[] visited;
    private boolean hasCycle;

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int to = edge[0];
            int from = edge[1];
            graph[from].add(to);
        }
        return graph;
    }

    /**
     * can finish the courses
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // traverse all the course, in case there are nodes without edges, we traverse all courses
            traverse(graph, i);
        }
        // if no cycle detected, then return true
        return !hasCycle;
    }

    /**
     * DFS traverse the graph
     *
     * @param graph
     * @param s
     */
    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // the cycle detected
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            // if the node has been visited or a cycles has detected, terminate the procedure
            return;
        }
        // before traversing, record path and node
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // after traversing, leave the path, set flag to false
        onPath[s] = false;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{3, 0}, {3, 1}, {5, 4}, {6, 3}, {7, 3}, {9, 5}, {9, 7}};
        int numCourse = 10;
        CourseSchedule cs = new CourseSchedule();
        System.out.println("The course dependencies:" + Arrays.toString(cs.buildGraph(numCourse, prerequisites)));
        boolean finish = cs.canFinish(numCourse, prerequisites);
        System.out.print("can finish the course:" + finish);
    }
}

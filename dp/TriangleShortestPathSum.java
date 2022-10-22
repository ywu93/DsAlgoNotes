package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleShortestPathSum {
    public static int sumShortestPath(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        // initialize
        for (int i = 0; i < triangle.size(); i++) {
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.print("the shortest path is:" + TriangleShortestPathSum.sumShortestPath(triangle));
    }
}

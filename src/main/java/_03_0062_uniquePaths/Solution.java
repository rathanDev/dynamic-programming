package src.main.java._03_0062_uniquePaths;

// https://leetcode.com/problems/unique-paths/
public class Solution {

    public static void main(String[] args) {
        int m;
        int n;

        m = 3;
        n = 7;  // 28
        int count = uniquePaths(m, n);
        System.out.println("count = " + count);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}

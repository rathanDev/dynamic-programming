package src.main.java._01_0509_fibonacci;


import java.util.Arrays;

// https://leetcode.com/problems/fibonacci-number/
public class Solution {

    public static void main(String[] args) {

        // 0  1 2 3 4 5 6
        // 0  1 1 2 3 5 8

        int n = 6; // 8
        int val = find(n);
        System.out.println("val = " + val);
    }

    private static int find(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println("dp = " + Arrays.toString(dp));

        return dp[n];
    }

}

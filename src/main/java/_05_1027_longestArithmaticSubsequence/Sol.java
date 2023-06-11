package src.main.java._05_1027_longestArithmaticSubsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-arithmetic-subsequence/description/
public class Sol {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 9, 12};        // 4
        int maxLen = longestArithSeqLength(nums);
        System.out.println("maxLen = " + maxLen);
    }

    /*

                V
        3   6   9   12

        3   -> {}
        6   -> {}, {3->2}
        9   -> {}, ...     {3->3, 6->2}
        12  -> {}, ...     ...           {3->4, 6->2, 9->2}


    */

    public static int findBrute(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int num1 = nums[i];

            for (int j = 0; j < i; j++) {
                int num2 = nums[j];

                int d = num1 - num2;
            }
        }

        return 0;
    }

    public static int longestArithSeqLength(int[] nums) {
        int max = 2;
        int len = nums.length;

        Map<Integer, Integer>[] dp = new HashMap[len];

        for (int i = 0; i < len; i++) {
            dp[i] = new HashMap<>();
            // System.out.print("i = " + i + " ");
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int count = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, count);
                max = Math.max(max, dp[i].get(diff));
            }
            // System.out.println(Arrays.toString(dp));
        }

        return max;
    }

}

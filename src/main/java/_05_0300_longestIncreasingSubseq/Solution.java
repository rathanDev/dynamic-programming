package src.main.java._05_0300_longestIncreasingSubseq;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/description/
public class Solution {

    public static void main(String[] args) {
        int[] nums;
        int len;

        nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        // 4     [2,3,7,101]
        // len = obj.lengthOfLIS(nums);
        // System.out.println("len = " + len);

        nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        // 6        [1 3 6 7 9 10]
        len = lengthOfLIS(nums);
        System.out.println("len = " + len);
    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
            System.out.println("dp=>" + Arrays.toString(dp));
        }

        return max;
    }

}

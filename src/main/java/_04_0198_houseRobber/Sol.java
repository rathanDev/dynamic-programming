package src.main.java._04_0198_houseRobber;

// https://leetcode.com/problems/house-robber/description/
public class Sol {

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1, 2, 3, 1}; // 4
        int max = rob(nums);
        System.out.println("max = " + max);
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        return dp[len];
    }

}

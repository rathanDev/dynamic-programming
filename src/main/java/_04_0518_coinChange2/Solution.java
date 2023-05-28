package src.main.java._04_0518_coinChange2;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change-ii/
public class Solution {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int count = change(amount, coins);
        System.out.println("count = " + count);
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }

        return dp[amount];
    }

}

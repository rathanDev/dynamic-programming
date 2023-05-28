package src.main.java._04_0322_coinChange1;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
public class Solution {

    public static void main(String[] args) {
        int[] coins;
        int amount;

        coins = new int[]{1, 2, 5};
        amount = 11; // 3

        int min = coinChange(coins, amount);
        System.out.println("min = " + min);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}

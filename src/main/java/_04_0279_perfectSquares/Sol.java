package src.main.java._04_0279_perfectSquares;

import java.util.Arrays;

public class Sol {

    public static void main(String[] args) {
        int n;
        int min;

        n = 12; // 3
        min = numSquares(n);
        System.out.println("min = " + min);

        n = 13; // 2
        min = numSquares(n);
        System.out.println("min = " + min);
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int sq = j * j;
                if (sq <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - sq]);
                } else {
                    break;
                }
            }
        }

        return dp[n];
    }

}

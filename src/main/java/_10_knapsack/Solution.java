package src.main.java._10_knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int capacity;
        int[] values;
        int[] weights;
        int max;

        capacity = 5;
        weights = new int[]{1, 2, 3};
        values = new int[]{6, 10, 12};  // expected 22
        max = findBestItems(capacity, weights, values);
        System.out.println("Maximum value is " + max);
    }

    /*
            ------- capacity---------
                0   1   2   3   4   5
            0   0   0   0   0   0   0
            1   0   6   6   6   6   6
            2   0   6   10  16  16  16
            3   0   6   10  16  18  22
    * */

    private static int findBestItems(int capacity, int[] weights, int[] values) {
        int[][] dp = new int[weights.length + 1][capacity + 1];
        boolean[][] selections = new boolean[weights.length + 1][capacity + 1];

        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    int includedValue = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                    int excludedValue = dp[i - 1][j];
                    if (includedValue > excludedValue) {
                        selections[i][j] = true;
                        dp[i][j] = includedValue;
                    } else {
                        dp[i][j] = excludedValue;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        Arrays.stream(dp).forEach(e -> System.out.println(Arrays.toString(e)));
        System.out.println();
        Arrays.stream(selections).forEach(e -> System.out.println(Arrays.toString(e)));

        List<Integer> items = new ArrayList<>();
        int currentCapacity = capacity;
        for (int i = weights.length; i > 0 && currentCapacity > 0; i--) {
            if (selections[i][currentCapacity]) {
                items.add(i - 1);
                currentCapacity = currentCapacity - weights[i - 1];
            }
        }
        System.out.println("items = " + items);

        return dp[weights.length][capacity];
    }

    private static int findMaxValue(int capacity, int[] weights, int[] values) {
        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        Arrays.stream(dp).forEach(e -> System.out.println(Arrays.toString(e)));

        return dp[weights.length][capacity];
    }

}

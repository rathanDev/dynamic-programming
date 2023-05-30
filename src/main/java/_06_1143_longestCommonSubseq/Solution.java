package src.main.java._06_1143_longestCommonSubseq;

// https://leetcode.com/problems/longest-common-subsequence/description/
public class Solution {

    public static void main(String[] args) {
        int longest;
        String text1;
        String text2;

        text1 = "abcde";
        text2 = "ace";      // 3
        longest = longestCommonSubsequence(text1, text2);
        System.out.println("longest = " + longest);

        text1 = "abc";
        text2 = "def";      // 0
        longest = longestCommonSubsequence(text1, text2);
        System.out.println("longest = " + longest);

        text1 = "AGGTAB";
        text2 = "GXTXAYB";
        longest = longestCommonSubsequence(text1, text2);
        System.out.println("longest = " + longest);
    }
    
    /*
            < --------- x -------->

                a   b   c
             0  0   0   0
          d  0
          e  0
          f  0

            [0, 0, 0, 0, 0, 0, 0]
            [0, 1, 1, 1, 1, 1, 1]
            [0, 1, 1, 1, 1, 1, 1]
            [0, 1, 2, 2, 2, 2, 2]
            [0, 1, 2, 2, 2, 2, 2]
            [0, 1, 2, 2, 2, 2, 2]
            [0, 1, 2, 2, 2, 2, 3]

    * */

    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int x = 0; x <= len1; x++) {
            for (int y = 0; y <= len2; y++) {
                if (x == 0 || y == 0) {
                    dp[x][y] = 0;
                } else if (text1.charAt(x - 1) == text2.charAt(y - 1)) {
                    dp[x][y] = 1 + dp[x - 1][y - 1];
                } else {
                    dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]);
                }
            }
        }

        return dp[len1][len2];
    }

}

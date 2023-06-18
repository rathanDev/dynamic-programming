package src.main.java._05_0139_wordBreak;

import java.util.Arrays;
import java.util.List;

public class Sol {

    public static void main(String[] args) {
        //          0 1 2 3 4 5 6 7 8
        //                          T
        //         "l e e t c o d e"; // len = 8
        String s = "leetcode"; // len = 8
        List<String> dict = Arrays.asList("leet", "code");
        boolean b = wordBreak(s, dict);
        System.out.println("b = " + b);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;

        for (int i = len - 1; i >= 0; i--) {
            String subStr = s.substring(i, len);
            // System.out.println("subStr = " + subStr);
            for (String w : wordDict) {
                if (subStr.startsWith(w) && dp[i + w.length()]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }

}

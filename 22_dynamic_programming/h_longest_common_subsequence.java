/*Find Length of LCS

Problem:
Given two strings s1 and s2, find the length of their longest common subsequence.

Example:
Input: s1 = "abcde", s2 = "ace"
Output: 3 ("ace")  */

public class h_longest_common_subsequence {

    // recursion
    public static int lcsRecursion(String s1, String s2, int n, int m) {
        // if any string is empty
        if (n == 0 || m == 0)
            return 0;

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcsRecursion(s1, s2, n - 1, m - 1);
        } else {
            int skipS1 = lcsRecursion(s1, s2, n - 1, m);
            int skipS2 = lcsRecursion(s1, s2, n, m - 1);
            return Math.max(skipS1, skipS2);
        }
    }

    // memoization
    public static int lcsMemoization(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + lcsMemoization(s1, s2, n - 1, m - 1, dp);
        } else {
            int skipS1 = lcsMemoization(s1, s2, n - 1, m, dp);
            int skipS2 = lcsMemoization(s1, s2, n, m - 1, dp);
            dp[n][m] = Math.max(skipS1, skipS2);
        }

        return dp[n][m];
    }

    // tabulation
    public static int lcsTabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Bottom-up filling
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcdge";
        String s2 = "abedg";
        int n = s1.length();
        int m = s2.length();

        // recursion
        System.out.println("LCS length-recursion: " + lcsRecursion(s1, s2, n, m));

        // memoization
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("LCS length-memoization: " + lcsMemoization(s1, s2, n, m, dp));

        // tabulation
        System.out.println("LCS length-tabulation: " + lcsTabulation(s1, s2));
    }
}

/* Problem Statement:
Given two strings s1 and s2, find the length of the longest contiguous substring present in both.

Example:

Input: s1 = "abcdgh", s2 = "acdghr"

Output: 4

Explanation: The substring "cdgh" is the longest common substring. */
public class i_longest_Common_Substring {
    // recursion
    public static int lcSubstrRecursion(String s1, String s2, int n, int m, int count) {
        if (n == 0 || m == 0)
            return count;

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            // characters match → increment count
            count = lcSubstrRecursion(s1, s2, n - 1, m - 1, count + 1);
        }
        // either skip from s1 or s2
        int skipS1 = lcSubstrRecursion(s1, s2, n - 1, m, 0);
        int skipS2 = lcSubstrRecursion(s1, s2, n, m - 1, 0);

        return Math.max(count, Math.max(skipS1, skipS2));
    }

    // memoization
    public static int lcSubstrMemoization(String s1, String s2, int n, int m, int[][] dp) {
        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = 0; // initialize
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0; // break contiguous chain
                }
            }
        }
        return maxLen;
    }

    // tabulation
    public static int lcSubstrTabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;

        // bottom-up filling
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0; // reset chain
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "acdghr";
        int n = s1.length();
        int m = s2.length();

        // recursion
        System.out.println("lcs-recursion: " +
                lcSubstrRecursion(s1, s2, n, m, 0));

        // memoization
        int[][] dp = new int[n + 1][m + 1];
        System.out.println("lcs-memoization: " +
                lcSubstrMemoization(s1, s2, n, m, dp));

        // tabulation
        System.out.println("lcs-tabulation: " +
                lcSubstrTabulation(s1, s2));
    }
}

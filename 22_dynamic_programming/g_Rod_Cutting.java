/* Rod Cutting Core Problem

Find the maximum profit obtainable by cutting a rod of length L into pieces, where each piece of length lengths[i] sells for prices[i].

Unlimited supply of each piece length is allowed (unbounded). */
public class g_Rod_Cutting {

    // recursion
    public static int rodCutRecursion(int lengths[], int prices[], int n, int L) {
        // no rod length left or no pieces available
        if (n == 0 || L == 0)
            return 0;

        if (lengths[n - 1] <= L) {
            // Include- unbounded
            int include = prices[n - 1] + rodCutRecursion(lengths, prices, n, L - lengths[n - 1]);
            // Exclude
            int exclude = rodCutRecursion(lengths, prices, n - 1, L);
            return Math.max(include, exclude);
        } else {
            return rodCutRecursion(lengths, prices, n - 1, L);
        }
    }

    // memoization
    public static int rodCutMemoization(int lengths[], int prices[], int n, int L, int[][] dp) {
        if (n == 0 || L == 0)
            return 0;

        if (dp[n][L] != -1)
            return dp[n][L];

        if (lengths[n - 1] <= L) {
            int include = prices[n - 1] + rodCutMemoization(lengths, prices, n, L - lengths[n - 1], dp);
            int exclude = rodCutMemoization(lengths, prices, n - 1, L, dp);
            dp[n][L] = Math.max(include, exclude);
        } else {
            dp[n][L] = rodCutMemoization(lengths, prices, n - 1, L, dp);
        }

        return dp[n][L];
    }

    // tabulation
    public static int rodCutTabulation(int lengths[], int prices[], int L) {
        int n = lengths.length;
        int[][] dp = new int[n + 1][L + 1];

        for (int i = 1; i <= n; i++) {
            for (int len = 1; len <= L; len++) {
                if (lengths[i - 1] <= len) {
                    int include = prices[i - 1] + dp[i][len - lengths[i - 1]]; // same row for unbounded
                    int exclude = dp[i - 1][len];
                    dp[i][len] = Math.max(include, exclude);
                } else {
                    dp[i][len] = dp[i - 1][len];
                }
            }
        }

        return dp[n][L];
    }

    public static void main(String[] args) {
        int lengths[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int prices[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int L = 8;
        int n = lengths.length;

        // recursion
        int ansRec = rodCutRecursion(lengths, prices, n, L);
        System.out.println("Max Profit (Recursion)     = " + ansRec);

        // memoization
        int[][] dp = new int[n + 1][L + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= L; j++) {
                dp[i][j] = -1;
            }
        }
        int ansMemo = rodCutMemoization(lengths, prices, n, L, dp);
        System.out.println("Max Profit (Memoization)   = " + ansMemo);

        // tabulation
        int ansTab = rodCutTabulation(lengths, prices, L);
        System.out.println("Max Profit (Tabulation)    = " + ansTab);
    }
}

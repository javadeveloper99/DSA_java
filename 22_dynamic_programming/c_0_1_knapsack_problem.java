import java.util.Arrays;

//0-1 knapsack_problem
public class c_0_1_knapsack_problem {

    // recursion
    public static int maxProfit(int val[], int wt[], int w, int n) {

        if (w == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + maxProfit(val, wt, w - wt[n - 1], n - 1);

            // excluded
            int ans2 = maxProfit(val, wt, w, n - 1);

            return Math.max(ans1, ans2);
        } else {
            return maxProfit(val, wt, w, n - 1);
        }

    }

    // memoization
    public static int maxProfitMemo(int val[], int wt[], int w, int n, int dp[][]) {

        if (w == 0 || n == 0) {
            return 0;
        }

        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + maxProfitMemo(val, wt, w - wt[n - 1], n - 1, dp);

            // excluded
            int ans2 = maxProfitMemo(val, wt, w, n - 1, dp);

            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        } else {
            dp[n][w] = maxProfitMemo(val, wt, w, n - 1, dp);
            return dp[n][w];
        }

    }

    // tabulation
    public static int maxProfitTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        // Fill table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    int include = val[i - 1] + dp[i - 1][w - wt[i - 1]];
                    int exclude = dp[i - 1][w];
                    dp[i][w] = Math.max(include, exclude);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int w = 7;
        int n = val.length;

        // recursion
        System.out.println("Recursion: " + maxProfit(val, wt, w, n));

        // memoization
        int dp[][] = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Memoization: " + maxProfitMemo(val, wt, w, n, dp));

        // tabulation
        System.out.println("Tabulation: " + maxProfitTab(val, wt, w));

    }
}

import java.util.Arrays;

public class b_climbing_stairs {
    // fibonacii
    public static int countWaysFebo(int n) {

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWaysFebo(n - 1) + countWaysFebo(n - 2);

    }

    // memoization
    public static int countWays(int n, int ways[]) {

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);

        return ways[n];

    }
    // tabulation

    public static int countWaysTabu(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            dp[i] = (i == 1) ? dp[i - 1] : dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.err.println(countWaysFebo(n));// fibonacii
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(countWays(n, ways));// memoization

        System.out.println(countWaysTabu(n)); // tabulation

    }
}
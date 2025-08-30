public class d_TargetSumSubset {

    public static boolean targetSumSubset(int numbers[], int tarSum) {
        int n = numbers.length;

        // dp[i][j] = true if we can form sum "j" using first "i" elements
        boolean dp[][] = new boolean[n + 1][tarSum + 1];

        // Base case: sum = 0 is always possible (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= tarSum; sum++) {
                int curr = numbers[i - 1];

                if (curr <= sum) {
                    // include current OR exclude current
                    dp[i][sum] = dp[i - 1][sum] || dp[i - 1][sum - curr];
                } else {
                    // can't include, only exclude
                    dp[i][sum] = dp[i - 1][sum];
                }
            }
        }

        return dp[n][tarSum];
    }

    public static void main(String[] args) {
        int numbers[] = { 4, 2, 7, 1, 3 };
        int tarSum = 10;

        if (targetSumSubset(numbers, tarSum)) {
            System.out.println("Subset with sum " + tarSum + " exists!");
        } else {
            System.out.println("No subset with sum " + tarSum + " found.");
        }
    }
}

/* Statement:
Given an integer array arr[], find the length of the longest strictly increasing subsequence.

Example:

Input: {50, 3, 10, 7, 40, 80}

Output: 4

Explanation: The LIS is {3, 7, 40, 80}. */
import java.util.*;

public class j_longest_common_subsequence {

    // Method to calculate LIS length using LCS approach
    public static int lis(int arr[]) {
        // Step 1: Create a sorted array of unique elements
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i++] = num;
        }

        Arrays.sort(arr2); // Sorted array for LCS

        // Step 2: Find LCS length of arr and sorted unique array
        return lcs(arr, arr2);
    }

    // Helper method to calculate LCS
    public static int lcs(int arr[], int arr2[]) {
        int n = arr.length;
        int m = arr2.length;

        int dp[][] = new int[n + 1][m + 1];

        // Bottom-up DP for LCS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        int length = lis(arr);
        System.out.println("Length of LIS: " + length);
    }
}

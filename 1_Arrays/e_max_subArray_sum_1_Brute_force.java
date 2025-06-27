/*
  Brute Force Approach:
  ---------------------
  - Time Complexity: O(n^3)

  - Space Complexity: O(1)
*/



public class e_max_subArray_sum_1_Brute_force {
  public static void maxSubArraySum(int arr[]) {
    int totalSubArrays = 0; // sum n = n(n+1)/2;
    int maxSum = 0;
    for (int i = 0; i <= arr.length - 1; i++) {
      int start = i;
      for (int j = start; j <= arr.length - 1; j++) {
        int end = j;
        int sum = 0;
        for (int k = start; k <= end; k++) {
          /* System.out.print(arr[k] + " "); */
          sum += arr[k];
        }
        totalSubArrays++;

        if (sum > maxSum) {
          maxSum = sum;
        }

      }
      System.out.println();
    }
    System.out.println("total Sub Arrays : " + totalSubArrays++);
    System.out.println("maxSum : " + maxSum);
  }

  public static void main(String[] args) {
    int arr[] = { 1, -2, 6, -1, 3 };

    maxSubArraySum(arr);

  }

}
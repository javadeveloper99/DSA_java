// Time Complexity = O(n)
// Space Complexity = O(1)

/* Problem Statement
Given an integer array arr[], find the maximum sum of a contiguous subarray within the array.
A contiguous subarray means all elements are consecutive and in the same order as they appear in the original array.
Constraints:
You must solve it in linear time, i.e., O(n).
You must use constant extra space, i.e., O(1). */

public class g_max_subArray_sum_3_kadanes_Algo {

  public static void maxSubArraySumKadanesAlgo(int arr[]) {
    int maxSum = Integer.MIN_VALUE;
    int currSum = 0;

    for (int i = 0; i < arr.length; i++) {
      currSum += arr[i];
      if (currSum < 0) {
        currSum = 0;
      }

      maxSum = Math.max(maxSum, currSum);
    }
    System.out.println("our max sub array sum is : " + maxSum);

  }

  public static void main(String[] args) {
    int arr[] = { 1, -1, 6, -1, 3 };
    maxSubArraySumKadanesAlgo(arr);
  }
}

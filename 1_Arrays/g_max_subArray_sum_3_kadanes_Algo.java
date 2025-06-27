// Time Complexity = O(n)
// Space Complexity = O(1)



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
    int arr[] = { 1,-1,6,-1,3};
    maxSubArraySumKadanesAlgo(arr);
  }
}

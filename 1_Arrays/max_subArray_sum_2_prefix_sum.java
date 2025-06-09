/* Time Complexity 	 O(n²)
   Space Complexity	  O(n) */

package DSA_java.Arrays;

public class max_subArray_sum_2_prefix_sum {
  public static void maxSubArraySum(int arr[]) {
    int totalSubArrays = 0; // sum n = n(n+1)/2;
    int maxSum = 0;
    int prefix[] = new int[arr.length];

    prefix[0] = arr[0];

    for (int i = 1; i < arr.length; i++) {
      prefix[i] = prefix[i - 1] + arr[i];
    }

    for (int i = 0; i <= arr.length - 1; i++) {
      int start = i;
      for (int j = start; j <= arr.length - 1; j++) {
        int end = j;

        int sum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

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

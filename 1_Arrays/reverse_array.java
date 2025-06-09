// Time complexity: O(n)
// Space complexity: O(1)

// Reverses the array in-place

package DSA_java.Arrays;

public class reverse_array {
  public static void reverseArray(int arr[]) {
    for (int i = 0; i < arr.length / 2; i++) {
      int end = arr.length - 1 - i;
      int temp = arr[i];
      arr[i] = arr[end];
      arr[end] = temp;
    }
  }

  public static void main(String[] args) {
    int arr[] = { 2, 4, 6, 8, 10, 12, 14 };

    reverseArray(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}

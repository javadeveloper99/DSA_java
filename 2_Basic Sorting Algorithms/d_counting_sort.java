/* Counts how many times each value occurs.

 Uses this information to place elements directly into their correct sorted position. */


public class d_counting_sort {
  public static void print(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void countingSort(int arr[]) {

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
    }
    int counting[] = new int[max + 1];

    for (int i = 0; i < arr.length; i++) {
      counting[arr[i]]++;

    }
    int start = 0;
    for (int i = 0; i < arr.length; i++) {
      while (counting[i] > 0) {
        arr[start] = i;
        start++;
        counting[i]--;
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = { 1, 4, 1, 3, 2, 4, 2, 7 };
    countingSort(arr);
    print(arr);
  }
}
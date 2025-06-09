/* put the smallest from the unsorted and put it at the beginning */

//Space Complexity- O(1)

/* Time Complexity best,Average,Worst	O(n²):Because the inner loop always runs (n - i - 1) times, regardless of whether the array is already sorted. */

public class selection_sort {

  public static void print(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void selectionSort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      int small = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[small] > arr[j]) {
          small = j;
        }
      }
      int temp = arr[small];
      arr[small] = arr[i];
      arr[i] = temp;
    }
  }

  public static void main(String[] args) {
    int arr[] = { 3, 4, 1, 2, 5, 7, 6 };
    selectionSort(arr);
    print(arr);

  }
}

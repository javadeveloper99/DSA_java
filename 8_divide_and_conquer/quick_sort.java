public class quick_sort {

  /*
   * Time Complexity:-
   *
   * Best Case :- O(n log n)
   * Average :- O(n log n)
   * Worst Case :- O(n²) (When array is already sorted or reverse sorted)
   *
   * Space Complexity: O(log n) (due to recursion stack)
   */
  public static void printArr(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void quickSort(int arr[], int si, int ei) {
    if (si >= ei) {
      return;
    }
    int p_idx = partiation(arr, si, ei);
    quickSort(arr, si, p_idx - 1);
    quickSort(arr, p_idx + 1, ei);
  }

  public static int partiation(int arr[], int si, int ei) {
    int pivot = arr[ei];
    int i = si - 1;

    for (int j = si; j < ei; j++) {
      if (arr[j] <= pivot) {
        i++;
        // swap

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
    i++;

    int temp = pivot;
    arr[ei] = arr[i];
    arr[i] = temp;

    return i;

  }

  public static void main(String[] args) {
    int[] arr = { 3, 5, 2, 1, 4, 7, 6 };
    quickSort(arr, 0, arr.length - 1);
    printArr(arr);

  }
}

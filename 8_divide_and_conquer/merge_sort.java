public class merge_sort {

  // Time: O(n log n), Space: O(n)
  public static void mergeSort(int[] arr, int si, int ei) {
    if (si >= ei) {
      return;
    }

    int mid = si + (ei - si) / 2;

    mergeSort(arr, si, mid); // Sort left half
    mergeSort(arr, mid + 1, ei); // Sort right half

    merge(arr, si, mid, ei); // Merge sorted halves
  }

  public static void merge(int[] arr, int si, int mid, int ei) {
    int[] temp = new int[ei - si + 1];
    int i = si; // Pointer for left half
    int j = mid + 1; // Pointer for right half
    int k = 0; // Pointer for temp array

    // Merge both halves into temp[]
    while (i <= mid && j <= ei) {
      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
      }
    }

    // Copy remaining elements from left half
    while (i <= mid) {
      temp[k++] = arr[i++];
    }

    // Copy remaining elements from right half
    while (j <= ei) {
      temp[k++] = arr[j++];
    }

    // Copy sorted temp[] back to original array
    for (int t = 0; t < temp.length; t++) {
      arr[si + t] = temp[t];
    }
  }

  public static void printArr(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = { 3, 5, 2, 1, 4, 7, 6 };

    mergeSort(arr, 0, arr.length - 1); // Merge Sort
    printArr(arr); // Output Sorted Array
  }
}

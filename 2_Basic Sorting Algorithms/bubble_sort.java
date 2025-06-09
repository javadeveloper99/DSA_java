/*
 * 🔍 Bubble Sort Idea (Concept)
 *
Compare the first two elements.

Swap them if the first is greater than the second.

Move to the next pair and repeat step 2 until the end of the array.

After the first pass, the largest element is at the end.

Repeat the process for the remaining unsorted part of the array.

Continue until no swaps are needed, which means the array is sorted.
 */

/*
 *  Time Complexity
 * | Case            | Comparisons | Swaps  | Time Complexity |
| --------------- | ----------- | ------ | --------------- |
| Best (Sorted)   | n-1         | 0      | O(n)            |
| Average         | \~n²/2      | \~n²/4 | O(n²)           |
| Worst (Reverse) | \~n²/2      | \~n²/2 | O(n²)           |

 */

public class bubble_sort {
  public static void bubbleSort(int arr[]) {
    for (int turn = 0; turn < arr.length - 1; turn++) {
      for (int j = 0; j < arr.length - 1 - turn; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  public static void print(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void main(String[] args) {
    int arr[] = { 3, 4, 1, 2, 5, 7, 6 };
    bubbleSort(arr);
    print(arr);

  }
}

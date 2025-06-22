/* pick and element from unsorted part and place in right position in sorted part

Space Complexity - O(1)

Time Complexity
| Case       | Time      | Why?                         |
| ---------- | --------- | ---------------------------- |
| Best Case  | **O(n)**  | When array is already sorted |
| Average    | **O(n²)** | Random order                 |
| Worst Case | **O(n²)** | Reverse order                |

 */

public class c_insertion_sort {
  public static void print(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void insertionSort(int arr[]) {
    for (int i = 1; i < arr.length; i++) {
      int curr = arr[i];
      int prev = i - 1;
      while (prev >= 0 && arr[prev] > curr) {
        arr[prev + 1] = arr[prev];
        prev--;
      }

      arr[prev + 1] = curr;
    }

  }

  public static void main(String[] args) {
    int arr[] = { 3, 4, 1, 2, 5, 7, 6 };
    insertionSort(arr);
    print(arr);

  }
}

public class search_in_rotated_sorted_array {

  public static int searchRotatedArray(int arr[], int key) {
    int si = 0;
    int ei = arr.length - 1;

    while (si <= ei) {
      int mid = si + (ei - si) / 2;

      if (arr[mid] == key) {
        return mid;
      }

      // Left half is sorted
      if (arr[si] <= arr[mid]) {
        if (key >= arr[si] && key < arr[mid]) {
          ei = mid - 1;
        } else {
          si = mid + 1;
        }
      }
      // Right half is sorted
      else {
        if (key > arr[mid] && key <= arr[ei]) {
          si = mid + 1;
        } else {
          ei = mid - 1;
        }
      }
    }

    return -1; // Not found
  }

  public static void main(String[] args) {
    int arr[] = { 4, 5, 6, 7, 8, 0, 1, 2, 3 };
    int key = 0;
    int index = searchRotatedArray(arr, key);

    if (index != -1) {
      System.out.println("Element " + key + " found at index: " + index);
    } else {
      System.out.println("Element " + key + " not found.");
    }
  }
}

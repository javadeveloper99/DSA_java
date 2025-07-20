
// Complexity  Time 	 O(log n)
// Complexity  Space 	 O(1)

/* You are given a sorted array, but it has been rotated at some pivot you don't know.

Example: Original sorted: [1, 2, 3, 4, 5, 6, 7]
Rotated: [4, 5, 6, 7, 1, 2, 3]

You need to find the index of a given target element in this rotated array in O(log n) time (so basically, like binary search). */

public class a_Rotated_Sorted_Array_Search {

  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {

      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      else {
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
    int target1 = 0;
    System.out.println("Output: " + search(nums1, target1)); // Output: 4

    int target2 = 3;
    System.out.println("Output: " + search(nums1, target2)); // Output: -1
  }
}

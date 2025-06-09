
// Time complexity : O(n);

package DSA_java.Arrays;

public class linear_search {

  public static int linearSearch(int arr[], int key) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == key) {
        return i;
      }
    }
    return -1;
  }

  public static int largest_smallest(int arr[]) {

    int largest=Integer.MIN_VALUE;// -infinity
    int smallest=Integer.MAX_VALUE;// +infinity

    for (int i = 0; i < arr.length; i++) {
      if (arr[i]>largest) {
        largest=arr[i];
      }
      if (arr[i]<smallest) {
        smallest=arr[i];
      }
    }
    System.out.println("smallest number is : "+smallest);

    return largest;

  }

  public static void main(String[] args) {
    //linear

    /* int arr[] = { 2, 4, 6, 8, 10, 12, 14 };
    int key = 20;

    int value = linearSearch(arr, key);

    if (value == -1) {
      System.out.print("key Not Found");
    } else {
      System.out.print("key found at index : " + value);
    } */

    //largest

    int arr[] = { 2, 4, 6, 8, 10, 12, 14 };

    int largest=largest_smallest(arr);

    System.out.println("largest number is : "+largest);


  }
}

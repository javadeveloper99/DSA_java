//Time Complexity: O(n^2)  && Space Complexity: O(1)



public class c_pairs_in_array {

  public static void pairsInArray(int arr[]) {
    int start = 0;
    int end = arr.length - 1;

    while (start < end) {
      for (int i = start + 1; i <= end; i++) {
        System.out.print("(" + arr[start] + "," + arr[i] + ")");
      }

      start++;
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int arr[] = { 2, 4, 6, 8, 10 };

    pairsInArray(arr);

  }
}



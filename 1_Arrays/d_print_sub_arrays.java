 //Time Complexity: O(n^3)  && Space Complexity: O(1)



public class d_print_sub_arrays {

  public static void printSubArrays(int arr[]) {
    int totalSubArrays = 0;  // sum n = n(n+1)/2;
    for (int i = 0; i <= arr.length - 1; i++) {
      int start = i;
      for (int j = start; j <= arr.length - 1; j++) {
        int end = j;
        int sum =0;
        for (int k = start; k <= end; k++) {
          System.out.print(arr[k] + " ");
          sum+=arr[k];
        }
        totalSubArrays++;

        System.out.println("sum is : "+sum);

      }
      System.out.println();
    }
    System.out.println( "total Sub Arrays : "+totalSubArrays++);
  }

  public static void main(String[] args) {
    int arr[] = { 2, 4, 6, 8, 10 };

    printSubArrays(arr);

  }
}



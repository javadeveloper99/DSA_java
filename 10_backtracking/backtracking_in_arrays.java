
public class backtracking_in_arrays {

  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println();

  }

  public static void newArr(int arr[],int i,int val){
      if (i==arr.length) {
        printArr(arr);
        return;
      }
    arr[i]=val;
       newArr(arr, i+1, val+1);
       arr[i]=arr[i]-3;

  }

  public static void main(String[] args) {
     int arr[]=new int[5];
     newArr(arr, 0, 1);
     printArr(arr);
  }
}

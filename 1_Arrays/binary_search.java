
// prerequisites : sorted arrays
//Time complexity of binary search : O(log n)

package DSA_java.Arrays;

public class binary_search {

  public static int binarySearch(int key,int arr[]){
     int start=0;
     int end=arr.length-1;

     while (start<=end) {

        int mid=(start+end)/2;

        if(arr[mid]==key){
          return mid;
        }

        else if(arr[mid]<key){ //right

          start=mid+1;
        }

        else { //left
          end=mid-1;
        }
     }
     return -1;
  }

  public static void main(String[] args) {
    int arr[] = { 2, 4, 6, 8, 10, 12, 14 };
    int key = 10;

     int index=binarySearch(key, arr);

     if (index==-1) {
       System.out.println("Invalid Number");
     }else{
       System.out.println("Index of "+key+" is : "+index);
     }

  }
}

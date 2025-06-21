import java.util.*;

//ngi-next greatest element
public class next_Greater_element {
  public static void nextGreaterElement(int arr[], int nge[]) {
    Stack<Integer> s = new Stack<>();

    for (int i = arr.length - 1; i >= 0; i--) {
      while (!s.isEmpty() && s.peek() <= arr[i]) {
        s.pop();
      }

      if (s.isEmpty()) {
        nge[i] = -1;
      } else {
        nge[i] = s.peek();
      }

      s.push(arr[i]);
    }
  }

  public static void main(String[] args) {
    int arr[] = { 6, 8, 0, 1, 3 };
    int nge[] = new int[arr.length];

    nextGreaterElement(arr, nge);

    for (int i = 0; i < nge.length; i++) {
      System.out.println(nge[i]);
    }
  }
}

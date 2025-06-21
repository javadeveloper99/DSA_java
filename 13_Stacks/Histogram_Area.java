import java.util.*;

public class Histogram_Area {
  public static int getMaxArea(int[] arr) {
    Stack<Integer> st = new Stack<>();
    int max = 0;

    for (int i = 0; i <= arr.length; i++) {
      int curr = (i == arr.length) ? 0 : arr[i];

      while (!st.isEmpty() && curr < arr[st.peek()]) {
        int height = arr[st.pop()];
        int width;
        if (st.isEmpty()) {
          width = i;
        } else {
          width = i - st.peek() - 1;
        }

        int area = height * width;
        if (area > max) {
          max = area;
        }
      }

      st.push(i);
    }

    return max;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 1, 5, 6, 2, 3 };
    int ans = getMaxArea(arr);
    System.out.println(ans);
  }
}

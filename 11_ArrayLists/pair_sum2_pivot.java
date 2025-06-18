import java.util.ArrayList;

public class pair_sum2_pivot {

  public static boolean pairSum2Pivot(ArrayList<Integer> list, int target) {
    int n = list.size();
    int bp = -1;  

    for (int i = 0; i < n - 1; i++) {
      if (list.get(i) > list.get(i + 1)) {
        bp = i;
        break;
      }
    }



    int i = (bp + 1) % n; // smallest element
    int j = bp;           // largest element

    // using circular logic
    while (i != j) {
      int sum = list.get(i) + list.get(j);

      if (sum == target) {
        System.out.println("Pair found at indices: i=" + i + ", j=" + j);
        return true;
      }

      if (sum < target) {
        i = (i + 1) % n;
      } else {
        j = (n + j - 1) % n;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(11);
    list.add(15);
    list.add(6);
    list.add(8);
    list.add(9);
    list.add(10);

    System.out.println(pairSum2Pivot(list, 16));
  }
}

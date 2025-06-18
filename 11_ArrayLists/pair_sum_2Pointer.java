import java.util.ArrayList;

public class pair_sum_2Pointer {

  public static void pairSum(ArrayList<Integer> list, int target) {
    int i = 0;
    int j = list.size() - 1;

    while (i < j) {
      int sum = list.get(i) + list.get(j);

      if (sum == target) {
        System.out.println("Target is found at index " + i + " and " + j);
        return;
      } else if (sum < target) {
        i++;
      } else {
        j--;
      }
    }

    System.out.println("No pair found.");
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);

    int target = 5;

    pairSum(list, target);
  }
}

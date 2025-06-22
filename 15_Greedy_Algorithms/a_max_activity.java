import java.util.*;

public class a_max_activity {

  public static void main(String[] args) {
    int[] start = { 1, 3, 0, 5, 8, 5 };
    int[] end = { 2, 4, 6, 7, 9, 9 };

    int[][] act = new int[start.length][3];

    for (int i = 0; i < start.length; i++) {
      act[i][0] = i;
      act[i][1] = start[i];
      act[i][2] = end[i];
    }

    // Sort by end time-lambda function
    Arrays.sort(act, Comparator.comparingInt(o -> o[2]));

    int maxAct = 1;
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(act[0][0]);
    int lastEnd = act[0][2];

    // Iterate over remaining activities
    for (int i = 1; i < act.length; i++) {
      if (act[i][1] >= lastEnd) {
        maxAct++;
        ans.add(act[i][0]); // Add original index
        lastEnd = act[i][2];
      }
    }

    System.out.println("max activities = " + maxAct);
    for (int i = 0; i < ans.size(); i++) {
      System.out.print("A" + ans.get(i) + " ");
    }
    System.out.println();
  }
}

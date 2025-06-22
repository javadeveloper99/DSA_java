import java.util.*;

public class b_Fractional_Knapsack {
  public static void main(String[] args) {
    int val[] = { 60, 100, 120 };
    int weight[] = { 10, 20, 30 };
    int w = 50;

    double ratio[][] = new double[val.length][2];

    for (int i = 0; i < val.length; i++) {
      ratio[i][0] = i;
      ratio[i][1] = val[i] / (double) weight[i];
    }

    // Sort by ratio ascending, then process from the back (descending)
    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

    int capacity = w;
    double finalVal = 0;

    for (int i = ratio.length - 1; i >= 0; i--) {
      int idx = (int) ratio[i][0];

      if (capacity >= weight[idx]) {
        finalVal += val[idx];
        capacity -= weight[idx];
      } else {
        finalVal += capacity * ratio[i][1];
        break;
      }
    }

    System.out.println("Maximum value in knapsack = " + finalVal);
  }
}

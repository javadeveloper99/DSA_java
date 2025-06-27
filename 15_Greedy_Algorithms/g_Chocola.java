import java.util.*;

public class g_Chocola {
  public static void main(String[] args) {
    int n = 4, m = 6;

    Integer costVer[] = { 2, 1, 3, 1, 4 };
    Integer costHor[] = { 4, 1, 2 };

    Arrays.sort(costHor, Comparator.reverseOrder());
    Arrays.sort(costVer, Comparator.reverseOrder());

    int v = 0, h = 0;
    int hc = 1, vc = 1;
    int finalCost = 0;

    while (v < costVer.length && h < costHor.length) {
      if (costHor[v] >= costVer[h]) {
        finalCost += (vc * costHor[h]);
        h++;
        hc++;
      } else {

        finalCost += (hc * costVer[v]);
        vc++;
        v++;
      }
    }

    while (v < costVer.length) {
      finalCost += (hc * costVer[v]);
      vc++;
      v++;
    }

    while (h < costHor.length) {
      finalCost += (vc * costHor[h]);
      h++;
      hc++;
    }

    System.out.println("total cost of cuts = " + finalCost);

  }
}
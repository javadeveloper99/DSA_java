// ===================== Print in Decreasing Order =====================
public class a_DecreasingOrder {
  public static void printNumb(int n) {
    if (n == 1) {
      System.out.print(n + " ");
      return;
    }
    System.out.print(n + " ");
    printNumb(n - 1);
  }

  public static void main(String[] args) {
    printNumb(3);
  }
}
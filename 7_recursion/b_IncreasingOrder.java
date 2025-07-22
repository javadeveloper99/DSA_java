// ===================== Print in Increasing Order =====================
public class b_IncreasingOrder {
  public static void printNumbr(int n) {
    if (n == 1) {
      System.out.print(1 + " ");
      return;
    }
    printNumbr(n - 1);
    System.out.print(n + " ");
  }

  public static void main(String[] args) {
    printNumbr(3);
  }
}
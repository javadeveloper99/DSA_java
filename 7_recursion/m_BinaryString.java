
// ===================== Binary String Without Consecutive 1s =====================
/* 🔢 Problem: Binary Strings Without Consecutive 1s
Given a positive integer n, print all binary strings of length n such that:

No two 1s are adjacent (i.e., no "11" appears anywhere in the string). */
public class m_BinaryString {
  public static void printBinString(int n, int lastPlace, String str) {
    if (n == 0) {
      System.out.println(str);
      return;
    }
    printBinString(n - 1, 0, str + '0');
    if (lastPlace == 0) {
      printBinString(n - 1, 1, str + '1');
    }
  }

  public static void main(String[] args) {
    printBinString(3, 0, "");
  }
}

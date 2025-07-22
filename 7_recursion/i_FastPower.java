
// ===================== Fast Exponentiation =====================
public class i_FastPower {
  public static int powFun(int n, int pow) {
    if (pow == 0)
      return 1;
    int half = powFun(n, pow / 2);
    if (pow % 2 == 0)
      return half * half;
    else
      return n * half * half;
  }

  public static void main(String[] args) {
    System.out.println(powFun(4, 2));
  }
}

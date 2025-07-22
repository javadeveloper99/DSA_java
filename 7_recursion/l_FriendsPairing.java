
// ===================== Friends Pairing =====================
public class l_FriendsPairing {
  public static int frindsPair(int n) {
    if (n == 0 || n == 1 || n == 2)
      return n;
    return frindsPair(n - 1) + (n - 1) * frindsPair(n - 2);
  }

  public static void main(String[] args) {
    System.out.println(frindsPair(4));
  }
}

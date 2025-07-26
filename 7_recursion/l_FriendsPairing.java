
// ===================== Friends Pairing =====================
/* 🧑‍🤝‍🧑 Problem: Friends Pairing Problem
You are given n friends. Each friend can either:

Stay single, or

Pair up with exactly one of the remaining friends (only one pair allowed per person).

Your task is to count the total number of ways these n friends can be arranged (either paired or single).

 */
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

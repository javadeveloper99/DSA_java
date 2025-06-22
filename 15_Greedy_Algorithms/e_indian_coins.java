import java.util.*;

public class e_indian_coins {
  public static void main(String[] args) {
    Integer coins[] = { 1, 2, 5, 10, 20, 5, 100, 500, 2000 };

    int v = 245345;

    Arrays.sort(coins, Comparator.reverseOrder());

    int noCoins = 0;
    System.out.print("Coins used : ");

    for (int i = 0; i < coins.length; i++) {

      while (v>= coins[i]) {
        noCoins++;
        v-= coins[i];
        System.out.print(coins[i] + " ");

      }
    }

    System.out.println("\nmin coins used= " + noCoins);

  }
}

// Time Complexity	O(n)
// Space Complexity	O(1)



public class i_buy_sell_stocks {
  public static int buySellStocks(int prices[]) {
    int buyPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {

      if (buyPrice < prices[i]) {
        maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
      } else {
        buyPrice = prices[i];
      }

    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int prices[] = { 7, 1, 5, 3, 6, 4 };
    System.out.println(buySellStocks(prices));
  }
}

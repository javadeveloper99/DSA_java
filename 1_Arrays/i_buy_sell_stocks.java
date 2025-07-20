// Time Complexity	O(n)
// Space Complexity	O(1)

/* Problem: Best Time to Buy and Sell Stock (Leetcode 121 style)
🧾 Statement:
You are given an array prices where prices[i] represents the price of a stock on the i-th day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction.
If you cannot make any profit, return 0. */

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

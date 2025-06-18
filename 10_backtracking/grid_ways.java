public class grid_ways {

  // Use long to avoid overflow for larger values
  public static long factorial(int n) {
    if (n < 0)
      return 0; // defensive check
    if (n == 0 || n == 1)
      return 1;
    return n * factorial(n - 1);
  }

  // Optimized using combinatorics: C(n-1 + m-1, n-1) = (n-1+m-1)! / ((n-1)! *
  // (m-1)!)
  public static long optimisedGridWays(int n, int m) {
    long numerator = factorial(n + m - 2);
    long denominator = factorial(n - 1) * factorial(m - 1);
    return numerator / denominator;
  }

  // Recursive approach (not optimized, exponential time)
  public static int gridWays(int i, int j, int n, int m) {
    if (i == n - 1 || j == m - 1)
      return 1;
    if (i >= n || j >= m)
      return 0;

    int down = gridWays(i + 1, j, n, m);
    int right = gridWays(i, j + 1, n, m);

    return down + right;
  }

  public static void main(String[] args) {
    int n = 3, m = 3;
    int count = gridWays(0, 0, n, m);
    long count2 = optimisedGridWays(n, m);

    System.out.println("Normal Method: there are " + count + " ways to go from (0,0) to (n-1,m-1)");
    System.out.println("Optimised Method: there are " + count2 + " ways to go from (0,0) to (n-1,m-1)");
  }
}

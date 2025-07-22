/* Write a program to calculate the value of(a raised to the power n) using fast exponentiation (also known as binary exponentiation).
This method significantly reduces the time complexity from O(n) to O(log n) by using bitwise operations. */
public class h_fast_exponentiation {

  public static int fastExpo(int a, int n) {

    /*
     * n = 5 → 101 in binary
     * 
     * 1st bit (rightmost is 1): ans = 1 × 3 = 3
     * square a = 3 × 3 = 9, shift n = 10 (2)
     * 
     * 2nd bit (0): skip multiplication
     * square a = 9 × 9 = 81, shift n = 1
     * 
     * 3rd bit (1): ans = 3 × 81 = 243
     * Done!
     */
    int ans = 1;

    while (n > 0) {
      if ((n & 1) != 0) {
        ans = ans * a;
      }
      a = a * a;
      n = n >> 1;
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(fastExpo(3, 5));

  }
}

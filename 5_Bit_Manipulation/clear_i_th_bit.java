public class clear_i_th_bit {

  public static int clear_ith_bit(int n, int i) {

    int bitmast = ~(1 << i);

    return n & bitmast;
  }

  public static void main(String[] args) {

    System.out.println(clear_ith_bit(10, 1));

  }

}

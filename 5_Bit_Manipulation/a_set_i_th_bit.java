// if 0 make it 1 and vice versa
public class a_set_i_th_bit {
  public static int set_ith_bit(int n,int i) {

    // get ith bit
    /* int bitmast = n >> i;
    return bitmast & 1; */


    int bitmast =1<<i;

    return n | bitmast;
  }

  public static void main(String[] args) {
    System.out.println(set_ith_bit(10, 2));



  }
}

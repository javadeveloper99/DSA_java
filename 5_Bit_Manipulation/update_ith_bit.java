public class update_ith_bit {

  public static int set_ith_bit(int n, int i) {
    int bitmast = 1 << i;

    return n | bitmast;
  }

  public static int update_ith_bit(int n,int i,int newBit){
      if (newBit==0) {
        return clear_ith_bit(n,i);
      }else{
        return set_ith_bit(n,i);
      }

      /* n=clear_ith_bit(n,i);
      int bitmast=newBit<<i;
      return n | bitmast; */
  }

  public static int clear_ith_bit(int n, int i) {

    int bitmast = ~(1 << i);

    return n & bitmast;
  }

  public static void main(String[] args) {
      System.out.println(update_ith_bit(10, 2, 1));
  }
}

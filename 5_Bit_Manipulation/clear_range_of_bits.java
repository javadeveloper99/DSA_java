public class clear_range_of_bits {

  public static int clearRangeOfBit(int n,int i,int j){
       int bitmask_a=(~0)<<j+1;
       int bitmask_b=(i<<i)-1;

       int bitmask = bitmask_a | bitmask_b ;

       return n & bitmask;
  }
  public static void main(String[] args) {
      System.out.println(clearRangeOfBit(10,2,4));
  }
}

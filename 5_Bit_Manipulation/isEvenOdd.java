

public class isEvenOdd {
     public static String evenOdd(int n){
            int bitmast=1;

            if ((n & bitmast)==0) {
              return "Even Number";
            }
            else{
              return "Odd Number";
            }
     }
     public static void main(String[] args) {
        System.out.println(evenOdd(6));
        System.out.println(evenOdd(7));

     }
}

import java.util.*;


public class container_with_most_water {
  public static int twoPointer(ArrayList <Integer> height){
    //two pointers

    int i=0;
    int j=height.size()-1;
    int maxwater=0;


    while (i<j) {
      int width=j-i;
      int minH=Math.min(height.get(i), height.get(j));
      int currWater=width*minH;
      maxwater=Math.max(maxwater, currWater);

      if (height.get(i)<height.get(j)) {
           i++;
      }else{
        j--;
      }
    }

    return maxwater;
  }
    public static void main(String[] args) {
       ArrayList <Integer> height=new ArrayList<>();

       height.add(1);
       height.add(8);
       height.add(6);
       height.add(2);
       height.add(5);
       height.add(4);
       height.add(8);
       height.add(3);
       height.add(7);

       System.out.println(twoPointer(height));

    }
}

import java.util.*;

//jcf - java collection framework
public class JCF_Queue {
  public static void main(String[] args) {
    // Queue<Integer>q=new LinkedList<>();
    Queue<Integer> q = new ArrayDeque<>();
    
    /*
     * Because Queue is an interface in Java — and interfaces cannot be instantiated
     * directly.
     *
     * You must use a class that implements the Queue interface, such as:
     *
     * LinkedList
     *
     * ArrayDeque
     *
     * PriorityQueue
     */

    q.add(1);
    q.add(2);
    q.add(3);

    while (!q.isEmpty()) {
      System.out.println(q.peek());
      q.remove();
    }
  }

}

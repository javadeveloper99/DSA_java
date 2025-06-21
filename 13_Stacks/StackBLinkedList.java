public class StackBLinkedList {
  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }

  }

  static class Stack {
    static Node head = null;

    public static boolean isEmpty() {
      return head == null;
    }

    public static void push(int data) {

      Node newnode = new Node(data);
      if (isEmpty()) {
        head = newnode;
        return;
      }

      newnode.next = head;
      head = newnode;
    }

    public static int pop() {
      if (isEmpty()) {
        return -1;
      }
      int top = head.data;
      head = head.next;
      return top;
    }

    public static int peek() {
      if (isEmpty()) {
        return -1;
      }

      return head.data;
    }
  }

  public static void main(String[] args) {
    Stack s = new Stack();

    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);

    System.out.println(s.pop()); // 4
    System.out.println(s.pop()); // 3
    System.out.println(s.pop()); // 2
    System.out.println(s.pop()); // 1
    System.out.println(s.pop());
  }

}

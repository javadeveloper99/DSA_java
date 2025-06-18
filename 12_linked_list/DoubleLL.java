public class DoubleLL {

  // Node class representing each element in the doubly linked list
  public class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

  // Pointers to the start and end of the list
  public static Node head;
  public static Node tail;
  public static int size;

  // Add a node at the beginning
  public void addFirst(int data) {
    Node newNode = new Node(data);
    size++;

    // If list is empty, set both head and tail to newNode
    if (head == null) {
      head = tail = newNode;
      return;
    }

    // Link newNode before current head
    newNode.next = head;
    head.prev = newNode;
    head = newNode;
  }

  // Add a node at the end
  public void addLast(int data) {
    Node newNode = new Node(data);
    size++;

    // If list is empty, set both head and tail to newNode
    if (head == null) {
      head = tail = newNode;
      return;
    }

    // Link newNode after current tail
    tail.next = newNode;
    newNode.prev = tail;
    tail = newNode;
  }

  // Print list from head to tail
  public void farwardPrint() {
    if (head == null) {
      System.out.println("null");
      return;
    }

    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println();
  }

  // Print list from tail to head
  public void backwardPrint() {
    if (tail == null) {
      System.out.println("null");
      return;
    }

    Node temp = tail;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.prev;
    }
    System.out.println();
  }

  // Remove and return the first node
  public int removeFirst() {
    if (size == 0) {
      System.out.println("Empty LL");
      return -1;
    } else if (size == 1) {
      int val = head.data;
      head = tail = null;
      size = 0;
      return val;
    }

    int val = head.data;
    head = head.next;
    head.prev = null;
    size--;
    return val;
  }

  // Remove and return the last node
  public int removeLast() {
    if (size == 0) {
      System.out.println("Empty LL");
      return -1;
    } else if (size == 1) {
      int val = tail.data;
      head = tail = null;
      size = 0;
      return val;
    }

    int val = tail.data;
    tail = tail.prev;
    tail.next = null;
    size--;
    return val;
  }

  // Reverse the doubly linked list
  public void reverseLL() {
    Node curr = head;
    Node temp = null;

    // Swap next and prev for each node
    while (curr != null) {
      temp = curr.prev;
      curr.prev = curr.next;
      curr.next = temp;
      curr = curr.prev; // move to previous (which was next)
    }

    // After reversing, update head to the new head (which was tail)
    if (temp != null) {
      head = temp.prev;
    }
  }

  public static void main(String[] args) {
    DoubleLL ll = new DoubleLL();

    ll.addFirst(10);
    ll.addFirst(20);
    ll.addLast(5);
    ll.addLast(1);

    ll.farwardPrint(); // Output: 20->10->5->1->
    ll.backwardPrint(); // Output: 1->5->10->20->

    ll.removeFirst(); // removes 20
    ll.removeLast(); // removes 1

    ll.farwardPrint(); // Output: 10->5->

    ll.reverseLL();
    ll.farwardPrint(); // Output: 5->10->
  }
}

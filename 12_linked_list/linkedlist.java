
public class linkedlist {

  // Node class to define structure of linked list node
  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head; // Head of linked list
  public static Node tail; // Tail of linked list
  public static int size; // Tracking size

  // Add element at the beginning
  public void addFirst(int data) {
    Node newNode = new Node(data);
    size++;

    if (head == null) {
      head = tail = newNode;
      return;
    }

    newNode.next = head;
    head = newNode;
  }

  // Add element at the end
  public void addLast(int data) {
    Node newNode = new Node(data);
    size++;

    if (head == null) {
      head = tail = newNode;
      return;
    }

    tail.next = newNode;
    tail = newNode;
  }

  // Print the linked list
  public void print() {
    if (head == null) {
      System.out.println("null");
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println();
  }

  // Add node at specific index
  public void add(int idx, int data) {
    if (idx == 0) {
      addFirst(data);
      return;
    }
    Node newNode = new Node(data);
    size++;

    Node temp = head;
    int index = 0;

    while (index < idx - 1) {
      temp = temp.next;
      index++;
    }

    newNode.next = temp.next;
    temp.next = newNode;
  }

  // Remove first node
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
    size--;
    return val;
  }

  // Remove last node
  public int removeLast() {
    if (size == 0) {
      System.out.println("Empty LL");
      return -1;
    } else if (size == 1) {
      int val = head.data;
      head = tail = null;
      size = 0;
      return val;
    }

    Node prev = head;
    for (int i = 0; i < size - 2; i++) {
      prev = prev.next;
    }

    int val = prev.next.data;
    prev.next = null;
    tail = prev;
    size--;
    return val;
  }

  // Recursively find index of key
  public int keyFind(Node temp, int key, int i) {
    if (temp == null) {
      return -1;
    }

    if (temp.data == key) {
      return i;
    }

    return keyFind(temp.next, key, i + 1);
  }

  // Reverse linked list
  public void reverseLL() {
    Node prev = null;
    Node curr = tail = head;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    head = prev;
  }

  // Delete nth node from end (1-based)
  public void deleteNthFromEnd(int n) {
    int sz = 0;
    Node temp = head;
    while (temp != null) {
      temp = temp.next;
      sz++;
    }

    if (n == sz) {
      head = head.next;
      return;
    }

    int i = 1;
    int ToDelete = sz - n;
    Node prev = head;

    while (i < ToDelete) {
      prev = prev.next;
      i++;
    }

    prev.next = prev.next.next;
  }

  // Find middle using slow-fast pointer
  public Node FindMid(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  // Check if linked list is a palindrome
  public boolean checkPalindrome() {
    if (head == null || head.next == null) {
      return true;
    }

    Node newMid = FindMid(head);

    // Reverse second half
    Node prev = null;
    Node curr = newMid;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    Node right = prev;
    Node left = head;

    while (right != null) {
      if (right.data != left.data) {
        return false;
      }
      left = left.next;
      right = right.next;
    }

    return true;
  }

  // Detect if cycle exists using Floyd’s Algorithm
  public boolean isCycle(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  // Remove cycle using Floyd’s Algorithm
  public static void removeCycle() {
    Node slow = head;
    Node fast = head;
    boolean iscycle = false;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        iscycle = true;
        break;
      }
    }

    if (!iscycle)
      return;

    slow = head;
    Node prev = null;

    while (slow != fast) {
      prev = fast;
      slow = slow.next;
      fast = fast.next;
    }

    // Remove cycle
    prev.next = null;
  }

  // Utility to get middle node (for merge sort)
  private Node getMid(Node head) {
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  // Merge sort implementation for linked list
  public Node mergeSort(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node mid = getMid(head);
    Node rightNode = mid.next;
    mid.next = null; // split

    Node newLeft = mergeSort(head);
    Node newRight = mergeSort(rightNode);

    return merge(newLeft, newRight); // merge sorted halves
  }

  // Merge two sorted linked lists
  private Node merge(Node head1, Node head2) {
    Node mergeLL = new Node(-1); // dummy node
    Node temp = mergeLL;

    while (head1 != null && head2 != null) {
      if (head1.data <= head2.data) {
        temp.next = head1;
        head1 = head1.next;
      } else {
        temp.next = head2;
        head2 = head2.next;
      }
      temp = temp.next;
    }

    while (head1 != null) {
      temp.next = head1;
      head1 = head1.next;
      temp = temp.next;
    }

    while (head2 != null) {
      temp.next = head2;
      head2 = head2.next;
      temp = temp.next;
    }

    return mergeLL.next;
  }

  // Zig-Zag reorder of list
  public void Zig_Zag() {
    // Find mid
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    Node mid = slow;

    // Reverse 2nd half
    Node curr = mid.next;
    mid.next = null;
    Node prev = null;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    // Merge in zig-zag manner
    Node left = head;
    Node right = prev;
    Node nextL, nextR;

    while (left != null && right != null) {
      nextL = left.next;
      left.next = right;
      nextR = right.next;
      right.next = nextL;

      left = nextL;
      right = nextR;
    }
  }

  // Main method to test linked list functions
  public static void main(String[] args) {
    linkedlist ll = new linkedlist();

    ll.addFirst(1);
    ll.addFirst(2);
    ll.addFirst(3);
    ll.addFirst(4);
    ll.addFirst(5);

    ll.print();

    ll.head = ll.mergeSort(ll.head);

    ll.print();
  }
}

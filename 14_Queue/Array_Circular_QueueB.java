
public class Array_Circular_QueueB {
  static class Queue {
    int arr[];
    int size;
    int rear;
    int front;

    Queue(int n) {
      arr = new int[n];
      size = n;
      rear = -1;
      front = -1;
    }

    public boolean isEmpty() {
      return rear == -1 && front == -1;
    }

    public boolean isFull() {
      return (rear + 1) % size == front;
    }

    public void add(int data) {
      if (isFull()) {
        System.out.println("queue is full ");
        return;
      }
      if (front == -1) {
        front = front + 1;
      }
      rear = (rear + 1) % size;
      arr[rear] = data;

    }

    public int remove() {
      if (isEmpty()) {
        System.out.println("empty queue");
        return -1;
      }

      int result = arr[front];

      if (rear == front) {
        rear = front = -1;
      } else {
        front = (front + 1) % size;
      }
      return result;
    }

    public int peek() {
      if (isEmpty()) {
        System.out.println("empty queue");
        return -1;
      }

      return arr[front];
    }

  }

  public static void main(String[] args) {
    Queue q = new Queue(5);

    q.add(1);
    q.add(2);
    q.add(3);

    q.remove();
    q.add(4);
    q.remove();
    q.add(5);

    while (!q.isEmpty()) {
      System.out.println(q.peek());
      q.remove();
    }
  }
}

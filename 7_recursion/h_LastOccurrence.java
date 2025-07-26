// ===================== Last Occurrence =====================
public class h_LastOccurrence {
  public static int lastOccurrence(int[] arr, int i, int key) {
    if (i == -1)
      return -1;
    if (arr[i] == key)
      return i;
    return lastOccurrence(arr, i - 1, key);
  }

  public static void main(String[] args) {
    int[] arr = { 2, 4, 6, 4, 8, 4 };
    System.out.println(lastOccurrence(arr, arr.length - 1, 4));
  }
}

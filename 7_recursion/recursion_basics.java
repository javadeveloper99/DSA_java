public class recursion_basics {

  // Time: O(n), Space: O(n)
  public static void printNumb(int n) {
    if (n == 1) {
      System.out.print(n + " ");
      return;
    }
    System.out.print(n + " ");
    printNumb(n - 1);
  }

  // Time: O(n), Space: O(n)
  public static void printNumbr(int n) {
    if (n == 1) {
      System.out.print(1 + " ");
      return;
    }
    printNumbr(n - 1);
    System.out.print(n + " ");
  }

  // Time: O(n), Space: O(n)
  public static int fact(int n) {
    if (n == 1 || n == 0) {
      return 1;
    }
    return n * fact(n - 1);
  }

  // Time: O(n), Space: O(n)
  public static int sumOfnNum(int n) {
    if (n == 1) {
      return 1;
    }
    return n + sumOfnNum(n - 1);
  }

  // Time: O(2^n), Space: O(n)
  public static int fibonacci(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  // Time: O(n), Space: O(n)
  public static boolean isSorted(int[] arr, int i) {
    if (i == arr.length - 1) {
      return true;
    }
    if (arr[i] > arr[i + 1]) {
      return false;
    }
    return isSorted(arr, i + 1);
  }

  // Time: O(n), Space: O(n)
  public static int firstOccurrence(int[] arr, int i, int key) {
    if (i == arr.length) {
      return -1;
    }
    if (arr[i] == key) {
      return i;
    }
    return firstOccurrence(arr, i + 1, key);
  }

  // Time: O(n), Space: O(n)
  public static int lastOccurrence(int[] arr, int i, int key) {
    if (i == -1) {
      return -1;
    }
    if (arr[i] == key) {
      return i;
    }
    return lastOccurrence(arr, i - 1, key);
  }

  // Time: O(log pow), Space: O(log pow)
  public static int powFun(int n, int pow) {
    if (pow == 0) {
      return 1;
    }
    int half = powFun(n, pow / 2);
    if (pow % 2 == 0) {
      return half * half;
    } else {
      return n * half * half;
    }
  }

  // Time: O(2^n), Space: O(n)
  public static int tilesCount(int m) {
    if (m == 0 || m == 1) {
      return 1;
    }
    return tilesCount(m - 2) + tilesCount(m - 1);
  }

  // Time: O(n), Space: O(n)
  public static String removeDuplicates(String str, StringBuilder newStr, int idx, boolean[] map) {
    if (idx == str.length()) {
      return newStr.toString();
    }
    char currChar = str.charAt(idx);
    if (!map[currChar - 'a']) {
      map[currChar - 'a'] = true;
      newStr.append(currChar);
    }
    return removeDuplicates(str, newStr, idx + 1, map);
  }

  // Time: O(2^n), Space: O(n)
  public static int frindsPair(int n) {
    if (n == 0 || n == 1 || n == 2) {
      return n;
    }
    return frindsPair(n - 1) + (n - 1) * frindsPair(n - 2);
  }

  // Time: O(2^n), Space: O(n)
  public static void printBinString(int n, int lastPlace, String str) {
    if (n == 0) {
      System.out.println(str);
      return;
    }
    printBinString(n - 1, 0, str + '0');
    if (lastPlace == 0) {
      printBinString(n - 1, 1, str + '1');
    }
  }

  public static void main(String[] args) {
    int n = 3;

    // printBinString
    System.out.println("Binary Strings of length " + n + " without consecutive 1s:");
    printBinString(n, 0, "");

    // frindsPair
    System.out.println("Friend Pairing for n = 4: " + frindsPair(4));

    // removeDuplicates
    String str = "vvvvviiivveekk";
    boolean[] map = new boolean[26];
    StringBuilder newStr = new StringBuilder();
    String result = removeDuplicates(str, newStr, 0, map);
    System.out.println("After removing duplicates: " + result);

    // tilesCount
    System.out.println("Tiles count for length 2: " + tilesCount(2));

    // powFun
    System.out.println("4^2 using fast power: " + powFun(4, 2));

    // lastOccurrence
    int[] arr = { 2, 4, 6, 4, 8, 4 };
    int key = 4;
    int lastIndex = lastOccurrence(arr, arr.length - 1, key);
    System.out.println("Last occurrence of " + key + ": " + lastIndex);

    // firstOccurrence
    key = 5;
    int firstIndex = firstOccurrence(arr, 0, key);
    if (firstIndex != -1) {
      System.out.println("First occurrence of " + key + ": " + firstIndex);
    } else {
      System.out.println("Key " + key + " not found.");
    }

    // fibonacci
    System.out.println("Fibonacci number at position " + n + ": " + fibonacci(n));

    // printNumb
    System.out.print("Print in decreasing order: ");
    printNumb(n);
    System.out.println();

    // printNumbr
    System.out.print("Print in increasing order: ");
    printNumbr(n);
    System.out.println();

    // fact
    System.out.println("Factorial of " + n + ": " + fact(n));

    // sumOfnNum
    System.out.println("Sum of first " + n + " natural numbers: " + sumOfnNum(n));
  }

}
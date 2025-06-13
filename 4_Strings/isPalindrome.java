public class isPalindrome {
  public static boolean isPalindrome(String str) {
    int len = str.length() - 1;
    for (int i = 0; i <= len / 2; i++) {
      if (str.charAt(i) != str.charAt(len - i)) {
        return false;

      }
    }

    return true;
  }

  public static void main(String[] args) {
    String str = "racecar";

    System.out.println(isPalindrome(str));
  }

}
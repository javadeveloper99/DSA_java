public class string_compression {
  public static String stringCompression(String str) {
    // StringBuilder sb = new StringBuilder("");
    String newStr = "";

    for (int i = 0; i < str.length() - 1; i++) {
      Integer count = 1;
      char ch = str.charAt(i);

      while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
        count++;
        i++;
      }
      newStr += str.charAt(i);

      if (count > 1) {
        newStr += count.toString();
      }
    }

    return newStr;

  }

  public static void main(String[] args) {
    String str = "aaabbcccdd";
    System.out.println(stringCompression(str));

  }
}

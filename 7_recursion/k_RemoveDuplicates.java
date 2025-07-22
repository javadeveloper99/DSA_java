
// ===================== Remove Duplicates =====================
public class k_RemoveDuplicates {
  public static String removeDuplicates(String str, StringBuilder newStr, int idx, boolean[] map) {
    if (idx == str.length())
      return newStr.toString();
    char currChar = str.charAt(idx);
    if (!map[currChar - 'a']) {
      map[currChar - 'a'] = true;
      newStr.append(currChar);
    }
    return removeDuplicates(str, newStr, idx + 1, map);
  }

  public static void main(String[] args) {
    String str = "vvvvviiivveekk";
    boolean[] map = new boolean[26];
    StringBuilder newStr = new StringBuilder();
    System.out.println(removeDuplicates(str, newStr, 0, map));
  }
}

import java.util.Stack;

public class duplicate_Parentheses {
  public static boolean hasDuplicate(String str) {
    Stack<Character> s = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == ')') {
        int count = 0;
        while (!s.isEmpty() && s.peek() != '(') {
          s.pop();
          count++;
        }

        if (!s.isEmpty()) {
          s.pop(); // pop the opening '('
        }

        if (count == 0) {
          return true; // duplicate found
        }

      } else {
        s.push(ch);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    String expr1 = "((a+b))";
    String expr2 = "(a+(b)/c)";
    String expr3 = "(a+b+(c))";

    System.out.println(hasDuplicate(expr1)); // true
    System.out.println(hasDuplicate(expr2)); // false
    System.out.println(hasDuplicate(expr3));
}

}

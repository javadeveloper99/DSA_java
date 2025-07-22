public class b_shortest_path {

  public static double shortestPath(String str) {
    int x = 0;
    int y = 0;

    for (int i = 0; i < str.length(); i++) {
      char dir = str.charAt(i);
      if (dir == 'E') {
        x++;
      } else if (dir == 'W') {
        x--;
      } else if (dir == 'N') {
        y++;
      } else if (dir == 'S') {
        y--;
      }
    }

    return Math.sqrt(x * x + y * y);
  }

  public static void main(String[] args) {
    String str = "WNEENESENNNWNSEWNSE";
    double result = shortestPath(str);

    System.out.println("Shortest Path = " + result);
  }
}

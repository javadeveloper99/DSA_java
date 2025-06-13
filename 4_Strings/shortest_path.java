public class shortest_path {

  public static int shortestPath(String str) {
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

    double distance = Math.sqrt(x * x + y * y);
    return (int) distance; 
  }

  public static void main(String[] args) {
    String str = "WNEENESENNN";
    int result = shortestPath(str);
    System.out.println("Shortest Path = " + result);
  }
}

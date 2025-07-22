
// ===================== Tiles Count =====================
public class j_TilesProblem {
  public static int tilesCount(int m) {
    if (m == 0 || m == 1) return 1;
    return tilesCount(m - 2) + tilesCount(m - 1);
  }

  public static void main(String[] args) {
    System.out.println(tilesCount(2));
  }
}

// ===================== Tiles Count =====================
/* Problem: Tiles Count (Domino Tiling Problem)
You are given a floor of size 2 x m, and you have an unlimited supply of tiles of size 2 x 1 (domino tiles). Your task is to count the number of different ways you can tile the entire floor using these tiles.

Each tile can be placed in two orientations:

Vertically (occupies 1 column)

Horizontally (occupies 2 columns) */
public class j_TilesProblem {
  public static int tilesCount(int m) {
    if (m == 0 || m == 1)
      return 1;
    return tilesCount(m - 2) + tilesCount(m - 1);
  }

  public static void main(String[] args) {
    System.out.println(tilesCount(2));
  }
}
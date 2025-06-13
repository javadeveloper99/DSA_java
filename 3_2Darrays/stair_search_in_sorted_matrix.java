
// Time Complexity 	 O(n + m)

// Space Complexity	O(1)

public class stair_search_in_sorted_matrix {
  public static boolean stairSearch(int matrix[][], int key) {
    int i = 0;
    int j = matrix[0].length - 1;

    while (i < matrix.length && j >= 0) {
      if (matrix[i][j] == key) {
        System.out.println("found at (" + i + "," + j + ")");
        return true;
      } else if (key < matrix[i][j]) {
        j--;
      } else {
        i++;
      }

    }
    System.out.println("Invalid key , Key Not Found");

    return false;

  }

  public static void main(String[] args) {
    int matrix[][] = {
        { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 27, 29, 37, 48 },
        { 32, 33, 39, 50 }
    };

    System.out.println(stairSearch(matrix, 33));
    ;
  }
}

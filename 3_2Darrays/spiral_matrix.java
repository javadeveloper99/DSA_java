public class spiral_matrix {

  public static void printMat(int matrix[][]) {
    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {

      // top row
      for (int j = left; j <= right; j++) {
        System.out.print(matrix[top][j] + " ");
      }
      top++;

      // right column
      for (int i = top; i <= bottom; i++) {
        System.out.print(matrix[i][right] + " ");
      }
      right--;

      // bottom row
      if (top <= bottom) {
        for (int j = right; j >= left; j--) {
          System.out.print(matrix[bottom][j] + " ");
        }
        bottom--;
      }

      // left column 
      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          System.out.print(matrix[i][left] + " ");
        }
        left++;
      }
    }
  }

  public static void main(String[] args) {
    int matrix[][] = {
      { 1, 2, 3, 4 },
      { 5, 6, 7, 8 },
      { 9, 10, 11, 12 },
      { 13, 14, 15, 16 }
    };

    printMat(matrix);
  }
}

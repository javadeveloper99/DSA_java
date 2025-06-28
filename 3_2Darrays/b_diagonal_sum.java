// Time complexity - O(n)

// Space complexity - O(1)
public class b_diagonal_sum {

  public static void printMat(int matrix[][]) {

    int n = matrix.length - 1;

    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      sum += matrix[i][i];
      if (i != n - i) {
        sum += matrix[i][n - i];
      }
    }

    System.out.println(sum);
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

public class sudoku {

  public static boolean isSafeToPlace(int[][] board, int row, int col, int num) {
    // Row check
    for (int j = 0; j < 9; j++) {
      if (board[row][j] == num)
        return false;
    }

    // Column check
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == num)
        return false;
    }

    // 3x3 Subgrid check
    int startRow = (row / 3) * 3;
    int startCol = (col / 3) * 3;

    for (int i = startRow; i < startRow + 3; i++) {
      for (int j = startCol; j < startCol + 3; j++) {
        if (board[i][j] == num)
          return false;
      }
    }

    return true;
  }

  public static boolean solveSudoku(int[][] board, int row, int col) {
    if (row == 9) {
      return true; // Solved entire board
    }

    // Move to next row if col exceeds
    if (col == 9) {
      return solveSudoku(board, row + 1, 0);
    }

    // Skip prefilled cells
    if (board[row][col] != 0) {
      return solveSudoku(board, row, col + 1);
    }

    // Try placing 1 to 9
    for (int num = 1; num <= 9; num++) {
      if (isSafeToPlace(board, row, col, num)) {
        board[row][col] = num;

        if (solveSudoku(board, row, col + 1)) {
          return true;
        }

        // Backtrack
        board[row][col] = 0;
      }
    }

    return false; // No valid number found
  }

  public static void printBoard(int[][] board) {
    for (int i = 0; i < 9; i++) {
      if (i % 3 == 0 && i != 0)
        System.out.println("------+-------+------");

      for (int j = 0; j < 9; j++) {
        if (j % 3 == 0 && j != 0)
          System.out.print("| ");
        System.out.print((board[i][j] == 0 ? ". " : board[i][j] + " "));
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[][] sudokuBoard = {
        { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
        { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
        { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
        { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
        { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
        { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
        { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
        { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
        { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
    };

    System.out.println("Sudoku Board (Before Solving):");
    printBoard(sudokuBoard);

    if (solveSudoku(sudokuBoard, 0, 0)) {
      System.out.println("\nSudoku Board (After Solving):");
      printBoard(sudokuBoard);
    } else {
      System.out.println("No solution exists for the given Sudoku puzzle.");
    }
  }
}

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

  public static boolean isValidSudoku(char[][] board) {
    if (board.length == 0 || board[0].length == 0) {
      return false;
    }

    Set<String> rows = new HashSet<>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != '.') {
          if (!rows.add("Row: " + i + " has value: " + board[i][j]) ||
              !rows.add("Column: " + j + " has value: " + board[i][j]) ||
              !rows.add("Square: " + calculateSquare(i, j) + " has value: " + board[i][j])) {
            return false;
          }
        }
      }
    }

    return true;
  }

  private static int calculateSquare(int i, int j) {
    if (i < 3) {
      return 1 + j / 3;
    } else if (i < 6) {
      return 4 + j / 3;
    } else {
      return 7 + j / 3;
    }
  }

  public static void main(String[] args) {
    boolean result = isValidSudoku(
        new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}
    );

    boolean result1 = isValidSudoku(
        new char[][]{
            {'.', '.', '.', '.', '.', '.', '.', '8', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '1', '.'},
            {'.', '4', '.', '.', '9', '.', '.', '.', '.'},
            {'.', '2', '.', '.', '.', '.', '.', '3', '.'},
            {'.', '8', '.', '.', '.', '.', '5', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '6', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '3', '.', '.', '.', '.'}}
    );

    System.out.println(result);
    System.out.println(result1);
  }
}

package cci;

import java.util.Arrays;

public class RotateMatrix {

  public static void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i + 1; j < matrix[0].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      int k = 0;
      int m = matrix[i].length - 1;

      while (k < m) {
        int temp = matrix[i][k];
        matrix[i][k] = matrix[i][m];
        matrix[i][m] = temp;
        k++;
        m--;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    int[][] matrix2 = new int[][]{
        {5, 1, 9, 11},
        {2, 4, 8, 10},
        {13, 3, 6, 7},
        {15, 14, 12, 16}
    };

    rotate(matrix);
    rotate(matrix2);

    printMatrix(matrix);
    System.out.println();
    printMatrix(matrix2);
  }

  private static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }

}

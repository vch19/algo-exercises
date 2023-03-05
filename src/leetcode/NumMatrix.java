package leetcode;

public class NumMatrix {

  private final int[][] precomputed;

  public NumMatrix(int[][] matrix) {
    this.precomputed = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < precomputed.length; i++) {
      for (int j = 0; j < precomputed[0].length; j++) {
        if (i == 0) {
          precomputed[i][j] += j - 1 < 0
              ? matrix[i][j]
              : precomputed[i][j - 1] + matrix[i][j];
        } else {
          precomputed[i][j] += j - 1 < 0
              ? matrix[i][j] + precomputed[i - 1][j]
              : (precomputed[i][j - 1] - precomputed[i - 1][j - 1]) + matrix[i][j] + precomputed[i
                  - 1][j];
        }
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
//    int regionSum = precomputed[row2][col2];
//
//    if (col1 != 0 && row1 != 0) {
//      regionSum -=
//          precomputed[row2][col1 - 1] + (precomputed[row1 - 1][col2] - precomputed[row1 - 1][col1
//              - 1]);
//    } else if (col1 == 0 && row1 != 0 && col2 != 0) {
//      regionSum -= precomputed[row2][col2 - 1];
//    } else if (row2 != 0 && col1 != 0) {
//      regionSum -= precomputed[row2 - 1][col2];
//    }
//
//    return regionSum;
    return precomputed[row2][col2] -
        (row1 - 1 < 0 ? 0 : precomputed[row1 - 1][col2]) -
        (col1 - 1 < 0 ? 0 : precomputed[row2][col1 - 1]) +
        (row1 - 1 < 0 || col1 - 1 < 0 ? 0 : precomputed[row1 - 1][col1 - 1]);
  }

  public static void main(String[] args) {
    NumMatrix numMatrix = new NumMatrix(new int[][]{
        {3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}
    });

    System.out.println(numMatrix.sumRegion(2, 1, 4, 3));//8
    System.out.println(numMatrix.sumRegion(1, 1, 2, 2));//11
  }

//  public static void main(String[] args) {
//    NumMatrix numMatrix = new NumMatrix(new int[][]{
//        {-4, -5}
//    });
//
//    System.out.println(numMatrix.sumRegion(0, 1, 0, 1));//8
////    System.out.println(numMatrix.sumRegion(1, 1, 2, 2));//11
//  }

}

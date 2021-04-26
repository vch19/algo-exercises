package leetcode;

import static utils.ProjectUtils.printNdArray;

public class MatrixBlockSum {
    //Time complexity: O((n * m)^n)
    public static int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] resultMatrix = new int[mat.length][mat[0].length];
        int first = 0;
        int second = 0;

        while (first != mat.length) {
            for (int i = Math.max(first - K, 0); i < Math.min(first + K + 1, mat.length); i++) {
                for (int j = Math.max(second - K, 0); j < Math.min(second + K + 1, mat[0].length); j++) {
                    resultMatrix[first][second] += mat[i][j];
                }
            }

            second++;
            if (second == resultMatrix[0].length) {
                second = 0;
                first++;
            }
        }

        return resultMatrix;
    }

    //Time complexity: O(2(n * m))
    public static int[][] matrixBlockSumEffective(int[][] mat, int K) {
        int[][] dp = new int[mat.length + 1][mat[0].length + 1];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + mat[i][j];
            }
        }

        int[][] result = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int r1 = Math.max(0, i - K), r2 = Math.min(i + K + 1, mat.length),
                    c1 = Math.max(0, j - K), c2 = Math.min(j + K + 1, mat[0].length);
                result[i][j] = dp[r2][c2] - dp[r1][c2] - dp[r2][c1] + dp[r1][c1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        printNdArray(matrixBlockSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 1));
        printNdArray(matrixBlockSumEffective(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 1));
    }
}

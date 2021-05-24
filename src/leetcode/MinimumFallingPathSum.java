package leetcode;

public class MinimumFallingPathSum {

    //Time complexity O(n * m). Space complexity O(1)
    public static int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0];
        }

        int minPath = Integer.MAX_VALUE;

        /*
            Q: Why i equals to matrix.length - 2?
            A: Because we start our algo from penultimate array (row of matrix).
         */
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] += getMin(matrix[i + 1], j);

                /*
                    When we reach the top of our matrix we should memorize the min path.
                 */
                minPath = i == 0 ? Math.min(minPath, matrix[i][j]) : Integer.MAX_VALUE;
            }
        }

        return minPath;
    }

    private static int getMin(int[] arr, int index) {
        /*
            If it's the start of the array we can have only two appropriate candidates:
             * (i + 1, j);
             * (i + 1, j + 1);
            I do +1, because I traverse the matrix from bottom to top.
         */
        if (index == 0 && arr.length > index + 1) {
            return Math.min(arr[index], arr[index + 1]);
        } else if (index == arr.length - 1) {
            //The same situation with end of the array
            return Math.min(arr[index], arr[index - 1]);
        }
        return Math.min(arr[index], Math.min(arr[index - 1], arr[index + 1]));
    }

    public static void main(String[] args) {
        minFallingPathSum(new int[][] {
            { 2, 1, 3 },
            { 6, 5, 4 },
            { 7, 8, 9 }
        }); //13

        minFallingPathSum(new int[][] {
            { -19, 57 },
            { -40, -5 }
        }); //-59

        minFallingPathSum(new int[][] {
            { -48 }
        }); //-48

        minFallingPathSum(new int[][] {
            { 100, -42, -46, -41 },
            { 31, 97, 10, -10 },
            { -58, -51, 82, 89 },
            { 51, 81, 69, -51 }
        }); //-36
    }
}

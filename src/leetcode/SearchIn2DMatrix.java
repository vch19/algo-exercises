package leetcode;

import java.util.Arrays;

public class SearchIn2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target, 0, matrix.length);

        if (row >= 0) {
            return Arrays.binarySearch(matrix[row], target) >= 0;
        }
        return false;
    }

    //handle case where is one element
    private static int findRow(int[][] matrix, int target, int left, int right) {
        while (left < right) {
            int currentIndex = left + (right - left) / 2;

            if (matrix[0].length == 1 && matrix[currentIndex][0] == target) {
                return currentIndex;
            } else if (matrix[0].length > 1
                && matrix[currentIndex][0] <= target && matrix[currentIndex][matrix[0].length - 1] >= target) {
                return currentIndex;
            }

            if (matrix[currentIndex][0] > target) {
                right = currentIndex;
            } else {
                left = currentIndex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int[][] matrix2 = new int[][]{
            {1, 3, 5}
        };

        System.out.println(searchMatrix(matrix2, 5));
    }

}

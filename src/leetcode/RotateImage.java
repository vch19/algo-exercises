package leetcode;

public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        int firstPointer = 0;
        int secondPointer = matrix.length - 1;

        for (int i = 0; i < matrix.length; i++) {
            while (firstPointer < secondPointer) {
                int temp = matrix[i][secondPointer];
                matrix[i][secondPointer] = matrix[i][firstPointer];
                matrix[i][firstPointer] = temp;
                firstPointer++;
                secondPointer--;
            }
            firstPointer = 0;
            secondPointer = matrix.length - 1;
        }
    }

    public static void main(String[] args) {
        new RotateImage().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}

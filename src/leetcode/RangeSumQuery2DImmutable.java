package leetcode;

//View this page:https://computersciencesource.wordpress.com/2010/09/03/computer-vision-the-integral-image/
public class RangeSumQuery2DImmutable {
    private final int[][] dp;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        dp = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[0].length - 1; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] + dp[row1][col1] - dp[row2 + 1][col1];
    }

    //Not effective solution(intuitive)
    //Time complexity O(n * m) every time when we will calculate sum of sub matrix
    public int sumRegion(int row1, int col1, int row2, int col2, int[][] matrix) {
        int result = 0;

        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                result += matrix[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RangeSumQuery2DImmutable rangeSum = new RangeSumQuery2DImmutable(new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 },
            { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } });
        System.out.println(rangeSum.sumRegion(2, 1, 4,3));//8
        System.out.println(rangeSum.sumRegion(1, 1, 2,2));//11
        System.out.println(rangeSum.sumRegion(1, 2, 2, 4));//12
    }
}

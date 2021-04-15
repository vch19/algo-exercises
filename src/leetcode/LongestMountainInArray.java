package leetcode;

/**
 * In this task, we need to find the longest sequence that observes the trace of the rule, namely:
 * 1) the sequence must start with a value that is less than the previous one. [1,2].
 * 2) the sequence must be greater than or equal to 3.
 * 3) the sequence must have a rise and fall, ie [1,2,3,2,1].
 * 4) the sequence must end with a value that is less than n - 1, where n is an element that observes the 1st rule.
 */

public class LongestMountainInArray {
    public static int longestMountain(int[] A) {
        int maxMountain = 0;
        int up = 0;
        int down = 0;

        for (int i = 1; i < A.length; i++) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) {
                up = down = 0;
            }
            if (A[i - 1] < A[i]) {
                up++;
            }
            if (A[i - 1] > A[i]) {
                down++;
            }
            if (up > 0 && down > 0) {
                maxMountain = Math.max(up + down + 1, maxMountain);
            }
        }
        return maxMountain;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[] { 2, 2, 2 })); //0
        System.out.println(longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 })); //5
        System.out.println(longestMountain(new int[] { 0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 })); //11
        System.out.println(longestMountain(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })); //0
        System.out.println(longestMountain(new int[] { 0, 2, 0, 2, 1, 2, 3, 4, 4, 1 })); //3
        System.out.println(longestMountain(new int[] { 2, 3, 3, 2, 0, 2 })); //3
    }
}

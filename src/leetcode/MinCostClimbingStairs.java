package leetcode;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (length == 2) {
            return Math.min(first, second);
        }

        for (int i = 2; i < length; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }

        return Math.min(first, second);
    }

    public static void main(String[] args) {
//        minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 });
        minCostClimbingStairs(new int[] { 0, 1, 1, 0 });
    }
}

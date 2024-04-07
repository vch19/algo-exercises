package leetcode;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    private static final int MODULO = 1000000007;

    public static int sumSubarrayMins(int[] arr) {
        int[] dp = new int[arr.length];

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[]{arr[i], i});
                dp[i] = (i + 1) * arr[i];
            } else {
                while (!stack.isEmpty() && stack.peek()[0] > arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    dp[i] = (i + 1) * arr[i];
                } else {
                    int[] minVal = stack.peek();
                    dp[i] = dp[minVal[1]] + (i - minVal[1]) * arr[i];
                }
                stack.push(new int[]{arr[i], i});
            }
        }

        int targetSum = 0;

        for (int sum : dp) {
            targetSum = (targetSum % MODULO) + (sum % MODULO);
        }

        return targetSum;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{8, 6, 3, 5, 4, 9, 2}));
    }
}

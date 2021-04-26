package leetcode;

import java.util.Stack;

public class DailyTemperatures {
    //O(n^2)
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }

    public static int[] dailyTemperaturesEffective(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
        /**
         * //73 74 75 71 72 76
         * //1 1 4 2 1 1 0 0
         */
        dailyTemperaturesEffective(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
    }
}

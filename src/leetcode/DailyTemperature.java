package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 0) {
            return new int[]{0};
        }

        int[] result = new int[temperatures.length];

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, temperatures[0]});

        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[1]) {
                int[] pair = stack.pop();
                result[pair[0]] = i - pair[0];
            }
            stack.push(new int[]{i, temperatures[i]});
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}

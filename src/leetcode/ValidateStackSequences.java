package leetcode;

import java.util.Stack;

public class ValidateStackSequences {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> values = new Stack<>();

        int j = 0;

        for (int k : pushed) {
            values.add(k);

            while (!values.isEmpty() && j < popped.length && values.peek() == popped[j]) {
                values.pop();
                j++;
            }
        }

        while (!values.isEmpty() && j < popped.length && values.peek() == popped[j]) {
            values.pop();
            j++;
        }

        return values.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));//true
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));//false
        System.out.println(validateStackSequences(new int[]{2, 1, 0}, new int[]{1, 2, 0}));//true
    }
}

package leetcode;

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation {

    private static final Map<Character, BiFunction<Integer, Integer, Integer>> OPERANDS = Map.of(
        '*', (a, b) -> a * b,
        '/', (a, b) -> a / b,
        '-', (a, b) -> a - b,
        '+', Integer::sum
    );

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            char ch = tokens[i].charAt(0);
            if (isNumber(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int first = stack.pop();
                int second = stack.pop();
                Integer value = OPERANDS.get(ch).apply(second, first);
                stack.push(value);
            }
        }
        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"})); //9
//        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"})); //6
        System.out.println(
            evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));//22
    }
}

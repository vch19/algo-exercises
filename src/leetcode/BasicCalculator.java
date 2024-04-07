package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class BasicCalculator {

    private static final Map<Character, Integer> DIGITS = Map.of(
        '0', 0,
        '1', 1,
        '2', 2,
        '3', 3,
        '4', 4,
        '5', 5,
        '6', 6,
        '7', 7,
        '8', 8,
        '9', 9
    );

    public static int calculate(String s) {
        Stack<StringBuilder> pairs = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                while (!pairs.peek().toString().equals("(")) {
//                    String popped = pairs.pop().toString();
//                    if (isNumeric(popped)) {
//
//                    }
//                }
//            }

            if (Character.isDigit(s.charAt(i))) {
                pairs.peek().append(s.charAt(i));
            } else {
                pairs.add(new StringBuilder().append(s.charAt(i)));
            }
        }

        return -1;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "1 + -30";
        String[] parts = input.split("(?<!\\d)[+-](?!\\d)");
        System.out.println(Arrays.toString(parts));
    }

//    public static int calculate(String s) {
//        Stack<Character> pairs = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) != ' ' && s.charAt(i) != ')') {
//                pairs.add(s.charAt(i));
//            } else if (s.charAt(i) == ')') {
//                int category = 1;
//                int argument = 0;
//                char operation = ' ';
//
//                int[] operands = new int[2];
//
//                while (pairs.peek() != '(') {
//                    if (!Character.isDigit(pairs.peek())) {
//                        argument++;
//                        operation = pairs.pop();
//                    }
//                    operands[argument] += DIGITS.get(pairs.pop()) * category;
//                    category *= 10;
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        return -1;
//    }

    //2 + 1 + (5 - 3) + 1
}

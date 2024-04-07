package leetcode;

import java.util.Map;
import java.util.Stack;

public class RemoveKDigits {

    private static final Map<Character, Integer> DIGIT_MAP = Map.of(
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

    public static String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }

        Stack<Character> digits = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (!digits.isEmpty() && k > 0 && DIGIT_MAP.get(digits.peek()) > DIGIT_MAP.get(num.charAt(i))) {
                digits.pop();
                k--;
            }

            digits.push(num.charAt(i));
        }

        StringBuilder result = new StringBuilder();

        while (k != 0) {
            digits.pop();
            k--;
        }

        while (!digits.isEmpty()) {
            result.insert(0, digits.pop());
        }

        while (true) {
            if (result.length() != 0 && result.charAt(0) == '0') {
                result.deleteCharAt(0);
            } else {
                break;
            }
        }

        return result.length() == 0
            ? "0"
            : result.toString();
    }

    public static void main(String[] args) {
//        System.out.println(removeKdigits("1432219", 3));
//        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("112", 1));
    }
}

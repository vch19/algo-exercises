package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        recursion(result, "", n, n);

        return result;
    }

    private static void recursion(List<String> parenthesis, String current, int open, int close) {
        if (open == 0 && close == 0) {
            parenthesis.add(current);
        }
        if (open != 0) {
            recursion(parenthesis, current + "(", open - 1, close);
        }
        if (close > open) {
            recursion(parenthesis, current + ")", open, close - 1);
        }
    }

    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(3);
    }
}

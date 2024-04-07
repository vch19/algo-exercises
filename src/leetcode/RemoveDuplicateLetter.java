package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetter {

    public static String removeDuplicateLetters(String s) {
        Stack<Character> unique = new Stack<>();

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        Set<Character> used = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char currentCh = s.charAt(i);
            while (!unique.isEmpty() && currentCh < unique.peek() && freq[unique.peek() - 'a'] > 0 && !used.contains(currentCh)) {
                used.remove(unique.pop());
            }

            if (used.add(currentCh)) {
                unique.add(currentCh);
            }
            freq[currentCh - 'a']--;
        }

        StringBuilder sb = new StringBuilder();

        while (!unique.isEmpty()) {
            sb.insert(0, unique.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc")); //abc
        System.out.println(removeDuplicateLetters("cbacdcbc")); //acdb
        System.out.println(removeDuplicateLetters("cdadabcc")); //adbc
        System.out.println(removeDuplicateLetters("ccacbaba")); //acb
        System.out.println(removeDuplicateLetters("abacb")); //abc
    }
}

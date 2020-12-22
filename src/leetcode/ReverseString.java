package leetcode;

public class ReverseString {
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start <= end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    public static void main(String[] args) {
        reverseString(new char[] { 'h', 'e', 'l', 'l', 'o' });
    }
}

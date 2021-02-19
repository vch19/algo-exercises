package leetcode;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        isSubsequence("abc", "afjkdbqweqwirc");
        isSubsequence("abc", "ahbgdc");
    }
}

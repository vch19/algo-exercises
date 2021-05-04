package leetcode;

public class PalindromicSubstrings {
    //Time complexity O(n^2). Space complexity O(n^2)
    public static int countSubstrings(String s) {
        final String[][] dp = new String[s.length()][s.length()];
        int substrings = s.length();

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = String.valueOf(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = s.charAt(j) + dp[i][j - 1];
                substrings = dp[i][j].equals(s.substring(i, j + 1)) ? substrings + 1 : substrings;
            }
        }

        return substrings;
    }

    //Time complexity O(n^2). Space complexity O(n)
    public static int countSubstringsEffective(String s) {
        int substrings = 0;
        String reversed = reverse(s.toCharArray());

        for (int i = 0; i < s.length(); i++) {
            int reversedStart = reversed.length() - i - 1;
            int reversedEnd = reversed.length() - i;
            for (int j = i; j < s.length(); j++) {
                substrings = s.substring(i, j + 1).equals(reversed.substring(reversedStart--, reversedEnd))
                    ? substrings + 1
                    : substrings;
            }
        }

        return substrings;
    }

    //Custom method to reduce memory allocation.
    private static String reverse(char[] chars) {
        int a = 0;
        int b = chars.length - 1;

        while (a < b) {
            char temp = chars[a];
            chars[a++] = chars[b];
            chars[b--] = temp;
        }

        return String.valueOf(chars);
    }

    //Time complexity O(n^2). Space complexity O(1).
    //This approach based on idea that some palindromes can have the same center point.
    public static int countSubstringsLeetCodeSolution(String s) {
        int substrings = 0;

        for (int i = 0; i < s.length(); i++) {
            //for odd-length palindromes
            substrings += countPalindromesAroundCenter(s, i, i);

            //for even-length palindromes
            substrings += countPalindromesAroundCenter(s, i, i + 1);
        }

        return substrings;
    }

    private static int countPalindromesAroundCenter(String s, int low, int high) {
        int substrings = 0;
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) != s.charAt(high)) {
                break;
            }
            low--;
            high++;

            substrings++;
        }

        return substrings;
    }

    public static void main(String[] args) {
        System.out.println(countSubstringsEffective("abc"));//3
        System.out.println(countSubstringsEffective("aaa"));//6
        System.out.println(countSubstringsEffective("fdsklf"));//6
        System.out.println(countSubstringsEffective("lfla"));//5
    }
}

package leetcode;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return false;
        }
        int startPointer = 0;
        int endPointer = s.length() - 1;

        while (startPointer <= endPointer) {
            char ch1 = s.charAt(startPointer);
            char ch2 = s.charAt(endPointer);
            if (!Character.isLetterOrDigit(ch1)) {
                startPointer++;
            } else if (!Character.isLetterOrDigit(ch2)) {
                endPointer--;
            } else {
                if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                    return false;
                }
                startPointer++;
                endPointer--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new ValidPalindrome().isPalindrome("race a car");
        System.out.println(result);
    }
}

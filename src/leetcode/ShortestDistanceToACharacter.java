package leetcode;

import java.util.Arrays;

public class ShortestDistanceToACharacter {
    public static int[] shortestToChar(String s, char c) {
        int[] distance = new int[s.length()];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            distance[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            distance[i] = Math.min(distance[i], prev - i);
        }

        return distance;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e'))); //3,2,1,0,1,0,0,1,2,2,1,0
    }
}

package leetcode;

public class NumberOfSubstringContainingAllThreeCharacters {

  public static int numberOfSubstrings(String s) {
    int[] freq = new int[3];
    int res = 0;
    int left = 0;

    for (int right = 0; right < s.length(); right++) {
      freq[s.charAt(right) - 'a']++;

      while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
        //if current substring has this tree letters, all next strings will be passed in this rule
        res += s.length() - right;
        freq[s.charAt(left++) - 'a']--;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(numberOfSubstrings("abcabc"));
  }
}

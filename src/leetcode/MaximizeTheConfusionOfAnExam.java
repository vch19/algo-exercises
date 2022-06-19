package leetcode;

public class MaximizeTheConfusionOfAnExam {

  public static int maxConsecutiveAnswers(String s, int k) {
    int maxLen = 1;
    int countT = 0;
    int countF = 0;
    int left = 0;

    for (int right = 0; right < s.length(); right++) {
      if (s.charAt(right) == 'T') {
        countT++;
      } else {
        countF++;
      }

      while (Math.min(countF, countT) > k) {
        if (s.charAt(left) == 'T') {
          countT--;
        } else {
          countF--;
        }

        left++;
      }

      maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(maxConsecutiveAnswers("TTFF", 2));//4
    System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));//5
    System.out.println(maxConsecutiveAnswers("TFFT", 1));//3
    System.out.println(maxConsecutiveAnswers("F", 1));//1
    System.out.println(maxConsecutiveAnswers("FF", 1));//2
  }
}

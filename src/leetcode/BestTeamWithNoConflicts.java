package leetcode;

import java.util.Arrays;

public class BestTeamWithNoConflicts {

  public int bestTeamScore(int[] scores, int[] ages) {
    int[][] ageScorePair = new int[ages.length][2];

    for (int i = 0; i < scores.length; i++) {
      ageScorePair[i][0] = ages[i];
      ageScorePair[i][1] = scores[i];
    }

    Arrays.sort(ageScorePair, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    return findBestTeam(ageScorePair);
  }

  private int findBestTeam(int[][] ageScorePair) {
    int bestScore = 0;

    int[] dp = new int[ageScorePair.length];
    dp[0] = ageScorePair[0][1];

    for (int i = 0; i < ageScorePair.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (ageScorePair[i][1] >= ageScorePair[j][1]) {
          dp[i] = Math.max(dp[i], ageScorePair[i][1] + dp[j]);
        }
      }
      dp[i] = Math.max(dp[i], ageScorePair[i][1]);
      bestScore = Math.max(bestScore, dp[i]);
    }

    return bestScore;
  }

  public static void main(String[] args) {
    System.out.println(new BestTeamWithNoConflicts()
        .bestTeamScore(new int[]{1, 2, 3, 5}, new int[]{8, 9, 10, 1})); //16
  }

}

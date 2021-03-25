package leetcode;

public class FindTheTownJudge {
    public static int findJudge(int N, int[][] trust) {
        int[] mem = new int[N + 1];
        int[] ref = new int[N + 1];

        for (int[] arr : trust) {
            mem[arr[1]] += 1;
            ref[arr[0]] += 1;
        }

        for (int i = 0; i < mem.length; i++) {
            if (mem[i] == N - 1 && ref[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}

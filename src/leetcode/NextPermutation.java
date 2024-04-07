package leetcode;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int[] countSort = new int[101];

        int right = nums.length - 1;

        while (right >= 0) {
            int closest = getClosest(nums[right], countSort);
            countSort[nums[right]]++;

            if (closest == -1) {
                right--;
                continue;
            }

            countSort[closest]--;
            nums[right] = closest;

            fulfill(right + 1, nums, countSort);
            break;
        }

        if (right == -1) {
            Arrays.sort(nums);
        }
    }

    private void fulfill(int start, int[] result, int[] countSort) {
        for (int i = 0; i < countSort.length; i++) {
            while (countSort[i] > 0) {
                result[start++] = i;
                countSort[i]--;
            }
        }
    }

    private int getClosest(int val, int[] nums) {
        for (int i = val + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] t1 = new int[]{3, 2, 1};
        new NextPermutation().nextPermutation(t1);
        System.out.println(Arrays.toString(t1));
    }
}

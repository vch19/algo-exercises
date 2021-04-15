package leetcode;

import java.util.Arrays;

public class MaximumProductOfTwoElementsInAnArray {

    //O(NlogN)
    public static int maxProduct(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    //O(n)
    public static int maxProductEffective(int[] nums) {
        int first = 0;
        int second = 0;

        for (int i : nums) {
            if (i > first) {
                second = first;
                first = i;
            } else if (i > second) {
                second = i;
            }
        }

        return (first - 1) * (second - 1);
    }

    public static void main(String[] args) {
        System.out.println(maxProductEffective(new int[] { 3, 4, 5, 2 })); //12
        System.out.println(maxProductEffective(new int[] { 10, 2, 5, 2 })); //36
    }
}

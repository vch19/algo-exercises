package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class BalancedSums {

    public static String balancedSums(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return "NO";
        }

        int[] prefix = new int[nums.size()];
        prefix[0] = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            prefix[i] = prefix[i - 1] + nums.get(i);
        }

        for (int i = 1; i < prefix.length - 1; i++) {
            if (prefix[i - 1] == prefix[nums.size() - 1] - prefix[i]) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(balancedSums(new ArrayList<>(List.of(5, 6, 8, 11))));
    }

}

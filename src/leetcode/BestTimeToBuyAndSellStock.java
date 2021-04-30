package leetcode;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int bought = prices[0];

        for (int price : prices) {
            bought = Math.min(price, bought);
            maxProfit = Math.max(price - bought, maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));//5
    }
}

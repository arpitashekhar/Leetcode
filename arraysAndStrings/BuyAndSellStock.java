package arraysAndStrings;

public class BuyAndSellStock {
	public static int maxProfit(int[] prices) {
        int diff = 0;
		int max = 0;
		for(int i = 1; i < prices.length; i++) {
			diff = prices[i] - prices[i - 1] + Math.max(diff, 0);
			if(diff > max) max = diff;
		}
		return max;
    }
	public static void main(String[] args) {
		int[] arr = {7, 6, 4, 3, 1};
		System.out.println(maxProfit(arr));
	}
}

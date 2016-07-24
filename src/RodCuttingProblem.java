
public class RodCuttingProblem {
	public static void main(String[] args) {
		int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
		int[] dp = new int[price.length + 1];
		dp = Utils.fillArray(dp, -1);
		dp[0] = 0;
		int result = getMaxProfit(dp, price, price.length);
		System.out.println("Maximum Value : "+ result);
	}

	private static int getMaxProfit(int[] dp, int[] price, int length) {
		// TODO Auto-generated method stub
		if(length < 0) return 0;
		if(dp[length] != -1) return dp[length];
		int maxValue = Integer.MIN_VALUE;
		for(int k = 1; k <= length; k++){
			maxValue = Utils.max(maxValue, price[k - 1] + getMaxProfit(dp, price, length - k));
		}
		dp[length] = maxValue;
		return dp[length];
	}
}

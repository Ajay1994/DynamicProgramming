
public class Knapsack {
	public static void main(String[] args) {
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
		int[][] dp = new int[wt.length + 1][W + 1];
		dp = Utils.fillMatrix(dp, -1);
		for(int i = 1 ; i < dp[0].length; i++){
			dp[0][i] = 0;
		}
		for(int i = 0 ; i < dp.length; i++){
			dp[i][0] = 0;
		}
		int result = getMaxValue(val, wt, dp, wt.length, W);
		System.out.println("Maximum Value: " + result);
		Utils.printMatrix(dp);
	}

	private static int getMaxValue(int[] val, int[] wt, int[][] dp, int item, int w) {
		// TODO Auto-generated method stub
		if(item < 0 || w < 0) return 0;
		if(dp[item][w] != -1) return dp[item][w];
		if(w - wt[item - 1] >= 0){
			//Item can be accomodated in knapsack
			dp[item][w] = Utils.max(val[item - 1] + getMaxValue(val, wt, dp, item - 1, w - wt[item - 1]),
										getMaxValue(val, wt, dp, item - 1, w));
		}else{
			//item can't be accomodated. Leave the item
			dp[item][w] = getMaxValue(val, wt, dp, item - 1, w);
		}
		return dp[item][w];
	}
}

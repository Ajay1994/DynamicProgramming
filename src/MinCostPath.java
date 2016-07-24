
public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] cost = { 	{1, 2, 3},
                			{4, 8, 2},
                			{1, 5, 3} };
		int[][] dp = new int[cost.length][cost[0].length];
		dp = Utils.fillMatrix(dp, -1);
		int result = getCost(cost, dp, cost.length - 1, cost[0].length - 1);
		System.out.println("Min Cost : "+ result);
		Utils.printMatrix(dp);
	}

	private static int getCost(int[][] cost, int[][] dp, int i, int j) {
		// TODO Auto-generated method stub
		if(i < 0 || j < 0) return Integer.MAX_VALUE;
		
		if(dp[i][j] != -1) return dp[i][j];
		if(i == 0 && j == 0){
			dp[0][0] = cost[0][0];
			return dp[0][0];
		}
		
		dp[i][j] = cost[i][j] + Utils.minThree(
									getCost(cost, dp, i - 1, j),
									getCost(cost, dp, i, j - 1),
									getCost(cost, dp, i - 1, j - 1)
								);
		return dp[i][j];
	}

}

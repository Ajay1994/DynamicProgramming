
public class MinInitialPointsNeeded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {  {-2,-3,3},
                			{-5,-10,1},
                			{10,30,-5}
              			};
		int[][] dp = new int[points.length][points[0].length];
		dp = Utils.fillMatrix(dp, -1);
		int result = getMinCoins(dp, points, 0 , 0);
		Utils.printMatrix(dp);
	}

	private static int getMinCoins(int[][] dp, int[][] points, int i, int j) {
		// TODO Auto-generated method stub
		if(dp[i][j] != -1) return dp[i][j];
		if(i == points.length - 1 && j == points[0].length - 1){
			dp[i][j] = points[i][j] >= 0 ? 1 : Math.abs(points[i][j]) + 1;
			return dp[i][j];
		}
		int right = Integer.MAX_VALUE;
		int down = Integer.MAX_VALUE;
		if(j + 1 < points[0].length){
			right = getMinCoins(dp, points, i, j + 1);
		}
		if(i + 1 < points.length){
			down = getMinCoins(dp, points, i + 1, j);
		}
		int nextStepMin = Utils.min(right, down);
		dp[i][j] = nextStepMin - points[i][j] < 0 ? 1:  Math.abs(nextStepMin - points[i][j]);
		return dp[i][j];
	}

}

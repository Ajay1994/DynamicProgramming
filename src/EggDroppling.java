
public class EggDroppling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int k = 10;
		int[][] dp = new int[k + 1][n];
		
		dp = Utils.fillMatrix(dp, -1);
		for(int i = 0 ; i < dp.length; i++){
			//There is 1 egg  and k floors, we need k trials for k floors
			dp[i][0] = i;
		}
		for(int i = 1 ; i < dp[0].length; i++){
			dp[0][i] = 0; // 0 floors and i eggs - 0 trails
			dp[1][i] = 1; // 1 floor and i gess - 1 trails
		}
		int result = getTrails(dp, n, k);
		System.out.println("No of trails (n, k) : "+ result);
		Utils.printMatrix(dp);
	}

	private static int getTrails(int[][] dp, int n, int k) {
		// TODO Auto-generated method stub
		if(n < 0 || k < 0) return Integer.MAX_VALUE;
		if(dp[k][n - 1] != -1) return dp[k][n - 1];
		
		int result = Integer.MAX_VALUE;
		for(int j = 1; j <= k; j++){
			int levelCost = Utils.max(getTrails(dp, n - 1, j - 1), getTrails(dp, n, k - j));
			if(levelCost < result) result = levelCost;
		}
		dp[k][n - 1] = result + 1;
		return dp[k][n - 1];
	}

}


public class BinomialCofficient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int k = 3;
		int[][] dp = new int[k + 1][n + 1];
		
		dp = Utils.fillMatrix(dp, -1);
		for(int i = 1 ; i < dp.length; i++){
			dp[i][0] = 0;
		}
		for(int i = 0 ; i < dp[0].length; i++){
			dp[0][i] = 1;
		}
		int result = getBinomial(dp, n , k);
		System.out.println("Binomial(n, k) : "+ result);
		Utils.printMatrix(dp);
	}

	private static int getBinomial(int[][] dp, int n, int k) {
		// TODO Auto-generated method stub
		if(n < 0 || k < 0) return 0;
		if(dp[k][n] != -1) return dp[k][n];
		dp[k][n] = getBinomial(dp, n  - 1, k) + getBinomial(dp, n - 1, k - 1);
		return dp[k][n];
	}

}

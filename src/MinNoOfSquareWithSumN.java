
public class MinNoOfSquareWithSumN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[] dp = new int[n+1];
		dp = Utils.fillArray(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		int result = getMinSquare(n, dp);
		System.out.println("Result : "+  result);
		Utils.printArray(dp);
	}

	private static int getMinSquare(int n, int[] dp) {
		// TODO Auto-generated method stub
		if(n < 0) return 0;
		if(dp[n] != -1) return dp[n];
		int minValue = Integer.MAX_VALUE;
		for(int i = 1; i <= Math.sqrt(n); i++){
			minValue = Utils.min(minValue, 1 + getMinSquare(n - i * i,  dp));
		}
		dp[n] = minValue;
		return dp[n];
	}

}

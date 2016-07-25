
public class NumberEqualToSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int sum = 6;
		
		int[][] dp = new int[n+1][sum + 1];
		dp = Utils.fillMatrix(dp, -1);
		int result = 0;
		//After considering 1st letter with zero
		for(int i = 1; i < 10; i++){
			if(sum - i >= 0)
				result += getCountWithN(dp, n - 1, sum - i);
		}
		Utils.printMatrix(dp);
		System.out.println("Result : "+ result);
	}

	private static int getCountWithN(int[][] dp, int n, int sum) {
		// TODO Auto-generated method stub
		if(sum == 0){
			dp[n][sum] = 1;
			return dp[n][sum];
		}
		if(n == 0){
			dp[n][sum] = 0;
			return dp[n][sum];
		}
		if(dp[n][sum] != -1) return dp[n][sum];
		int count = 0;
		for(int i = 0; i <= 9 ; i++){
			if(sum - i >= 0){
				count += getCountWithN(dp, n - 1, sum - i);
			}
		}
		dp[n][sum] = count;
		return dp[n][sum];
	}
	

}

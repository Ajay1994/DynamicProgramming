
public class ChangeTheCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {1, 2, 3};
		int sum = 4;
		int[][] dp = new int[array.length + 1][sum + 1];
		dp = Utils.fillMatrix(dp, -1);
		for(int i = 1 ; i < dp[0].length; i++){
			dp[0][i] = 0;
		}
		for(int i = 0 ; i < dp.length; i++){
			dp[i][0] = 1;
		}
		int result = getChange(array, dp, sum, array.length);
		System.out.println("No of ways : " + result);
	}

	private static int getChange(int[] array, int[][] dp, int sum, int count) {
		// TODO Auto-generated method stub
		
		if(sum < 0 || count < 0) return 0;
		if(dp[count][sum] != -1) return dp[count][sum];
		dp[count][sum] = getChange(array, dp, sum - array[count - 1], count) 
						+ getChange(array, dp, sum, count - 1);
		return dp[count][sum];
	}

}

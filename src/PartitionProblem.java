
public class PartitionProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3, 5, 3, 3};
		
		int result = findPartionUtil(array);
		System.out.println("Result : "+ (result == 1 ? true : false));
	}

	private static int findPartionUtil(int[] array) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i : array){
			sum += i;
		}
		if(sum % 2 != 0)
			return 0;
		else{
			int[][] dp = new int[array.length + 1][(sum/2) + 1];
			dp = Utils.fillMatrix(dp, -1);
			for(int i = 1 ; i < dp[0].length; i++){
				dp[0][i] = 0;
			}
			for(int i = 0 ; i < dp.length; i++){
				dp[i][0] = 1;
			}
			int result = isSubSetSum(array, dp, array.length, sum/2);
			return result;
		}
	}

	private static int isSubSetSum(int[] array, int[][] dp, int n, int sum) {
		
		if(sum < 0 || n < 0) return 0;
		if(dp[n][sum] != -1) return dp[n][sum];
		if(sum - array[n-1] >= 0){
			dp[n][sum] = Utils.max(isSubSetSum(array, dp, n - 1, sum - array[n - 1]), 
									isSubSetSum(array, dp, n - 1, sum));
		}else{
			dp[n][sum] = isSubSetSum(array, dp, n - 1, sum);
		}
		return dp[n][sum];
	}

}

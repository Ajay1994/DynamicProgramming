
public class MatrixChainMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {10, 20, 30, 40, 30};
		int[][] dp = new int[array.length][array.length];
		dp = Utils.fillMatrix(dp, -1);
		int result = muliplyMatrix(array, dp, 1, array.length - 1);
		System.out.println("Minimum No of multiplication is : "+ result);
	}

	private static int muliplyMatrix(int[] array, int[][] dp, int i, int j) {
		// TODO Auto-generated method stub
		if(i == j){
			dp[i][j] = 0;
			return dp[i][j];
		}
		if(dp[i][j] != -1) return dp[i][j];
		int minValue = Integer.MAX_VALUE;
		for(int k = i; k < j; k++){
			minValue = Utils.min(minValue, muliplyMatrix(array, dp, i, k)
										   + muliplyMatrix(array, dp, k + 1, j)
										   + array[i - 1] * array[k] * array[j]);
		}
		dp[i][j] = minValue;
		return dp[i][j];
	}

}

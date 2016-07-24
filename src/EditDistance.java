
public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "sunday";
		String str2 = "saturday";
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		dp = Utils.fillMatrix(dp, -1);
		int result = getEditDistance(str1, str2, str1.length(), str2.length(), dp);
		System.out.println("Result LCS : "+ result);
		Utils.printMatrix(dp);
		
	}

	private static int getEditDistance(String str1, String str2, int i, int j, int[][] dp) {
		// TODO Auto-generated method stub
		if(dp[i][j] != -1) return dp[i][j];
		if(i == 0 && j == 0){
			dp[i][j] = 0;
			return dp[i][j];
		}
		if(i == 0){
			dp[i][j] = j;
			return dp[i][j];
		}
		if(j == 0){
			dp[i][j] = j;
			return dp[i][j];
		}
		if(str1.charAt(i - 1) == str2.charAt(j - 1)){
			dp[i][j] = getEditDistance(str1, str2, i - 1, j - 1, dp);
		}else{
			dp[i][j] = 1 + Utils.minThree(getEditDistance(str1, str2, i - 1, j, dp),
										  getEditDistance(str1, str2, i, j - 1, dp),
										  getEditDistance(str1, str2, i - 1, j - 1, dp)
										);
			
		}
		return dp[i][j];
	}

}

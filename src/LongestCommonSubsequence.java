
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		dp = Utils.fillMatrix(dp, -1);
		int result = getLCS(str1, str2, str1.length(), str2.length(), dp);
		System.out.println("Result LCS : "+ result);
		Utils.printMatrix(dp);
	}

	private static int getLCS(String str1, String str2, int i, int j, int[][] dp) {
		// TODO Auto-generated method stub
		if(dp[i][j] != -1) return dp[i][j];
		if(i == 0 && j == 0){
			dp[i][j] = 0;
			return dp[i][j];
		}
		if(i == 0 || j == 0){
			dp[i][j] = 0;
			return dp[i][j];
		}
		if(str1.charAt(i - 1) == str2.charAt(j - 1)){
			dp[i][j] = 1 + getLCS(str1, str2, i - 1, j - 1, dp);
		}else{
			dp[i][j] = Utils.max(getLCS(str1, str2, i - 1, j, dp), getLCS(str1, str2, i, j - 1,	 dp));
		}
		return dp[i][j];
	}

}

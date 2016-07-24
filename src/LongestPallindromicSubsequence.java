
public class LongestPallindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "BBABCBCAB";
		int[][] dp = new int[string.length()][string.length()];
		dp = Utils.fillMatrix(dp, -1);
		
		int result = getLPS(string, dp, 0, string.length() - 1);
		System.out.println("Maximum Length : "+ result);
		Utils.printMatrix(dp);
	}

	private static int getLPS(String string, int[][] dp, int i, int j) {
		// TODO Auto-generated method stub
		if(i < 0 || j < 0) return 0;
		if(i > j) return 0;
		if(i == j) return 1;
		if(dp[i][j] != -1) return dp[i][j];
		if(string.charAt(i) == string.charAt(j)){
			dp[i][j] = 2 + getLPS(string, dp, i + 1, j - 1);
			return dp[i][j];
		}
		dp[i][j] = Utils.max(getLPS(string, dp, i + 1, j), getLPS(string, dp, i, j - 1));
		return dp[i][j];
	}

}


public class PallindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "ababbbabbababa";
		int[][] isPallindrome = new int[string.length()][string.length()];
		isPallindrome = Utils.fillMatrix(isPallindrome, -1);
		for(int i = 0; i < string.length(); i++){
			for(int j = 0; j < string.length() - i; j++){
				fillIsPallindrome(isPallindrome, string, i, j + i);
			}
		}
		int[][] dp = new int[string.length()][string.length()];
		int result = getMinCut(string, dp, isPallindrome, 0, string.length() - 1);
		System.out.println("Result : "+ result);
		
		//Utils.printMatrix(isPallindrome);
	}

	private static int getMinCut(String string, int[][] dp, int[][] isPallindrome, int i, int j) {
		// TODO Auto-generated method stub
		if(i > j) return 0;
		if(isPallindrome[i][j] == 1){
			dp[i][j] = 0;
			return dp[i][j];
		}
		int minValue = Integer.MAX_VALUE;
		for(int k = i; k < j; k++){
			minValue = Utils.min(minValue, 1 + getMinCut(string, dp, isPallindrome, i, k)
											+ getMinCut(string, dp, isPallindrome, k + 1, j));
		}
		dp[i][j] = minValue;
		return dp[i][j];
	}

	private static int fillIsPallindrome(int[][] isPallindrome, String string, int i, int j) {
		// TODO Auto-generated method stub
		 
		if(isPallindrome[i][j] != -1) return isPallindrome[i][j];
		if(i == j){
			isPallindrome[i][j] = 1;
			return isPallindrome[i][j];
		}
		if(string.charAt(i) != string.charAt(j)){
			isPallindrome[i][j] = 0;
			return isPallindrome[i][j];
		}
		if(i + 1 == j)
			isPallindrome[i][j] = 1;
		else isPallindrome[i][j] = fillIsPallindrome(isPallindrome, string, i + 1, j - 1);
		return isPallindrome[i][j];
	}

}

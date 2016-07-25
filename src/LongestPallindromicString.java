
public class LongestPallindromicString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "forgeeksskeegfor";
		
		int[][] isPallindrome = new int[string.length()][string.length()];
		isPallindrome = Utils.fillMatrix(isPallindrome, -1);
		
		int[][] dp = new int[string.length()][string.length()];
		dp = Utils.fillMatrix(dp, -1);
		
		for(int i = 0; i < string.length(); i++){
			for(int j = 0; j < string.length() - i; j++){
				fillIsPallindrome(isPallindrome, dp, string, i, j + i);
			}
		}
		Utils.printMatrix(dp);
		System.out.println("Maximum Length : "+ Utils.maxMatrix(dp));
	}
	private static int fillIsPallindrome(int[][] isPallindrome,int[][] dp, String string, int i, int j) {
		// TODO Auto-generated method stub
		 
		if(isPallindrome[i][j] != -1) return isPallindrome[i][j];
		if(i == j){
			isPallindrome[i][j] = 1;
			dp[i][j] = 1;
			return isPallindrome[i][j];
		}
		if(string.charAt(i) != string.charAt(j)){
			isPallindrome[i][j] = 0;
			dp[i][j] = 0;
			return isPallindrome[i][j];
		}
		if(i + 1 == j){
			isPallindrome[i][j] = 1;
			dp[i][j] = 2;
		}else {
			isPallindrome[i][j] = fillIsPallindrome(isPallindrome,dp, string, i + 1, j - 1);
			if(isPallindrome[i][j] == 1){
				dp[i][j] = 2 + dp[i+1][j-1];
			}else{
				dp[i][j] = dp[i+1][j-1];
			}
		}
		return isPallindrome[i][j];
	}
	
}

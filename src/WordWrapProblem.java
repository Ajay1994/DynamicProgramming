public class WordWrapProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int words[] = {3, 2, 2, 5};
		int M = 6;
		int[][] dp = new int[words.length + 1][M + 1];
		dp = Utils.fillMatrix(dp, -1);
		for(int i = 0 ; i < dp[0].length; i++){
			dp[0][i] = 0;
		}
		for(int i = 1 ; i < dp.length; i++){
			dp[i][0] = Integer.MAX_VALUE;
		}
		Utils.printMatrix(dp);
		int result = getTotalCost(dp, words, words.length, M, M);
	}

	private static int getTotalCost(int[][] dp, int[] words, int wlen, int m, int M) {
		// TODO Auto-generated method stub
		if(wlen < 0 || m < 0) return Integer.MAX_VALUE;
		
		return 0;
	}

}

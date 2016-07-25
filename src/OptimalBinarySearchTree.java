
public class OptimalBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int keys[] = {10, 12, 20};
	    int freq[] = {34, 8, 50};
	    
	    int[][] dp = new int[keys.length][keys.length];
	    dp = Utils.fillMatrix(dp, -1);
	    
	    int result = getOptimalSearchCount(dp, keys, freq, 0, keys.length - 1);
	    System.out.println("Result : "+ result);
	}

	private static int getOptimalSearchCount(int[][] dp, int[] keys, int[] freq, int i, int j) {
		// TODO Auto-generated method stub
		if(i > j) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		if(i == j){
			dp[i][j] = freq[i];
			return dp[i][j];
		}
		
		int sumFreq = 0;
		for(int k = i ; k <= j; k++){
			sumFreq += freq[k];
		}
		int minValue = Integer.MAX_VALUE;
		for(int k = i; k <= j; k++){
			int left = 0;
			int right = 0;
			if(k > i){
				left = getOptimalSearchCount(dp, keys, freq, i, k - 1);
			}
			if(k < j){
				right = getOptimalSearchCount(dp, keys, freq, k + 1, j);
			}
			minValue = Utils.min(minValue, left + right);
		}
		dp[i][j] = minValue + sumFreq;
		return dp[i][j];
	}	

}

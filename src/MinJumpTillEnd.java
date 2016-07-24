
public class MinJumpTillEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] dp = new int[array.length];
		dp = Utils.fillArray(dp, -1);
		int result = getMinCount(array, dp, 0, array.length - 1);
		System.out.println("Min Jump Needed : " + result);
		Utils.printArray(dp);
	}

	private static int getMinCount(int[] array, int[] dp, int pos, int end) {
		// TODO Auto-generated method stub
		if(pos > end) return Integer.MAX_VALUE;
		if(pos == end){
			dp[end] = 0;
			return dp[end];
		}
		if(dp[pos] != -1) return dp[pos];
		int minValue = Integer.MAX_VALUE;
		for(int i = 1 ; i <= array[pos]; i++){
			minValue = Utils.min(minValue, getMinCount(array, dp, pos + i, end));
		}
		dp[pos] = minValue + 1;
		return dp[pos];
	}

}

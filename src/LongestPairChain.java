class Pair{
	int x;
	int y;
	public Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class LongestPairChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair[] pairs = new Pair[6];
		pairs[0] = new Pair(0, 6);
		pairs[1] = new Pair(1, 2);
		pairs[2] = new Pair(3, 4);
		pairs[3] = new Pair(5, 7);
		pairs[4] = new Pair(5, 9);
		pairs[5] = new Pair(8, 9);
		int[] dp = new int[pairs.length];
		dp = Utils.fillArray(dp, 1);
		int result = getLongestChain(pairs, dp);
		System.out.println("Maximum Chain Possible is : " + result);
	}

	private static int getLongestChain(Pair[] pairs, int[] dp) {
		// TODO Auto-generated method stub
		for(int i = 1 ; i < pairs.length; i++){
			int maxValue = 1;
			for(int j = 0; j < i ; j++){
				if(pairs[j].y < pairs[i].x){
					maxValue = Utils.max(maxValue, dp[j] + 1);
				}
			}
			dp[i] = maxValue;
		}
		Utils.printArray(dp);
		return Utils.maxArray(dp);
	}

}

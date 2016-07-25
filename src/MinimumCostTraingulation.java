class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class MinimumCostTraingulation {

	public static Double dist(Point p1, Point p2){
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) +
						(p1.y - p2.y) * (p1.y - p2.y));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point points[] = {new Point(0, 0), new Point(1, 0), new Point(2, 1), new Point(1, 2), new Point(0, 2)};
		Double[][] dp = new Double[points.length][points.length];
		
		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j < dp[0].length; j++){
				dp[i][j] = -1.0;
			}
		}
		
		Double result = getCostTraingulation(points, dp, 0, points.length - 1);
		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j < dp[0].length; j++){
				System.out.print(dp[i][j] +" | ");
			}
			System.out.println();
		}
		System.out.println("Result : "+ result);
	}
	private static Double getCostTraingulation(Point[] points, Double[][] dp, int i, int j) {
		// TODO Auto-generated method stub
		
		if(j < i + 2){
			dp[i][j] = 0.0;
			return dp[i][j];
		}
		if(dp[i][j] != -1.0) return dp[i][j];
		Double minValue = Double.MAX_VALUE;
		for(int k = i + 1; k < j; k++){
			minValue = Math.min(minValue, getCostTraingulation(points, dp, i, k) + 
										  getCostTraingulation(points, dp, k, j) +
										  cost(points[i], points[j], points[k]));
		}
		dp[i][j] = minValue;
		return dp[i][j];
	}
	private static Double cost(Point p1, Point p2, Point p3) {
		// TODO Auto-generated method stub
		return dist(p1, p2) + dist(p2, p3) + dist(p3, p1);
	}

}

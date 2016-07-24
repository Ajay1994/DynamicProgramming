
public class MinCostPathTillEndMatrix {
	static int R = 3;
	static int C = 3;
	public static int minCostPathRec(int[][] cost, int m , int n){
		if(m < 0 || n < 0) return Integer.MAX_VALUE;
		if(m == 0 && n == 0) return cost[m][n]; // Cost of reaching [0][0]
		return cost[m][n] + min(minCostPathRec(cost, m-1, n-1), minCostPathRec(cost, m-1, n), minCostPathRec(cost, m, n-1));
	}
	public static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " | ");
			}
			System.out.println();
		}
	}
	public static int minCostPathMem(int[][] cost, int m , int n){
		int[][] pathCost = new int[m + 1][n + 1];
		for(int i = 0 ; i <= m; i++){
			pathCost[i][0] = cost[i][0];
		}
		for(int i = 0 ; i <= n; i++){
			pathCost[0][i] = cost[0][i];
		}
		printMatrix(pathCost);
		for(int i = 1 ; i <= m; i++){
			for(int j = 1; j <= n; j++){
				pathCost[i][j] = cost[i][j] + min(pathCost[i-1][j-1],pathCost[i][j-1],pathCost[i-1][j]);
			}
		}
		return pathCost[m][n];
	}
	private static int min(int i, int j, int k) {
		// TODO Auto-generated method stub
		int min = Utils.min(i, j);
		min = Utils.min(min, k);
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] cost = { {1, 2, 3},
		                   {4, 8, 2},
		                   {1, 5, 3} };
		System.out.println("Minimum Cost Path Rec: " + minCostPathRec(cost, 2, 2));
		System.out.println("Minimum Cost Path DP: " + minCostPathMem(cost, 2, 2));
		
	}

}

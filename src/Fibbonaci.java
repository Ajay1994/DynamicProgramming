import java.util.*;
public class Fibbonaci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Top Down Approach always ask for recursion. 
		// Optimal Substructure means sub part of solution is also optimal.
		// The size of matrix made depends upon the no of dependent variables of recursion.
		// Fill the part of the matrix which can be base cases.
		// Handle the cases of recursion which can go out of boundary
		// Check if the value already present in dp matrix, then simply return it
		
		int n = 7;
		int[] dp = new int[n + 1];
		dp = Utils.fillArray(dp, -1);
		int result = findFibbonaci(n, dp);
		System.out.println("Top Down Fibbonacci : " + result);
	}

	private static int findFibbonaci(int n, int[] dp) {
		// TODO Auto-generated method stub
		if(dp[n] != -1) return dp[n];
		if(n == 0){
			dp[0] = 0;
			return dp[0];
		}
		if(n == 1){
			dp[1] = 1;
			return dp[1];
		}
		dp[n] = findFibbonaci(n - 1, dp) + findFibbonaci(n - 2, dp);
		return dp[n];
	}

}


public class LongestSumContigious {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		int maxSum = array[0];
		int currentSum = array[0];
		for(int i = 1 ; i < array.length; i++){
			currentSum = Utils.max(currentSum + array[i], array[i]);
			maxSum = Utils.max(maxSum, currentSum);
		}
		System.out.println("Result : " + maxSum);
	}

}

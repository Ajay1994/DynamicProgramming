
public class LongestBiotonicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 11, 2, 10, 4, 5, 2, 1};
		
		int[] LIS = getLIS(array);
		int[] LDS = getLDS(array);
		int maxValue = Integer.MIN_VALUE;
		for(int i = 0 ; i < array.length; i++){
			maxValue = Utils.max(maxValue, LIS[i] + LDS[i]);
		}
		System.out.println("Result : " + (maxValue - 1));
	}

	private static int[] getLIS(int[] array) {
		// TODO Auto-generated method stub
		int[] LIS = new int[array.length];
		LIS = Utils.fillArray(LIS, 1);
		for(int i = 1; i < array.length; i++){
			int maxValue = Integer.MIN_VALUE;
			for(int j = 0 ; j < i ; j++){
				if(array[j] < array[i]){
					maxValue = Utils.max(maxValue, LIS[j]);
				}
			}
			LIS[i] = Utils.max(maxValue + 1, 1);
		}
		Utils.printArray(LIS);
		return LIS;
	}
	private static int[] getLDS(int[] array) {
		// TODO Auto-generated method stub
		int[] LIS = new int[array.length];
		LIS = Utils.fillArray(LIS, 1);
		for(int i = 1; i < array.length; i++){
			int maxValue = Integer.MIN_VALUE;
			for(int j = 0 ; j < i ; j++){
				if(array[j] > array[i]){
					maxValue = Utils.max(maxValue, LIS[j]);
				}
			}
			LIS[i] = Utils.max(maxValue + 1, 1);
		}
		Utils.printArray(LIS);
		return LIS;
	}
}

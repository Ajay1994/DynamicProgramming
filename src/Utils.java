
public class Utils {

	public static int max(int i, int j) {
		// TODO Auto-generated method stub
		return i > j ? i : j;
	}
	public static int min(int i, int j) {
		// TODO Auto-generated method stub
		return i < j ? i : j;
	}
	public static void printArray(int[] array){
		for(int i = 0; i< array.length; i++){
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}
	public static int maxArray(int[] array){
		int maxValue = array[0];
		for(int i = 1; i< array.length; i++){
			maxValue = Math.max(maxValue, array[i]);
		}
		return maxValue;
	}
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void printObjArray(Integer[] array){
		for(int i = 0; i< array.length; i++){
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}
	public static void printMatrix(int[][]matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				System.out.print(matrix[i][j] + " | ");
			}
			System.out.println();
		}
	}
	public static int minThree(int i, int j , int k){
		int min = Utils.min(i,j);
		return Utils.min(min, k);
	}
	public static int[] fillArray(int[] array, int k){
		for(int i = 0; i < array.length; i++){
			array[i] = k;
		}
		return array;
	}
	public static int[][] fillMatrix(int[][] matrix, int k){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = k;
			}
		}
		return matrix;
	}
	public static int[][][] fill3DMatrix(int[][][] matrix, int k){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				for(int l = 0; l < matrix[0][0].length; l++){
					matrix[i][j][l] = k;
				}
			}
		}
		return matrix;
	}
	public static boolean isvalid(int i, int j, int [][] matrix)
	{
	    if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
	      return false;
	    return true;
	}
}

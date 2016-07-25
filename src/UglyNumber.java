
public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		int number = 11;
		int[] ugly = new int[number];
		ugly[0] = 1;
		int pos = 1;
		while(pos < number){
			int x = ugly[i2] * 2;
			int y = ugly[i3] * 3;
			int z = ugly[i5] * 5;
			int next_ugly = Utils.minThree(ugly[i2] * 2, ugly[i3] * 3, ugly[i5] * 5);
			//System.out.println("Number : "+ next_ugly + " i2 : "+ ugly[i2] * 2+ " i3 : "+ ugly[i3] * 3+ " i5 : "+  ugly[i5] * 5);
			if(next_ugly == x) i2 += 1;
			if(next_ugly == y) i3 += 1;
			if(next_ugly == z) i5 += 1;
			
			ugly[pos++] = next_ugly;
			
		}
		//Utils.printArray(ugly);
		System.out.println("Result : "+ ugly[pos -1]);
	}

}

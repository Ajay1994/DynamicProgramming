import java.util.Arrays;
import java.util.Comparator;

class Box{
	int height;
	int width;
	int length;
	//Generality length > width
	public Box(int h, int w, int l){
		this.height = h;
		this.width = w;
		this.length = l;
	}
}
public class BoxStackingProblem {
	public static void main(String[] args) {
		Box[] box = new Box[4];
		box[0] = new Box(4, 6, 7);
		box[1] = new Box(1, 2, 3);
		box[2] = new Box(4, 5, 6);
		box[3] = new Box(10, 12, 32);
		
		Box[] boxes = new Box[box.length * 3];
		rotateBoxes(boxes, box);
		for(Box b : boxes){
			System.out.println("{ " + b.height + " , " + b.width + " , " + b.length + " }");
		}
		Arrays.sort(boxes, new Comparator<Box>(){
			@Override
			public int compare(Box x, Box y) {
				// TODO Auto-generated method stub
				if( (x.width * x.length) > (y.width * y.length) ) return -1;
				else if((x.width * x.length) < (y.width * y.length)) return 1;
				else return 0;
			}
			
		});
		System.out.println("\nAfter Sorting : \n");
		for(Box b : boxes){
			System.out.println("{ " + b.height + " , " + b.width + " , " + b.length + " }");
		}
		int[] dp = new int[boxes.length];
		
		int result = getMaxHeight(boxes, dp);
		System.out.println("Maximum Height : "+ result);
	}

	private static int getMaxHeight(Box[] boxes, int[] dp) {
		// TODO Auto-generated method stub
		dp[0] = boxes[0].height;
		for(int i = 1; i < boxes.length; i++){
			int maxValue = Integer.MIN_VALUE;
			for(int j = 0 ; j < i ; j++){
				if(boxes[i].width < boxes[j].width && boxes[i].length < boxes[j].length){
					maxValue = Utils.max(maxValue, dp[j]);
				}
			}
			dp[i] = maxValue + boxes[i].height;
		}
		Utils.printArray(dp);
		return Utils.maxArray(dp);
	}

	private static void rotateBoxes(Box[] boxes, Box[] box) {
		// TODO Auto-generated method stub
		int i = 0;
		for(Box b : box){
			boxes[i] = new Box(b.height, Math.min(b.width, b.length), Math.max(b.width, b.length));;
			boxes[i + 1] = new Box(b.width, Math.min(b.height, b.length), Math.max(b.height, b.length));
			boxes[i + 2] = new Box(b.length, Math.min(b.height, b.width), Math.max(b.height, b.width));
			i += 3;
		}
	}
}

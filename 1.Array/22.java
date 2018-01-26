import java.util.Arrays;
import java.util.Comparator;
/**
 * Arrange given numbers to form the biggest number
 * 
 * Space Complexity O(1)
 * Time Complexity  O(nlogn)
 */
class Array {
	public static void main(String args[]) {
		Integer a[] = {54, 546, 548, 60};
		System.out.println(Arrays.toString(a));
		makeLargest(a);
		System.out.println(Arrays.toString(a));
	}
	
	static void makeLargest(Integer a[]) {
		Arrays.sort(a, new Comparator<Integer>() {
			public int compare(Integer X, Integer Y) {
				String XY = Integer.toString(X) + Integer.toString(Y);
				String YX = Integer.toString(Y) + Integer.toString(X);
				
				return XY.compareTo(YX) > 0?-1:1;
			}
		});
	}
}

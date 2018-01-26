import java.util.Arrays;
import java.util.Random;
/**
 * Shuffle an array
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(Arrays.toString(a));
		shuffle(a);
		System.out.println(Arrays.toString(a));
	}
	
	static void shuffle(int a[]) {
		int n = a.length;
		Random r = new Random();
		for(int i=n-1;i>0;i--) {
			int pos = r.nextInt(i);
			int temp = a[i];
			a[i] = a[pos];
			a[pos] = temp;
		}
	}
}

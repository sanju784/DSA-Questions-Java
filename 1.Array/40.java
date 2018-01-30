import java.util.Arrays;

/**
 * Maximum sum such that no two elements are adjacent
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {5,  5, 10, 40, 50, 35};
		System.out.println(Arrays.toString(a));
		maxSum(a);
	}

	static void  maxSum(int a[]) {
		int inc = a[0];
		int exc = 0;
		int exc_new;
		for(int i=1;i<a.length;i++) {
			exc_new = Math.max(inc, exc);
			inc = exc + a[i];
			exc = exc_new;
		}
		System.out.println(Math.max(inc, exc));
	}
}

import java.util.Arrays;

/**
 * Find the closest pair from two sorted arrays
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {1, 4, 5, 7};
		int b[] = {10, 20, 30, 40};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		int x = 38;
		closePair(a, b, x);
	}

	static void  closePair(int a[], int b[], int x) {
		int m = a.length;
		int n = b.length;
		int l=0, r=n-1;
		int res_l = 0, res_r =0;
		int diff = Integer.MAX_VALUE;
		while(l < m && r >= 0) {
			if(Math.abs(a[l] + b[r] - x) < diff) {
				diff = Math.abs(a[l] + b[r] - x);
				res_l = l;
				res_r = r;
			}
			if(a[l] + b[r] > x)
				r--;
			else
				l++;
		}
		System.out.println("Closest Pair of " +x + " is " + a[res_l] + " " + b[res_r]);
	}
}

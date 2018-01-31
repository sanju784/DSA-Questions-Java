import java.util.Arrays;

/**
 * Find maximum j-i such that a[j] > a[i]
 * 
 * Space Complexity O(n)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		System.out.println(Arrays.toString(a));
		maxDiff(a);
	}

	static void  maxDiff(int a[]) {
		int n = a.length;
		int LMin[] = new int[n];
		int RMax[] = new int[n];
		LMin[0] = a[0];
		for(int i=1;i<n;i++) {
			LMin[i] = Math.min(a[i], LMin[i-1]);
		}
		RMax[n-1] = a[n-1];
		for(int i=n-2;i>=0;i--) {
			RMax[i] = Math.max(a[i], RMax[i+1]);
		}
		System.out.println(Arrays.toString(LMin));
		System.out.println(Arrays.toString(RMax));
		int res = -1;
		int i=0, j=0;
		while(i<n && j<n) {
			if(LMin[i] < RMax[j]) {
				res = Math.max(res, j-i);
				j++;
			} else {
				i++;
			}
		}
		System.out.println(res);
	}
}

import java.util.Arrays;

/**
 * Find the maximum repeating number in an array
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {2, 3, 3, 5, 3, 4, 1, 7};
		System.out.println(Arrays.toString(a));
		maxOcc(a);
	}

	//finding maximum of (a[a[i]%k] + k)
	static void  maxOcc(int a[]) {
		int n = a.length;
		int k = 8;
		for(int i=0;i < n;i++) {
			a[a[i]%k] += k;
		}
		int max = Integer.MIN_VALUE;
		int max_idx = -1;
		for(int i=0;i<n;i++) {
			if(a[i] > max) {
				max = a[i];
				max_idx=i;
			}
		}
		System.out.println(max_idx);
	}
	//Alternate way - using count sort in O(n) time and O(n) space complexity
}

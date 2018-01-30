import java.util.Arrays;

/**
 * Smallest missing number in a sorted array
 * 
 * Space Complexity O(1)
 * Time Complexity  O(Logn)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
		System.out.println(Arrays.toString(a));
		int n = a.length;
		System.out.println(smallestMissing(a, 0, n));
	}

	static int  smallestMissing(int a[], int start, int end) {
		if(start != a[start])
			return start;
		int mid = (start + end)/2;
		if(a[mid] == mid) {
			return smallestMissing(a, mid+1, end);
		}
		return smallestMissing(a, start, mid-1);
	}
}

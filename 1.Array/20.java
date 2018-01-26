import java.util.Arrays;
/**
 * Maximum circular subarray sum
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {11, 10, -20, 5, -3, -5, 8, -13, 10};
		
		System.out.println(Arrays.toString(a));
		
		System.out.println("Max circular sum: " + maxCircularSum(a));
	}
	
	static int maxCircularSum(int a[]) {
		int n = a.length;
		int max_kadane = kadane(a);
		int arr_sum = 0;
		for(int i=0;i<n;i++) {
			arr_sum += a[i];
			a[i] = -1 * a[i];
		}
		int rev_kadane = kadane(a);
		int rev_result = arr_sum + rev_kadane;
		return Math.max(max_kadane, rev_result);
	}
	
	static int kadane(int a[]) {
		int n = a.length;
		int max_so_far = 0, max_ending_here = 0;
		for(int i=0;i<n;i++) {
			max_ending_here = max_ending_here + a[i];
			if(max_ending_here < 0)
				max_ending_here = 0;
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}
}

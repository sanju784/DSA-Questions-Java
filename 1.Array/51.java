import java.util.Arrays;

/**
 * Smallest subarray with sum greater than a given value
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
	
	public static void main(String args[]) {
		int a[] = {1, 4, 45, 6, 10, 19};
		System.out.println(Arrays.toString(a));
        int sum = 51;
        subArr(a,  sum);
	}
	
	static void subArr(int a[], int x) {
		int start = 0, end = 0;
		int n = a.length;
		int min_len = n+1, curr_sum = 0;
		while(end < n) {
			
			while(curr_sum <= x && end < n) {
				if(curr_sum <= 0 && x > 0) {
					start = end;
					curr_sum = 0;
				}
				curr_sum += a[end++];
			}
			
			while(curr_sum > x && start < n) {
				if(end - start < min_len)
					min_len = end-start;
				curr_sum = curr_sum - a[start++];
			}
		}
		if(min_len == n+1)
			System.out.println("No possible subarray");
		else
			System.out.println(min_len + " " + start + " " + end);
	}
}


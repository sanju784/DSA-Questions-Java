import java.util.Arrays;

/**
 * Maximum Sum Path in Two Arrays
 * 
 * Space Complexity O(1)
 * Time Complexity  O(m+n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {2, 3, 7, 10, 12, 15, 30, 34};
		int b [] = {1, 5, 7, 8, 10, 15, 16, 19};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		maxSum(a, b);
	}

	static void  maxSum(int a[], int b[]) {
		int m = a.length;
		int n = b.length;
		int i=0, j=0;
		int result = 0, sum1 =0, sum2=0;
		while(i<m && j<n) {
			if(a[i] < b[j])
				sum1 += a[i++];
			else if (b[j] < a[i])
				sum2 += b[j++];
			else {
				result += Math.max(sum1, sum2);
				
				sum1 =0;
				sum2 =0;
				
				while(i < m && j < n && a[i] == b[j]) {
					result += a[i++];
					j++;
				}
			}
		}
		while(i < m)
			sum1 += a[i++];
		while(j < n)
			sum2 += b[j++];
		
		result += Math.max(sum1, sum2);
		System.out.println(result);
	}
}

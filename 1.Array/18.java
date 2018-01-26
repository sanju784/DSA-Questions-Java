import java.util.Arrays;
/**
 * Maximum Product Subarray
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {

	public static void main(String args[]) {
		int a[] = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(Arrays.toString(a));
		System.out.println("Maximum product is " + maxProd(a));
	}
	
	static int maxProd(int a[]) {
		int n = a.length;
		int curr_prod = a[0], max_prod = a[0];
		for(int i=1;i<n;i++) {
			if(a[i] == 0) {
				curr_prod = 1;
				continue;
			}
			if(curr_prod*a[i] > max_prod) {
				max_prod = curr_prod*a[i];
			}
			curr_prod = curr_prod*a[i];
		}
		return max_prod;
	}
}

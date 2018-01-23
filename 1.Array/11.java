import java.util.Arrays;
/**
 * Rearrange a sorted array in maximum minimum form
 * 
 * Space Complexity O(n)
 * Time Complexity  O(n)
 */
class Array {

	public static void main(String args[]) {
		int a[] = {1, 2, 3, 4, 5, 6, 7};
		int n = a.length;
		System.out.println(Arrays.toString(a));
		rearrange(a,n);
		System.out.println(Arrays.toString(a));
	}
	
	static void rearrange(int a[], int n) {
		int start = 0, end = n-1;
		int temp[] = new int[n];
		boolean flag = true;
		for(int i=0;i<n;i++) {
			if(flag) {
				temp[i] = a[end--];
			} else {
				temp[i] = a[start++];
			}
			flag = !flag;
		}
		System.arraycopy(temp, 0, a, 0, n);
	}
}

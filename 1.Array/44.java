import java.util.Arrays;
import java.util.HashSet;

/**
 * Find the smallest positive number missing from an unsorted array
 * 
 * Space Complexity O(n)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {1, 1, 0, -1, -2};
		System.out.println(Arrays.toString(a));
		minEle(a);
	}

	static void  minEle(int a[]) {
		int n = a.length;
		HashSet<Integer> hs = new HashSet<>();
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(a[i] > 0)
				hs.add(a[i]);
			if(a[i] > max)
				max = a[i];
		}
		int i;
		for(i=1;i<=max;i++)
		{
			if(hs.contains(i) == false) {
				System.out.println(i);
				break;
			}
		}
		if(i==max +1)
			System.out.println(max+1);
	}
}

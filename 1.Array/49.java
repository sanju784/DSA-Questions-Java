import java.util.Arrays;

/**
 * zeroes to be flipped so that number of consecutive 1Åfs is maximized
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
		System.out.println(Arrays.toString(a));
		int m = 2;
		zeroFlip(a, m);
	}

	static void  zeroFlip(int a[], int m) {
		int n = a.length;
		int wL = 0, wR = 0;
		int bestL = 0, bestWindow = 0;
		int zeroCount = 0;
		while(wR < n) {
			if(zeroCount <= m) {
				if(a[wR] == 0)
					zeroCount++;
				wR++;
			}
			if(zeroCount > m) {
				if(a[wL] == 0)
					zeroCount--;
				wL++;
			}
		}
		if(wR-wL > bestWindow)
		{
			bestL = wL;
			bestWindow = wR-wL;
		}
		for(int i=wL;i<wL+bestWindow;i++) {
			if(a[i] == 0)
				System.out.println(i);
		}
	}
}

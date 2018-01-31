import java.util.Arrays;

/**
 * Minimum distance between two numbers in an array
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		System.out.println(Arrays.toString(a));
		int x = 3;
		int y = 6;
		minDist(a, x, y);
	}

	static void  minDist(int a[], int x, int y) {
		int posX = -1, posY = -1;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++) {
			if(a[i] == x) {
				if(posY != -1) {
					if (min > Math.abs(posY-i))
						min = Math.abs(posY-i);
				} else {
					posX = i;
				}
			} else if(a[i] == y) {
				if(posX != -1) {
					if(min > Math.abs(i-posX))
						min = Math.abs(i-posX);
				} else {
					posY = i;
				}
			}
		}
		System.out.println(min);
	}
}

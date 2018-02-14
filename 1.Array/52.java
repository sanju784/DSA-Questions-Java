import java.util.Arrays;
import java.util.Comparator;

/**
 * 4 elements from an array that sum to a value
 * 
 * Space Complexity O(n^2)
 * Time Complexity  O(n^2Log n)
 */
class Array {
	
	public static void main(String args[]) {
		int a[] = {10, 20, 30, 40, 1, 2};
		System.out.println(Arrays.toString(a));
        int sum = 91;
        maxAvg(a,  sum);
	}
	
	static void maxAvg(int a[], int x) {
		int n = a.length;
		int size = n*(n-1)/2;
		Data arr[] = new Data[size];
		int k=0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				int sum = a[i] + a[j];
				arr[k] = new Data(i, j, sum);
				k++;
			}
		}
		
		Arrays.sort(arr, new Comparator<Data> () {
			public int compare(Data a, Data b) {
				return a.sum - b.sum;
			}
		});

		int i =0, j= size -1;
		while(i<size && j>=0) {
			if((arr[i].sum + arr[j].sum == x) && noCommon(arr[i], arr[j]))
			{
				System.out.println(a[arr[i].x] + " " + a[arr[i].y] + " " + a[arr[j].x] + " " + a[arr[j].y]);
				return;
			} else if(arr[i].sum + arr[j].sum < x) {
				i++;
			} else {
				j--;
			}
		}
	}
	
	static boolean noCommon(Data a, Data b) {
		if(a.x == b.x || a.x == b.y || a.y == b.x || a.y == b.y)
			return false;
		return true;
	}
}

class Data {
	int x;
	int y;
	int sum;
	public Data(int i, int j, int s) {
		x=i;
		y=j;
		sum=s;
	}
	
	public String toString() {
		return " " + sum;
	}
}
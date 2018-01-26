import java.util.Arrays;
/**
 * Sort a nearly sorted (or K sorted) array
 * 
 * Space Complexity O(k)
 * Time Complexity  O(nlogk)
 */
class Array {
	static int heap[];
	static int size;
	public static void main(String args[]) {
		int a[] = {2, 6, 3, 12, 56, 8};
		int k = 3;
		heap = new int[k+1];
		size = k+1;
		System.out.println(Arrays.toString(a));
		sortK(a, k);
		System.out.println(Arrays.toString(a));
	}
	
	static void sortK(int a[], int k) {
		for(int i =0;i<size;i++) {
			heap[i] = a[i];
		}
		for(int i =(size -1)/2;i >= 0;i--) {
			MinHeapify(i);
		}
		int n = a.length;
		for(int i=k+1, ti=0;ti<n;i++,ti++)
		{
			if(i<n) {
				a[ti] = replaceMin(a[i]);
			} else {
				a[ti] = extractMin();
			}
		}
	}
	
	static void MinHeapify(int i) {
		int l = 2*i+1;
		int r = 2*i+2;
		int min = i;
		if(l < size && heap[l] < heap[i]) {
			min = l;
		}
		if(r < size && heap[r] < heap[min]) {
			min = r;
		}
		if(min != i) {
			int temp = heap[min];
			heap[min] = heap[i];
			heap[i] = temp;
			MinHeapify(min);
		}
	}
	
	static int replaceMin(int x) {
		int root = heap[0];
		heap[0] = x;
		MinHeapify(0);
		return root;
	}
	
	static int extractMin() {
		int root = heap[0];
		if(size > 1) {
			heap[0] = heap[size -1];
			size--;
			MinHeapify(0);
		}
		return root;
	}
}

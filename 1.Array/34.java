import java.util.Arrays;
/**
 * k largest numbers of an array
 * 
 * Space Complexity O(k)
 * Time Complexity  O(k + (n-k)Logk)
 */
class Array {
    static int heap[];
    static int size;
    public static void main(String[] args) {
        int a[] = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        size=k;
        heap = new int[size];
        System.out.println(Arrays.toString(a));
        for(int i=0;i<k;i++) {
            heap[i] = a[i];
        }
        for(int i=(k-1)/2;i>=0;i--) {
            minHeapify(i);
        }
        for(int i=k;i<a.length;i++) {
            if(a[i] > heap[0]) {
                heap[0] = a[i];
                minHeapify(0);
            }
        }
        System.out.println(Arrays.toString(heap));
    }
    
    static void minHeapify(int i) {
        int min =i, l=2*i+1, r=2*i+2;
        if(l < size && heap[l] < heap[i]) {
            min = l;
        }
        if(r<size && heap[r] < heap[min]) {
            min = r;
        }
        if(min != i) {
            int temp = heap[min];
            heap[min] = heap[i];
            heap[i] = temp;
        }
    }
}
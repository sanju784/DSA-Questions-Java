import java.util.Arrays;
/**
 * Search in a rotated array
 * 
 * Space Complexity O(1)
 * Time Complexity  O(log n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {4, 5, 6, 7, 8, 1, 2, 3};
        int n = a.length;
        int key = 7;
        System.out.println(Arrays.toString(a));
        int pivot = getPivot(a, 0, n);
        if(key < a[pivot] && key > a[0]) {
            search(a, 0, pivot, key);
        }
        else if(key > a[pivot+1] && key < a[n-1]) {
            search(a, pivot+1, n, key);
        }
        else {
            System.out.println(key + " is not in Array.");
        }
    }

    static void search(int a[], int start, int end, int key) {
        while(start < end) {
            int mid = (start+end)/2;
            if(a[mid] == key) {
                System.out.println("Found " + key + " at " + mid);
                return;
            } else if(key < a[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        System.out.println(key + " is not in Array.");
    }

    static int getPivot(int a[], int start, int end) {
        if(end < start)
            return -1;
        if(end == start)
            return start;
        int mid = (start+end)/2;
        if(mid < end && a[mid] > a[mid + 1])
            return mid;
        if(mid > start && a[mid] < a[mid-1])
            return mid-1;
        if(a[start] >= a[mid])
            return getPivot(a, start, mid -1);
        return getPivot(a, mid+1, end);
    }
}

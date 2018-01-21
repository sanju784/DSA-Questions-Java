import java.util.Arrays;
/**
 * Find minimum in rotated array
 * 
 * Space Complexity O(1)
 * Time Complexity  O(log n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {5,6,1,2,3,4};
        int n = a.length;
        System.out.println(Arrays.toString(a));
        System.out.println("Min :" + getMin(a, n));
    }

    static int getMin(int a[], int n) {
        int start = 0, end = n-1;
        while(start < end) {
            int mid = (start + end) /2;
            if(a[mid] < a[mid -1])
                return a[mid];
            if(a[mid] < a[end])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
}

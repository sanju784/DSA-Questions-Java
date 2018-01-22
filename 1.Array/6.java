import java.util.Arrays;
/**
 * Reverse an array
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = a.length;
        System.out.println(Arrays.toString(a));
        reverse(a, 0, n-1);
        System.out.println(Arrays.toString(a));
    }

    static void reverse(int a[], int start, int end) {
        if(start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            reverse(a, start+1, end-1);
        }
    }
}

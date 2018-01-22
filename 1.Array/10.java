import java.util.Arrays;
/**
 * Three way partitioning of an array around a given range
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        int low = 10, high = 20;
        System.out.println(Arrays.toString(a));
        partition(a, low,high);
        System.out.println(Arrays.toString(a));
    }
    static void partition(int a[], int low, int high) {
        int n = a.length;
        int start = 0, end = n-1;
        for(int i=0; i<end;) {
            if(a[i] < low) {
                int temp = a[start];
                a[start] = a[i];
                a[i] = temp;
                start++;
                i++;
            } else if(a[i] > high) {
                int temp = a[end];
                a[end] = a[i];
                a[i] = temp;
                end--;
            } else {
                i++;
            }
        }
    }
}

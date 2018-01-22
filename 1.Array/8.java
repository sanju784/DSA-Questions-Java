import java.util.Arrays;
/**
 * Arrange array with all negative at start and in order
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n^2)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int n = a.length;
        System.out.println(Arrays.toString(a));
        rearrange(a, n);
        System.out.println(Arrays.toString(a));
    }

    static void rearrange(int a[], int n) {
        for(int i=1;i<n;i++) {
            int key = a[i];
            if(key > 0) {
                continue;
            } else {
                int j = i-1;
                while (j >=0 && a[j] >0) {
                    a[j+1] = a[j];
                    j--;
                }
                a[j+1] = key;
            }
        }
    }
    
    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

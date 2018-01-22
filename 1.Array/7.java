import java.util.Arrays;
/**
 * Arrange array in wave form
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {10, 5, 6, 3, 2, 20, 100, 80};
        int n = a.length;
        System.out.println(Arrays.toString(a));
        rearrange(a, n);
        System.out.println(Arrays.toString(a));
    }

    static void rearrange(int a[], int n) {
        for(int i=2;i<n-1;i+=2) {
            if(a[i-1] > a[i]) {
                swap(a,i,i-1);
            }
            if (a[i] < a[i+1]) {
                swap(a,i,i+1);
            }
        }
    }
    
    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

import java.util.Arrays;
/**
 * Convert array into Zig-Zag fashion
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {4, 3, 7, 8, 6, 2, 1};
        int n = a.length;
        System.out.println(Arrays.toString(a));
        boolean flag = true;
        for(int i=0;i<n-1;i++) {
            if(flag && a[i] > a[i+1]) {
                swap(a, i, i+1);
            } else if(!flag && a[i] < a[i+1]) {
                swap(a,i,i+1);
            }
            flag = !flag;
        }
        System.out.println(Arrays.toString(a));
    }
    
    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
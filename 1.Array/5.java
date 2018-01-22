import java.util.Arrays;
/**
 * Rearrange array to put positive no at even and negative at odd position
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = a.length;
        System.out.println(Arrays.toString(a));
        rearrange(a, n);
        System.out.println(Arrays.toString(a));
    }

    static void rearrange(int a[], int n) {
        int i=0;
        for(int j=0;j<n;j++) {
            if(a[j] < 0) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }
        int neg = 0, pos = i;
        while(neg < pos && pos < n && a[neg] < 0) {
            int temp = a[neg];
            a[neg] = a[pos];
            a[pos] = temp;
            pos++;
            neg+=2;
        }
    }
}

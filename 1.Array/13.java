import java.util.Arrays;
/**
 * Longest Bitonic Subsequence - DP
 * 
 * Space Complexity O(n)
 * Time Complexity  O(n^2)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(Arrays.toString(a));
        System.out.println(bitonic(a));
    }
    static int bitonic(int a[]) {
        int n = a.length;
        int lis[] = new int[n];
        int lds[] = new int[n];
        for(int i=0;i<n;i++) {
            lis[i] = 1;
            lds[i] = 1;
        }
        int i, j, max;
        for(i=1;i<n;i++) {
            for(j=0;j<i;j++) {
                if(a[i] > a[j] && lis[i] < lis[j] +1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        for(i=n-2;i>=0;i--) {
            for(j=n-1;j>i;j--) {
                if(a[i] > a[j] && lds[i] < lds[j] +1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        max = lds[0]+lis[0] -1;
        for(i=1;i<n;i++) {
            if(lds[i]+lis[i]-1 > max) {
                max=lds[i]+lis[i]-1;
            }
        }
        return max;
    }
}

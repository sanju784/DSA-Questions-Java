import java.util.Arrays;
/**
 * Largest Sum Contiguous Subarray
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(Arrays.toString(a));
        System.out.println("Maximum sum " + maxSum(a));
    }
    static int maxSum(int a[]) {
        int n = a.length;
        int s=0, e=0;
        int max_end_here = 0, max_sum=0;
        for(int i=0;i<n;i++) {
            max_end_here += a[i];
            if(max_end_here < 0) {
                max_end_here = 0;
                s = i+1;
            }
            if(max_sum < max_end_here) {
                max_sum = max_end_here;
                e = i;
            }
        }
        System.out.println("Start: " + s + ", End: " + e);
        return max_sum;
    }
}

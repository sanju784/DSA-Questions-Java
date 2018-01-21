import java.util.Arrays;
/**
 * Check if Pair of given sum is in rotated array
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {4, 5, 6, 7, 8, 1, 2, 3};
        int n = a.length;
        int key = 15;
        System.out.println(Arrays.toString(a));
        if(isPair(a,n,key))
            System.out.println("Pair is in array");
        else
            System.out.println("Pair is not in array");
    }

    static boolean isPair(int a[], int n, int key) {
        int i;
        for(i =0;i<n-1;i++) {
            if(a[i] > a[i+1])
                break;
        }
        
        int l = (i+1) % n;
        int r = i;
        
        while(l != r) {
            if(a[l] + a[r] == key)
                return true;
            if(a[l] + a[r] < key)
                l = (l+1) % n;
            else
                r = (n+r-1)%n;
        }
        return false;
    }
}

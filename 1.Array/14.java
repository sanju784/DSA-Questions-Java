import java.util.Arrays;
/**
 * Find a sorted subsequence of size 3 in linear time
 * 
 * Space Complexity O(n)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {12, 11, 10, 5, 6, 2, 30};
        System.out.println(Arrays.toString(a));
        triplet(a);
    }
    static void triplet(int a[]) {
        int n = a.length;
        int min = 0, max = n-1;
        int smaller[] = new int[n];
        int greater[] = new int[n];
        smaller[0] = -1;
        greater[n-1] = -1;
        for(int i=1;i<n;i++) {
            if(a[i] < a[min]) {
                min = i;
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }
        for(int i=n-2;i>=0;i--) {
            if(a[i] > a[max]) {
                max = i;
                greater[i] = -1;
            } else {
                greater[i] = max;
            }
        }
        for(int i=0;i<n;i++) {
            if(smaller[i] != -1 && greater[i] != -1) {
                System.out.println(a[smaller[i]] +" "  + a[i] + " " + a[greater[i]]);
                return;
            }
        }
        System.out.println("No triplet");
    }
}

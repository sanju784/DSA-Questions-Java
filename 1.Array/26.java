import java.util.Arrays;
/**
 * Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in a binary array
 * (Using maximum sliding window)
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
        System.out.println(Arrays.toString(a));
        int wL =0, wR =0;
        int result = -1;
        int zeroCount =0;
        while(wR < a.length) {
            if(zeroCount <= 1) {
                if(a[wR] == 0) {
                    zeroCount++;
                    result = wR;
                }
                wR++;
            }
            if(zeroCount > 1) {
                if(a[wL] == 0)
                    zeroCount--;
                wL++;
            }
        }
        System.out.println(result);
    }
}
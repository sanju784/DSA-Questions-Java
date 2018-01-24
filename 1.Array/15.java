import java.util.Arrays;
/**
 * Largest subarray with equal number of 0s and 1s
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n^2)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {1, 0, 0, 1, 0, 1, 1};
        System.out.println(Arrays.toString(a));
        findSubArray(a);
    }
    static void findSubArray(int a[]) {
        int n = a.length;
        int sum = 0;
        int maxSize = -1;
        int startIndex = 0;
        int endIndex = 0;
        
        for(int i=0;i<n-1;i++) {
            sum = (a[i] == 0) ? -1:1;
            for(int j=i+1;j<n;j++) {
                if(a[j] == 0) {
                    sum += -1;
                } else {
                    sum += 1;
                }
                if(sum == 0 && maxSize < j-1+1) {
                    maxSize = j-i+1;
                    startIndex = i;
                }
            }
        }
        endIndex = startIndex + maxSize -1;
        if(maxSize == -1)
            System.out.println("No such subarray");
        else
            System.out.println(startIndex + " " + endIndex);
    }
}

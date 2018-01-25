import java.util.Arrays;
/**
 * Partition an array into two equal sums
 * 
 * Space Complexity O(sum*n)
 * Time Complexity  O(sum*n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {1,5,11,5};
        System.out.println(Arrays.toString(a));
        if(partition(a)) {
            System.out.println("Partition possible");
        } else {
            System.out.println("Partition not possible");
        }
    }
    static boolean partition(int a[]) {
        int n = a.length;
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += a[i];
        }
        if(sum%2 != 0)
            return false;
        boolean part[][] = new boolean[sum/2 +1][n+1];
        for(int i=0;i<=sum/2;i++)
            part[i][0] = true;
        for(int i=1;i<=n;i++)
            part[0][i] = false;
        for(int i=1;i<=sum/2;i++) {
            for(int j=1;j<=n;j++) {
                part[i][j] = true;
                if(i > a[j-1])
                    part[i][j] = part[i][j] || part[i-a[j-1]][j-1];
            }
        }
        
        return part[sum/2][n];
    }
}

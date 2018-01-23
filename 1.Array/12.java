import java.util.Arrays;
/**
 * Segregate even before odds in an array
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {12, 10, 9, 45, 2, 10, 10, 45};
        System.out.println(Arrays.toString(a));
        segregate(a);
        System.out.println(Arrays.toString(a));

    }
    static void segregate(int a[]) {
        int n = a.length;
        int j=0;
        for(int i=0;i<n;i++) {
            if(a[i]%2 == 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
        }
    }
}

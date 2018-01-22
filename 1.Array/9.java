import java.util.Arrays;
import java.util.Comparator;
/**
 * Sort an array according to absolute difference with given value
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        Integer a[] = {10, 5, 3, 9, 2};
        int n = a.length;
        int x = 7;
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, new Comparator<Integer> () {
            public int compare(Integer a, Integer b) {
                int diff1 = Math.abs(x-a);
                int diff2 = Math.abs(x-b);
                return diff1-diff2;
            }
        });
        System.out.println(Arrays.toString(a));
    }
}

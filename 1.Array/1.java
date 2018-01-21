import java.util.Arrays;
/**
 * Array rotation by Reversal Algorithm
 * 
 * Space Complexity O(1)
 * Time Complexity  O(n)
 */
class Array {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int d = 3;
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        reverse(arr, 0, d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }
    static void reverse(int arr[], int start, int end) {
        while (start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

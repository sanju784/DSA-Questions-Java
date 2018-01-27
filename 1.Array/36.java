import java.util.Collections;
import java.util.PriorityQueue;
/**
 * K’th Smallest/Largest Element in Unsorted Array
 * 
 * Space Complexity O(k)
 * Time Complexity  O(k+(n-k)Logk)
 */
class Array {
    public static void main(String[] args) {
        int a[] = {7, 10, 4, 3, 20, 15};
        int n = a.length;
        int k = 4;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        for(int i=0;i<k;i++) {
            pq.offer(a[i]);
        }
        for(int i=k;i<n;i++) {
            if(a[i] < pq.peek()) {
                pq.poll();
                pq.offer(a[i]);
            }
        }
        System.out.println(k+ "th smallest number is " +pq.peek());
    }
}
import java.util.*;

/**
 * Sliding Window Maximum
 * 
 * Time  Complexity - O(n)
 * Space Complexity - O(k)
 */
class stack {
       
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        System.out.println(Arrays.toString(a));
        slidingWindow(a, k);
    }
    
    static void slidingWindow(int a[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++) {
            pq.offer(a[i]);
        }
        for(int i=k;i<a.length;i++) {
            System.out.print(pq.peek() + " ");
            pq.remove(a[i-k]);
            pq.offer(a[i]);
        }
        System.out.println(pq.poll());
        pq.clear();
    }
}

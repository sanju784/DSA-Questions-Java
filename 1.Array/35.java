import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Kth smallest element in a row-wise and column-wise sorted 2D array
 * 
 * Space Complexity O(n)
 * Time Complexity  O(n+kLogn)
 */
class Array {
    public static void main(String[] args) {
        int a[][] = { {10, 20, 30, 40},
                    {15, 25, 35, 45},
                    {25, 29, 37, 48},
                    {32, 33, 39, 50}};
        int n = 4;
        int k = 7;
        PriorityQueue<PQNode> pq = new PriorityQueue<>(n, new Comparator<PQNode> () {
            public int compare(PQNode o1, PQNode o2) {
                return o1.data - o2.data;
            }
        });
        for(int i=0;i<n;i++) {
            pq.offer(new PQNode(a[0][i], 0, i));
        }
        PQNode node = null;
        for(int i=0;i < k;i++) {
            node = pq.poll();
            if(node.r < n-1) {
                PQNode newNode = new PQNode(a[node.r +1][node.c], node.r+1, node.c);
                pq.offer(newNode);
            }
        }
        System.out.println(k+ "th smallest is "+node.data);
    }
}

class PQNode{
    int data;
    int r;
    int c;
    public PQNode(int data, int r, int c) {
        this.data = data;
        this.r = r;
        this.c = c;
    }
}
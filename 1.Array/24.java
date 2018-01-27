import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Merge k sorted array into a single array
 * 
 * Space Complexity O(k)
 * Time Complexity  O(nkLogk)
 */
class Array {
    public static void main(String[] args) {
        int a[][] = {{2, 6, 12, 34},
                     {1,9,20,1000},
                     {23,34,90,2000}};
        int k = 3;
        int n = 4;
        int res[] = new int[n*k];
        PriorityQueue<PQNode> pq = new PriorityQueue<>(k, new Comparator<PQNode>(){
            public int compare(PQNode o1, PQNode o2) {
                return o1.data - o2.data;
            }
        });
        for(int i=0;i<k;i++) {
            pq.offer(new PQNode(a[i][0], 1, i));
        }
        int j=0;
        while(!pq.isEmpty()) {
            PQNode node = pq.poll();
            res[j] = node.data;
            if(node.nextIndex < n) {
                pq.offer(new PQNode(a[node.arrIndex][node.nextIndex], node.nextIndex+1, node.arrIndex));
            }
            j++;
        }
        System.out.println(Arrays.toString(res));
    }
}

class PQNode {
    int data;
    int nextIndex;
    int arrIndex;
    public PQNode(int data, int nextIndex, int arrIndex) {
        this.data = data;
        this.nextIndex = nextIndex;
        this.arrIndex = arrIndex;
    }
}

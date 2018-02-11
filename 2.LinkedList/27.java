/**
 * Delete N nodes after M nodes
 * 
 * Time  Complexity - O(n)
 * Space Complexity - O(1)
 */
class Node {
    int data;
    Node next;
    public Node(int n) {
        data = n;
        next = null;
    }
}

class LinkedList {
        static Node head = null;
        
        void printList(Node node) {
            while(node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println("");
        }
        
        void createList() {
            for(int i=10;i>0;i--) {
                Node newNode = new Node(i);
                newNode.next = head;
                head = newNode;
            }
        }
        
        public static void main(String[] args) {
            LinkedList ll = new LinkedList();
            ll.createList();
            ll.printList(head);
            int M = 3;
            int N = 2;
            ll.deleteN(M, N);
            ll.printList(head);
        }
        
        void deleteN(int m, int n) {
            Node prev = head;
            Node next = head;
            while(prev != null && next != null) {
                int i=1;
                while(i<m && prev != null) {
                    prev = prev.next;
                    i++;
                }
                next = prev.next;
                i = 0;
                while(i<n && next != null){
                    i++;
                    next = next.next;
                }
                prev.next = next;
                prev = next;
            }
        }
}
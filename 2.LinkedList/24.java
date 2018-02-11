/**
 * Subtract Two Numbers represented as Linked Lists
 * 
 * Time  Complexity - O(n)
 * Space Complexity - O(n)
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
        static Node head1 = null;
        static Node head2 = null;
        static Node result = null;
        
        static void printList(Node node) {
            while(node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println("");
        }
        
        static void push(int val, int list){
            Node newNode = new Node(val);
            if(list == 1) {
                newNode.next = head1;
                head1 = newNode;
            }
            if(list == 2) {
                newNode.next = head2;
                head2 = newNode;
            }
            if(list == 3) {
                newNode.next = result;
                result = newNode;
            }
        }
        
        static void createList() {
            push(6,1);
            push(8,1);
            push(7,1);
            push(9,2);
            push(8,2);
            push(7,2);
        }
        
        public static void main(String[] args) {
            createList();
            printList(head1);
            printList(head2);
            preSub(head1, head2);
            printList(result);
        }
        static boolean borrow = false;
        static void substract(Node a, Node b) {
            if(a == null || b == null) return;
            substract(a.next, b.next);
            int diff;
            if(borrow) {
                a.data = a.data - 1;
            }
            if(a.data < b.data) {
                diff = (10 + a.data) - b.data;
                borrow = true;
            } else {
                diff = a.data - b.data;
                borrow = false;
            }
            push(diff, 3);
        }
        
        static void preSub(Node h1, Node h2) {
            int len1 = 0, len2 = 0, sum1 = 0, sum2 = 0;
            Node a = h1, b = h2;
            while(a != null) {
                len1++;
                sum1 += a.data;
                a = a.next;
            }
            while(b != null) {
                len2++;
                sum2 += b.data;
                b = b.next;
            }
            int diff;
            if(len1 > len2) {
                diff = len1 - len2;
                while(diff > 0) {
                    push(0, 2);
                    diff--;
                }
                substract(head1,head2);
            }
            else if(len2 > len1) {
                diff = len2 - len1;
                while(diff > 0) {
                    push(0, 1);
                    diff--;
                }
                substract(head2,head1);
            }
            else {
                if(sum1 > sum2) {
                    substract(head1,head2);
                } else {
                    substract(head2,head1);
                }
            }
        }
}
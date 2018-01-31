/**
 * Reverse Linked List in group of k
 * 
 * Time  Complexity - O(n)
 * Space Complexity - O(k) Auxillary
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
    static void insertAtFirst(int n) {
        Node newNode = new Node(n);
        newNode.next = head;
        head = newNode;
    }
    static void print(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]) {
        insertAtFirst(8);
        insertAtFirst(7);
        insertAtFirst(6);
        insertAtFirst(5);
        insertAtFirst(4);
        insertAtFirst(3);
        insertAtFirst(2);
        insertAtFirst(1);
        int k = 3;
        print(head);
        head = reverseK(head, k);
        print(head);
    }
    
    static Node reverseK(Node head, int k) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next != null)
            head.next = reverseK(next, k);
        
        return prev;
    }
}
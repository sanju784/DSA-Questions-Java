/**
 * Merge Sort of Linked List
 * 
 * Time  Complexity - O(nLogn)
 * Space Complexity - O(n) - Auxillary space
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
        insertAtFirst(15);
        insertAtFirst(10);
        insertAtFirst(5);
        insertAtFirst(20);
        insertAtFirst(3);
        insertAtFirst(2);
        print(head);
        head = mergeSort(head);
        print(head);
    }

    static Node getMiddle(Node h) {
        if(h == null)
            return h;
        Node slow = h;
        Node fast = h.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    static Node mergeSort(Node h) {
        if(h == null || h.next == null) {
            return h;
        }
        Node middle = getMiddle(h);
        Node middleNext = middle.next;
        middle.next = null;
        
        Node left = mergeSort(h);
        Node right = mergeSort(middleNext);
        Node sortedList = merge(left, right);
        return sortedList;
    }
    
    static Node merge(Node a, Node b) {
        Node result = null;
        if(a == null)
            return b;
        if(b == null)
            return a;
        if(a.data < b.data) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }
}
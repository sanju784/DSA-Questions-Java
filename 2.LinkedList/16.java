/**
 * Merge two sorted Linked List
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
    static Node head1 = null;
    static Node headRes = null;
    static void insertAtFirst(int n) {
        Node newNode = new Node(n);
        newNode.next = head;
        head = newNode;
    }
    static void print(Node temp) {
        //Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]) {
        insertAtFirst(5);
        insertAtFirst(3);
        insertAtFirst(2);
        insertAtFirst(1);
        head1 = head;
        print(head1);
        head = null;
        insertAtFirst(8);
        insertAtFirst(7);
        insertAtFirst(6);
        insertAtFirst(4);
        print(head);
        headRes = mergeList();
        print(headRes);
    }

    static Node mergeList() {
        Node temp1 = head;
        Node temp2 = head1;
        Node last = null;
        while(temp1 != null && temp2 != null) {
            if(temp1.data < temp2.data) {
                if(headRes == null) {
                    headRes = temp1;
                    last = headRes;
                } else {
                    last.next = temp1;
                    last = last.next;
                }
                temp1 = temp1.next;
            } else {
                if(headRes == null) {
                    headRes = temp2;
                    last = temp2;
                } else {
                    last.next = temp2;
                    last = last.next;
                }
                temp2 = temp2.next;
            }
            if(temp1 == null)
                last.next = temp2;
            else
                last.next = temp1;
        }
        return headRes;
    }
}
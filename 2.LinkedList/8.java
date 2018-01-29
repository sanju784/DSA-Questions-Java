/**
 * Swap nodes in Linked List without swapping data
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
    static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]) {
        insertAtFirst(14);
        insertAtFirst(20);
        insertAtFirst(13);
        insertAtFirst(12);
        insertAtFirst(15);
        insertAtFirst(10);
        print();
        swap(12, 13);
        print();
        swap(15,20);
        print();
    }

    static void swap(int n1, int n2) {
        Node temp = head;
        Node prev1=null, node1=null, prev2=null, node2=null;
        while(temp != null) {
            if(temp.next.data == n1) {
                prev1 = temp;
                node1 = temp.next;
            }
            if(temp.next.data == n2) {
                prev2 = temp;
                node2 = temp.next;
            }
            if(node1 != null && node2 != null) {
                break;
            }
            temp=temp.next;
        }
        if(node1.next == node2) {
            prev1.next = node2;
            node1.next = node2.next;
            node2.next = node1;
        } else {
            temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;
            prev1.next = node2;
            prev2.next = node1;
        }
    }
}
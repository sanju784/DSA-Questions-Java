/**
 * Detect loop in Linked List
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
        insertAtFirst(1);
        insertAtFirst(2);
        insertAtFirst(3);
        insertAtFirst(4);
        insertAtFirst(5);
        insertAtFirst(6);
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next;
        isLoop();
    }

    static void isLoop() {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                System.out.println("Loop present");
                break;
            }
        }
        if(fast == null)
            System.out.println("No loop");
    }
}
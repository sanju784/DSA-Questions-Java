/**
 * Check if Linked List is Palindrome
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
    static Node mid;
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
        insertAtFirst(3);
        insertAtFirst(2);
        insertAtFirst(1);
        print();
        isPalindrom();
    }

    static void isPalindrom() {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow.next;
        slow.next = null;
        reverse();
        if(compare(head, mid)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindome");
        }
        reverse();
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = mid;
        print();
    }
    static void reverse() {
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid = prev;
    }
    
    static boolean compare(Node a, Node b) {
        while(a.next != null) {
            if(a.data != b.data) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return true;
    }
}
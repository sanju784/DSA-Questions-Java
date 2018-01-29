/**
 * Generic Linked List
 */
class Node<T> {
    T data;
    Node next;
    public Node(T n) {
        data = n;
        next = null;
    }
}
class List {
    static Node head;
    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        print();
        head = null;
        head = new Node("Sanjeev");
        head.next = new Node("Samsung");
        head.next.next = new Node("Hikari");
        print();
    }
    static void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }
}

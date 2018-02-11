/**
 * From a linked list of line segments remove middle points
 * 
 * Time  Complexity - O(n)
 * Space Complexity - O(1)
 */
class node {
    int x;
    int y;
    node next;
    public node(int x, int y) {
        this.x = x;
        this.y = y;
        next = null;
    }
}
class List {
    public static void main(String[] args) {
        node head = new node(0,10);
        head.next = new node(1, 10);
        head.next.next = new node(5, 10);
        head.next.next.next = new node(7, 10);
        head.next.next.next.next = new node(7, 5);
        head.next.next.next.next.next = new node(20, 5);
        head.next.next.next.next.next.next = new node(40, 5);
        print(head);
        remove(head);
        System.out.println("-------------");
        print(head);
    }
    static void print(node temp) {
        while(temp != null) {
            System.out.println(temp.x + " " + temp.y);
            temp = temp.next;
        }
    }
    static void remove(node h) {
        node prev = h, curr = h.next, next = curr.next;
        while(next != null) {
            if((prev.x == curr.x && curr.x == next.x) || (prev.y == curr.y && curr.y == next.y)) {
                prev.next = next;
                curr = next;
                next = curr.next;
            } else {
                prev = curr;
                curr = next;
                next = curr.next;
            }
        }
    }
}

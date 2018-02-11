/**
 * Flatten a multilevel linked list
 * 
 * Time  Complexity - O(n) - n is total nodes in list
 * Space Complexity - O(1)
 */
class Node {
    int data;
    Node next;
    Node child;
    public Node(int n) {
        data = n;
        next = child = null;
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
        Node createList() {
            int arr1[] = {10,5,12,7,11};
            int arr2[] = {4,20,3};
            int arr3[] = {17,6};
            int arr4[] = {9,8};
            int arr5[] = {19,15};
            int arr6[] = {2};
            int arr7[] = {16};
            int arr8[] = {3};
            Node head1 = createList(arr1, arr1.length);
            Node head2 = createList(arr2, arr2.length);
            Node head3 = createList(arr3, arr3.length);
            Node head4 = createList(arr4, arr4.length);
            Node head5 = createList(arr5, arr5.length);
            Node head6 = createList(arr6, arr6.length);
            Node head7 = createList(arr7, arr7.length);
            Node head8 = createList(arr8, arr8.length);
            head1.child = head2;
            head1.next.next.next.child = head3;
            head3.child = head4;
            head4.child = head5;
            head2.next.child = head6;
            head2.next.next.child = head7;
            head7.child = head8;
            return head1;
        }

        Node createList(int a[], int n) {
            Node head = null;
            Node last = null;
            for(int i=0;i<n;i++) {
                if(head == null) {
                    head = last = new Node(a[i]);
                } else {
                    last.next = new Node(a[i]);
                    last = last.next;
                }
            }
            return head;
        }
        
        void flattenList(Node node) {
            if(node == null)
                return;
            Node temp = null;
            Node tail = node;
            while(tail.next != null) {
                tail = tail.next;
            }
            Node curr = node;
            while(curr != tail) {
                if(curr.child != null) {
                    tail.next = curr.child;
                    temp = curr.child;
                    while(temp.next != null) {
                        temp = temp.next;
                    }
                    tail = temp;
                }
                curr = curr.next;
            }
        }
        public static void main(String[] args) {
            LinkedList list = new LinkedList();
            head = list.createList();
            list.flattenList(head);
            list.printList(head);
        }
}
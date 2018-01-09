/**
	Nth node of Linked List - Recursive
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
	Node head = null;
	
	public void insertAtFirst(int n) {
		Node newNode = new Node(n);
		newNode.next = head;
		head = newNode;
	}
	
	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		ll.insertAtFirst(5);
		ll.insertAtFirst(4);
		ll.insertAtFirst(3);
		ll.insertAtFirst(2);
		ll.insertAtFirst(1);
		ll.print();
		int n = 3;
		int res = ll.getNth(ll.head, n);
		if(res != Integer.MIN_VALUE)
			System.out.println(n + " is at " + res + " position of Linked List");
		else
			System.out.println(n + " is not in Linked List");
	}

	public int getNth(Node head, int n) {
		int c = 1;
		if(head == null)
			return Integer.MIN_VALUE;
		if(c == n) {
			return head.data;
		}
		c++;
		return getNth(head.next, n-1);
	}
}
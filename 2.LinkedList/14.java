/**
	Reverse Linked List
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
		ll.head = ll.reverse(ll.head);
		ll.print();
	}

	public Node reverse(Node h) {
		Node prev = null;
		Node current = h;
		Node next;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		h = prev;
		return h;
	}
}